package com.pineone.icbms.so.context;

import com.pineone.icbms.so.context.exception.DataLossException;

/**
 * Created by melvin on 2016. 7. 13..
 */
public class DataValidation {

    public static DataValidation newGeneralContextValidation(){
        DataValidation dataValidation = new DataValidation();
        return dataValidation;
    }

    public void inspectGeneralContext(GeneralContext generalContext) throws DataLossException {
        if(generalContext.getName() == null || generalContext.getConceptService() == null ||
                generalContext.getDeviceObject() == null || (generalContext.getMaxValue() == 0 &&
                generalContext.getMinValue() == 0)){
            throw new DataLossException();
        }
    }
}
