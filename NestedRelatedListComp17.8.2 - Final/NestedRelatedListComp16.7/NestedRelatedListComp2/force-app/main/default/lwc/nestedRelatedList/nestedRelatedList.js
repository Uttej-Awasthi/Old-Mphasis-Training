// nestedRelatedList.js
import { LightningElement, api, track } from 'lwc';
import { NavigationMixin } from 'lightning/navigation';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';
import getChildRecords from '@salesforce/apex/NestedRelatedListController.getChildRecords';
import deleteRecord from '@salesforce/apex/NestedRelatedListController.deleteRecord';

export default class NestedRelatedList extends NavigationMixin(LightningElement) {
    @api recordId;
    @api parentObjectApiName;
    @api childObjectApiName;
    @api grandchildObjectApiName;
    @api childFieldset;
    @api grandchildFieldset;
    @api parentField;
    @api childField;

    @track columns = [];
    @track flattenedRecords = [];
    @track sortBy = 'Name';
    @track sortDirection = 'asc';
    @track searchTerm = '';
    @track pageNumber = 1;
    @track pageSize = 10;
    @track totalRecords = 0;
    @track isEditModalOpen = false;
    @track recordIdToEdit;
    @track objectApiNameToEdit;
    @track columnSearchTerms = {};
    @track lastUpdated;

    isResizing = false;
    resizeColumnField = '';
    initialWidth = 0;
    initialX = 0;

    connectedCallback() {
        if (!this.parentObjectApiName) {
            // If parentObjectApiName is not provided, get it from the record page
            this.parentObjectApiName = this.getObjectApiName();
        }
        this.loadChildRecords();
        this.updateLastUpdatedTime();
    }

    get objectHierarchyTitle() {
        return `${this.parentObjectApiName || 'Parent'} > ${this.childObjectApiName || 'Child'} > ${this.grandchildObjectApiName || 'Grandchild'} Records`;
    }
    // The objectHierarchyTitle getter ensures that even if one of the object names is not provided, you'll still have a meaningful string (using 'Parent', 'Child', or 'Grandchild' as fallbacks).

    getObjectApiName() {
        const pageRef = this.pageReference;
        if (pageRef && pageRef.attributes && pageRef.attributes.objectApiName) {
            return pageRef.attributes.objectApiName;
        }
        return null;
    }


    handleResizeStart(event) {
        this.isResizing = true;
        this.resizeColumnField = event.target.closest('th').dataset.field;
        const column = this.template.querySelector(`th[data-field="${this.resizeColumnField}"]`);
        this.initialWidth = column.offsetWidth;
        this.initialX = event.clientX;
        event.preventDefault();
        
        window.addEventListener('mousemove', this.handleResizeMove);
        window.addEventListener('mouseup', this.handleResizeEnd);
    }
    
    handleResizeMove = (event) => {
        if (this.isResizing) {
            const diffX = event.clientX - this.initialX;
            const newWidth = Math.max(this.initialWidth + diffX, 50);
            const column = this.template.querySelector(`th[data-field="${this.resizeColumnField}"]`);
            if (column) {
                column.style.width = `${newWidth}px`;
                const columnIndex = this.columns.findIndex(col => col.fieldName === this.resizeColumnField);
                if (columnIndex !== -1) {
                    this.columns[columnIndex].style = `width: ${newWidth}px;`;
                }
            }
        }
    }
    
    handleResizeEnd = () => {
        this.isResizing = false;
        this.resizeColumnField = '';
        this.initialWidth = 0;
        this.initialX = 0;
        
        window.removeEventListener('mousemove', this.handleResizeMove);
        window.removeEventListener('mouseup', this.handleResizeEnd);
    }

    loadChildRecords() {
        this.columnSearchTerms = {}; // Reset column search terms
        getChildRecords({ 
            parentObjectApiName: this.parentObjectApiName,
            childObjectApiName: this.childObjectApiName, 
            parentField: this.parentField, 
            parentId: this.recordId, 
            childFieldset: this.childFieldset,
            pageSize: this.pageSize,
            pageNumber: this.pageNumber,
            sortBy: this.sortBy,
            sortDirection: this.sortDirection,
            searchTerm: this.searchTerm
        })
        .then(result => {
            this.columns = this.updateColumnsWithSortData(result.columns);
            this.processRecords(result.records);
            this.totalRecords = result.totalRecords;
            this.updateLastUpdatedTime();            
        })
        .catch(error => {
            console.error('Error loading child records', error);
            this.showToast('Error', 'Error loading child records: ' + error.body.message, 'error');
        });
    }

    handleRecordUpdated(event) {
        const updatedRecordId = event.detail.recordId;
        const updatedFields = event.detail.fields;
    
        // Find the index of the updated record in the flattenedRecords array
        const recordIndex = this.flattenedRecords.findIndex(record => record.id === updatedRecordId);
    
        if (recordIndex !== -1) {
            // Create a new object for the updated record
            const updatedRecord = { ...this.flattenedRecords[recordIndex] };
            
            // Update only the fields that were changed
            for (let field in updatedFields) {
                const fieldIndex = updatedRecord.fields.findIndex(f => f.name === field);
                if (fieldIndex !== -1) {
                    updatedRecord.fields[fieldIndex] = {
                        ...updatedRecord.fields[fieldIndex],
                        value: updatedFields[field].value
                    };
                }
            }
            
            // Create a new array with the updated record
            this.flattenedRecords = [
                ...this.flattenedRecords.slice(0, recordIndex),
                updatedRecord,
                ...this.flattenedRecords.slice(recordIndex + 1)
            ];
    
            // Force a re-render
            this.flattenedRecords = [...this.flattenedRecords];
    
            // Update last updated time
            this.updateLastUpdatedTime();
        }
    }

    refreshSingleRecord(recordId) {
        getChildRecords({ 
            childObjectApiName: this.childObjectApiName, 
            parentField: this.parentField, 
            parentId: this.recordId, 
            childFieldset: this.childFieldset,
            pageSize: 1,
            pageNumber: 1,
            sortBy: this.sortBy,
            sortDirection: this.sortDirection,
            searchTerm: '',
            recordId: recordId  // Add this parameter to your Apex method
        })
        .then(result => {
            if (result.records && result.records.length > 0) {
                const refreshedRecord = this.createFlattenedRecord(result.records[0]);
                const index = this.flattenedRecords.findIndex(r => r.id === recordId);
                if (index !== -1) {
                    this.flattenedRecords = [
                        ...this.flattenedRecords.slice(0, index),
                        refreshedRecord,
                        ...this.flattenedRecords.slice(index + 1)
                    ];
                }
            }
        })
        .catch(error => {
            console.error('Error refreshing single record', error);
        });
    }

    updateLastUpdatedTime() {
        this.lastUpdated = new Date();
    }

    get lastUpdatedFormatted() {
        if (this.lastUpdated) {
            return this.lastUpdated.toLocaleString();
        }
        return 'N/A';
    }

    updateColumnsWithSortData(columns) {
        return columns.map(column => ({
            ...column,
            sortIconName: this.getSortIconName(column.fieldName),
            sortDirection: this.getSortDirection(column.fieldName),
            sortAssistiveText: this.getSortAssistiveText(column.fieldName),
            isNameField: column.type === 'Name' || column.fieldName === 'Name',
            searchInputClass: 'search-input'
        }));
    }

    getSortIconName(fieldName) {
        return this.sortBy !== fieldName ? 'utility:arrowdown' : 
               (this.sortDirection === 'asc' ? 'utility:arrowup' : 'utility:arrowdown');
    }

    getSortDirection(fieldName) {
        return this.sortBy === fieldName ? this.sortDirection : 'none';
    }

    getSortAssistiveText(fieldName) {
        return this.sortBy === fieldName ? `Sorted ${this.sortDirection === 'asc' ? 'ascending' : 'descending'}` : '';
    }

    processRecords(records) {
        this.flattenedRecords = records.map(record => {
            const flatRecord = this.createFlattenedRecord(record);
            flatRecord.grandchildKey = record.Id + '-grandchild';
            return flatRecord;
        });
    }

    createFlattenedRecord(record) {
        return {
            id: record.Id,
            name: record.Name || '',
            hasChildren: true,
            isExpanded: false,
            buttonIcon: 'utility:chevronright',
            rowClass: 'slds-hint-parent slds-is-collapsed',
            level: 1,
            fields: this.columns.map(column => ({
                name: column.fieldName,
                value: record[column.fieldName],
                label: column.label,
                isNameField: column.type === 'Name' || column.fieldName === 'Name' || column.fieldName === 'FullName'
            }))
        };
    }

    handleNameClick(event) {
        event.preventDefault();
        const recordId = event.currentTarget.dataset.recordId;
        const objectName = event.currentTarget.dataset.objectName;
    
        this[NavigationMixin.Navigate]({
            type: 'standard__recordPage',
            attributes: {
                recordId: recordId,
                objectApiName: objectName,
                actionName: 'view'
            }
        });
    }

    handleRowToggle(event) {
        const recordId = event.currentTarget.dataset.id;
        const recordIndex = this.flattenedRecords.findIndex(r => r.id === recordId);
        if (recordIndex !== -1) {
            const record = this.flattenedRecords[recordIndex];
            record.isExpanded = !record.isExpanded;
            record.buttonIcon = record.isExpanded ? 'utility:chevrondown' : 'utility:chevronright';
            record.rowClass = `slds-hint-parent ${record.isExpanded ? 'slds-is-expanded' : 'slds-is-collapsed'}`;
            this.flattenedRecords = [...this.flattenedRecords];
        }
    }

    handleSort(event) {
        const fieldName = event.currentTarget.dataset.field;
        this.sortDirection = this.sortBy === fieldName && this.sortDirection === 'asc' ? 'desc' : 'asc';
        this.sortBy = fieldName;
        this.loadChildRecords();
    }

    handleSearch(event) {
        this.searchTerm = event.target.value;
        this.loadChildRecords();
    }

    handleRowAction(event) {
        const action = event.detail.value;
        const recordId = event.currentTarget.dataset.recordId;

        if (action === 'edit') {
            this.editRecord(recordId);
        } else if (action === 'delete') {
            this.deleteChildRecord(recordId);
        }
    }

    editRecord(recordId) {
        this.recordIdToEdit = recordId;
        this.objectApiNameToEdit = this.childObjectApiName;
        this.isEditModalOpen = true;
    }

    closeModal(event) {
        this.isEditModalOpen = false;
        if (event.detail && event.detail.success) {
            // Refresh the single updated record
            this.refreshSingleRecord(this.recordIdToEdit);
        }
    }

    refreshChildRecord(recordId) {
        getChildRecords({ 
            childObjectApiName: this.childObjectApiName, 
            parentField: this.parentField, 
            parentId: this.recordId, 
            childFieldset: this.childFieldset,
            pageSize: 1,
            pageNumber: 1,
            sortBy: this.sortBy,
            sortDirection: this.sortDirection,
            searchTerm: ''
        })
        .then(result => {
            if (result.records && result.records.length > 0) {
                const updatedRecord = this.createFlattenedRecord(result.records[0]);
                const index = this.flattenedRecords.findIndex(r => r.id === recordId);
                if (index !== -1) {
                    this.flattenedRecords[index] = { ...this.flattenedRecords[index], ...updatedRecord };
                    this.flattenedRecords = [...this.flattenedRecords];
                }
            }
        })
        .catch(error => {
            console.error('Error refreshing child record', error);
        });
    }

    get editFieldset() {
        return this.childFieldset;
    }

    deleteChildRecord(recordId) {
        deleteRecord({ recordId: recordId, objectApiName: this.childObjectApiName })
        .then(() => {
            this.showToast('Success', 'Child record deleted successfully.', 'success');
            this.removeRecordFromList(recordId);
        })
        .catch(error => {
            console.error('Error deleting child record', error);
            this.showToast('Error', 'Error deleting child record: ' + error.body.message, 'error');
        });
    }

    removeRecordFromList(recordId) {
        this.flattenedRecords = this.flattenedRecords.filter(record => record.id !== recordId);
    }

    handlePrevious() {
        if (this.pageNumber > 1) {
            this.pageNumber -= 1;
            this.loadChildRecords();
        }
    }

    handleNext() {
        if (this.pageNumber < Math.ceil(this.totalRecords / this.pageSize)) {
            this.pageNumber += 1;
            this.loadChildRecords();
        }
    }

    showToast(title, message, variant) {
        const event = new ShowToastEvent({
            title: title,
            message: message,
            variant: variant,
        });
        this.dispatchEvent(event);
    }

    get columnCount() {
        return this.columns.length + 2; // +2 for the expand/collapse column and actions column
    }

    toggleSearchInput(event) {
        const field = event.target.dataset.field;
        const column = this.columns.find(col => col.fieldName === field);
        if (column) {
            column.searchInputClass = column.searchInputClass === 'search-input' ? 'search-input show' : 'search-input';
            this.columns = [...this.columns];
        }
    }
    
    handleColumnSearch(event) {
        const field = event.target.dataset.field;
        const searchTerm = event.target.value.toLowerCase();
        
        if (searchTerm === '') {
            // If search term is cleared, remove it from columnSearchTerms
            delete this.columnSearchTerms[field];
        } else {
            this.columnSearchTerms[field] = searchTerm;
        }
        
        // Reset to first page when search terms change
        this.pageNumber = 1;
        
        // If all search terms are cleared, reload the initial data
        if (Object.keys(this.columnSearchTerms).length === 0) {
            this.loadChildRecords();
        } else {
            this.filterRecords();
        }
    }

    filterRecords() {
        if (Object.keys(this.columnSearchTerms).length === 0) {
            // If all search terms are cleared, reload the initial data
            this.loadChildRecords();
        } else {
            const filteredRecords = this.flattenedRecords.filter(record => {
                return Object.keys(this.columnSearchTerms).every(field => {
                    const value = record.fields.find(f => f.name === field)?.value;
                    const searchTerm = this.columnSearchTerms[field];
                    return !searchTerm || (value && value.toString().toLowerCase().includes(searchTerm));
                });
            });
            this.flattenedRecords = [...filteredRecords];
        }
    }

    get isPreviousDisabled() {
        return this.pageNumber <= 1;
    }

    get isNextDisabled() {
        return this.pageNumber >= Math.ceil(this.totalRecords / this.pageSize);
    }
}