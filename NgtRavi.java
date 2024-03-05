package com.tem.t24;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;

public class NgtRavi extends RecordLifecycle {
    
    //EB.API = NGTRAVI

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {

        FundsTransferRecord ft = new FundsTransferRecord(currentRecord);

        TField t1 = ft.getDebitCurrency();
        TField t2 = ft.getCreditCurrency();

        if (!t1.getValue().equals(t2.getValue())) {
            t2.setError("Credit currency and Debit currency does not match");
        }

        return ft.getValidationResponse();
    }
}
