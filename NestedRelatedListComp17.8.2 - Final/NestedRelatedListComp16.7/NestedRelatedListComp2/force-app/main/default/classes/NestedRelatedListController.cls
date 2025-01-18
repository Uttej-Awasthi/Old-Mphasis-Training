// NestedRelatedListController.cls
public with sharing class NestedRelatedListController {
    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getParentRecords(String parentObjectApiName, String parentFieldset) {
        Map<String, Object> result = new Map<String, Object>();
        List<Map<String, String>> fields = getFieldSetFields(parentObjectApiName, parentFieldset);
        List<String> fieldNames = new List<String>();
        for (Map<String, String> field : fields) {
            fieldNames.add(field.get('fieldName'));
        }
        String query = 'SELECT ' + String.join(fieldNames, ', ') + ' FROM ' + parentObjectApiName;
        result.put('records', Database.query(query));
        result.put('columns', fields);
        return result;
    }

    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getChildRecords(String parentObjectApiName, String childObjectApiName, String parentField, String parentId, String childFieldset, Integer pageSize, Integer pageNumber, String sortBy, String sortDirection, String searchTerm, String recordId) {
        Map<String, Object> result = new Map<String, Object>();
        List<Map<String, String>> fields = getFieldSetFields(childObjectApiName, childFieldset);
        List<String> fieldNames = new List<String>();
        for (Map<String, String> field : fields) {
            fieldNames.add(field.get('fieldName'));
        }
        
        String query;
        if (String.isNotBlank(recordId)) {
            query = 'SELECT ' + String.join(fieldNames, ', ') + ' FROM ' + childObjectApiName + ' WHERE Id = :recordId';
        } else {
            query = 'SELECT ' + String.join(fieldNames, ', ') + ' FROM ' + childObjectApiName + ' WHERE ' + parentField + ' = :parentId';
            
            if (String.isNotBlank(searchTerm)) {
                query += ' AND (Name LIKE \'%' + String.escapeSingleQuotes(searchTerm) + '%\')';
            }
            
            if (String.isNotBlank(sortBy)) {
                query += ' ORDER BY ' + sortBy + ' ' + sortDirection;
            }
            
            query += ' LIMIT :pageSize OFFSET :offset';
        }
        
        Integer offset = (pageNumber - 1) * pageSize;
        List<SObject> records = Database.query(query);
        
        result.put('records', records);
        result.put('columns', fields);
        result.put('totalRecords', Database.countQuery('SELECT COUNT() FROM ' + childObjectApiName + ' WHERE ' + parentField + ' = :parentId'));
        
        return result;
    }

    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getGrandchildRecords(String grandchildObjectApiName, String childField, String childId, String grandchildFieldset, String recordId) {
        Map<String, Object> result = new Map<String, Object>();
        List<Map<String, String>> fields = getFieldSetFields(grandchildObjectApiName, grandchildFieldset);
        List<String> fieldNames = new List<String>();
        for (Map<String, String> field : fields) {
            fieldNames.add(field.get('fieldName'));
        }
        
        String query;
        if (String.isNotBlank(recordId)) {
            query = 'SELECT ' + String.join(fieldNames, ', ') + ' FROM ' + grandchildObjectApiName + ' WHERE Id = :recordId';
        } else {
            query = 'SELECT ' + String.join(fieldNames, ', ') + ' FROM ' + grandchildObjectApiName + ' WHERE ' + childField + ' = :childId';
        }
        
        result.put('records', Database.query(query));
        result.put('columns', fields);
        return result;
    }

    @AuraEnabled
    public static SObject updateRecord(SObject record) {
        try {
            update record;
            return record;
        } catch (Exception e) {
            throw new AuraHandledException('Error updating record: ' + e.getMessage());
        }
    }

    @AuraEnabled
    public static void deleteRecord(Id recordId, String objectApiName) {
        try {
            SObject record = Database.query('SELECT Id FROM ' + objectApiName + ' WHERE Id = :recordId LIMIT 1');
            delete record;
        } catch (Exception e) {
            throw new AuraHandledException('Error deleting record: ' + e.getMessage());
        }
    }

    @AuraEnabled
    public static SObject addRecord(SObject record) {
        try {
            insert record;
            return record;
        } catch (Exception e) {
            throw new AuraHandledException('Error adding record: ' + e.getMessage());
        }
    }

    @AuraEnabled(cacheable=true)
    public static List<Map<String, String>> getFieldSetFields(String objectName, String fieldSetName) {
        Schema.FieldSet fieldSet = Schema.getGlobalDescribe().get(objectName).getDescribe().fieldSets.getMap().get(fieldSetName);
        List<Map<String, String>> fieldList = new List<Map<String, String>>();
        for (Schema.FieldSetMember fsm : fieldSet.getFields()) {
            Map<String, String> fieldMap = new Map<String, String>();
            fieldMap.put('label', fsm.getLabel());
            fieldMap.put('fieldName', fsm.getFieldPath());
            fieldMap.put('type', getFieldType(fsm.getType()));
            fieldList.add(fieldMap);
        }
        return fieldList;
    }

    private static String getFieldType(Schema.DisplayType displayType) {
        switch on displayType {
            when CURRENCY { return 'currency'; }
            when DATE { return 'date'; }
            when DATETIME { return 'datetime'; }
            when EMAIL { return 'email'; }
            when PHONE { return 'phone'; }
            when BOOLEAN { return 'boolean'; }
            when PERCENT { return 'percent'; }
            when REFERENCE { return 'reference'; }
            when DOUBLE { return 'number'; }
            when INTEGER { return 'number'; }
            when TEXTAREA { return 'textarea'; }
            when URL { return 'url'; }
            when else { return 'text'; }
        }
    }
}