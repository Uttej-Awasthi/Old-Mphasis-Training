// grandchildRelatedList.js
import { LightningElement, api, track } from 'lwc';
import getGrandchildRecords from '@salesforce/apex/NestedRelatedListController.getGrandchildRecords';
import deleteRecord from '@salesforce/apex/NestedRelatedListController.deleteRecord';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';

export default class GrandchildRelatedList extends LightningElement {
    @api childId;
    @api grandchildObjectApiName;
    @api grandchildFieldset;
    @api childField;

    @track columns = [];
    @track grandchildRecords = [];
    @track filteredRecords = [];
    @track isLoading = true;
    @track sortBy;
    @track sortDirection = 'asc';
    @track isEditModalOpen = false;
    @track recordIdToEdit;
    @track searchTerms = {};

    @api
    refreshData() {
        this.loadGrandchildRecords();
    }

    handleRecordUpdated(event) {
        const updatedRecordId = event.detail.recordId;
        const updatedFields = event.detail.fields;

        // Find the index of the updated record in the grandchildRecords array
        const recordIndex = this.grandchildRecords.findIndex(record => record.Id === updatedRecordId);

        if (recordIndex !== -1) {
            // Update the record in the grandchildRecords array
            const updatedRecord = { ...this.grandchildRecords[recordIndex] };
            for (let field in updatedFields) {
                updatedRecord[field] = updatedFields[field];
            }
            
            // Update the grandchildRecords array
            this.grandchildRecords = [
                ...this.grandchildRecords.slice(0, recordIndex),
                updatedRecord,
                ...this.grandchildRecords.slice(recordIndex + 1)
            ];

            // Re-apply any active filters
            this.filterRecords();
        } else {
            // If the record is not found, refresh the single record from the server
            this.refreshSingleRecord(updatedRecordId);
        }
    }

    refreshSingleRecord(recordId) {
        getGrandchildRecords({
            grandchildObjectApiName: this.grandchildObjectApiName,
            childField: this.childField,
            childId: this.childId,
            grandchildFieldset: this.grandchildFieldset,
            recordId: recordId
        })
        .then(result => {
            if (result.records && result.records.length > 0) {
                const refreshedRecord = result.records[0];
                const index = this.grandchildRecords.findIndex(r => r.Id === recordId);
                if (index !== -1) {
                    this.grandchildRecords = [
                        ...this.grandchildRecords.slice(0, index),
                        refreshedRecord,
                        ...this.grandchildRecords.slice(index + 1)
                    ];
                    this.filterRecords();
                }
            }
        })
        .catch(error => {
            console.error('Error refreshing single record', error);
        });
    }

    connectedCallback() {
        this.loadGrandchildRecords();
    }

    loadGrandchildRecords() {
        this.isLoading = true;
        getGrandchildRecords({
            grandchildObjectApiName: this.grandchildObjectApiName,
            childField: this.childField,
            childId: this.childId,
            grandchildFieldset: this.grandchildFieldset
        })
        .then(result => {
            this.columns = this.transformColumns(result.columns);
            this.grandchildRecords = result.records;
            this.filteredRecords = [...this.grandchildRecords];
            this.isLoading = false;
        })
        .catch(error => {
            console.error('Error loading grandchild records', error);
            this.showToast('Error', 'Error loading grandchild records: ' + error.body.message, 'error');
            this.isLoading = false;
        });
    }

    transformColumns(columns) {
        let transformedColumns = columns.map(column => ({
            ...column,
            sortable: true,
            typeAttributes: {
                searchTerm: { fieldName: `${column.fieldName}_searchTerm` }
            }
        }));
        
        transformedColumns.push({
            type: 'action',
            typeAttributes: { rowActions: this.getRowActions },
        });

        return transformedColumns;
    }

    getRowActions(row, doneCallback) {
        const actions = [
            { label: 'Edit', name: 'edit' },
            { label: 'Delete', name: 'delete' }
        ];
        doneCallback(actions);
    }

    handleSort(event) {
        const { fieldName: sortedBy, sortDirection } = event.detail;
        this.sortBy = sortedBy;
        this.sortDirection = sortDirection;

        this.sortData(this.sortBy, this.sortDirection);
    }

    sortData(fieldName, direction) {
        let parseData = JSON.parse(JSON.stringify(this.filteredRecords));
        let keyValue = (a) => {
            return a[fieldName];
        };
        let isReverse = direction === 'asc' ? 1 : -1;

        parseData.sort((x, y) => {
            x = keyValue(x) ? keyValue(x) : '';
            y = keyValue(y) ? keyValue(y) : '';
            return isReverse * ((x > y) - (y > x));
        });

        this.filteredRecords = parseData;
    }

    handleRowAction(event) {
        const action = event.detail.action;
        const row = event.detail.row;
        switch (action.name) {
            case 'edit':
                this.editRecord(row);
                break;
            case 'delete':
                this.deleteRecord(row);
                break;
        }
    }

    editRecord(row) {
        this.recordIdToEdit = row.Id;
        this.isEditModalOpen = true;
    }

    closeEditModal(event) {
        this.isEditModalOpen = false;
        if (event.detail && event.detail.success) {
            // Refresh the single updated record
            this.refreshSingleRecord(this.recordIdToEdit);
        }
    }

    deleteRecord(row) {
        if (confirm('Are you sure you want to delete this record?')) {
            deleteRecord({ recordId: row.Id, objectApiName: this.grandchildObjectApiName })
                .then(() => {
                    this.showToast('Success', 'Record deleted successfully', 'success');
                    this.removeRecordFromList(row.Id);
                })
                .catch(error => {
                    console.error('Error deleting record', error);
                    this.showToast('Error', 'Error deleting record: ' + error.body.message, 'error');
                });
        }
    }

    removeRecordFromList(recordId) {
        this.grandchildRecords = this.grandchildRecords.filter(record => record.Id !== recordId);
        this.filterRecords();
    }

    showToast(title, message, variant) {
        const event = new ShowToastEvent({
            title: title,
            message: message,
            variant: variant,
        });
        this.dispatchEvent(event);
    }

    handleSearch(event) {
        const searchField = event.target.dataset.field;
        const searchTerm = event.target.value.toLowerCase();

        this.searchTerms[searchField] = searchTerm;
        this.filterRecords();
    }

    filterRecords() {
        this.filteredRecords = this.grandchildRecords.filter(record => {
            return Object.keys(this.searchTerms).every(field => {
                const value = record[field];
                const searchTerm = this.searchTerms[field];
                return !searchTerm || (value && value.toString().toLowerCase().includes(searchTerm));
            });
        });

        if (this.sortBy) {
            this.sortData(this.sortBy, this.sortDirection);
        }
    }
}