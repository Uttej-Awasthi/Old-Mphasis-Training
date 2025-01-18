// editRecordModal.js
import { LightningElement, api, track } from 'lwc';
import getFieldSetFields from '@salesforce/apex/NestedRelatedListController.getFieldSetFields';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';

export default class EditRecordModal extends LightningElement {
    @api recordId;
    @api objectApiName;
    @api fieldSet;

    @track fields = [];

    connectedCallback() {
        this.loadFieldSetFields();
    }

    @api
    refreshFields() {
        this.loadFieldSetFields();
    }

    loadFieldSetFields() {
        if (this.objectApiName && this.fieldSet) {
            getFieldSetFields({ objectName: this.objectApiName, fieldSetName: this.fieldSet })
                .then(result => {
                    this.fields = result;
                })
                .catch(error => {
                    console.error('Error fetching field set fields', error);
                });
        }
    }

    handleSuccess(event) {
        const updatedFields = event.detail.fields;
        
        // Create an object with only the updated field values
        const updatedRecord = Object.keys(updatedFields).reduce((acc, fieldName) => {
            acc[fieldName] = updatedFields[fieldName].value;
            return acc;
        }, {});
    
        this.dispatchEvent(new ShowToastEvent({
            title: 'Success',
            message: 'Record updated successfully',
            variant: 'success'
        }));
    
        // Dispatch a custom event with only the updated fields
        this.dispatchEvent(new CustomEvent('recordupdated', { 
            detail: { 
                recordId: this.recordId,
                fields: updatedRecord
            }
        }));
    
        this.dispatchEvent(new CustomEvent('close', { detail: { success: true } }));
    }

    handleCancel() {
        this.dispatchEvent(new CustomEvent('close')); // Close the modal without saving
    }

    handleSave() {
        this.template.querySelector('lightning-record-edit-form').submit(); // Trigger the save operation
    }
}