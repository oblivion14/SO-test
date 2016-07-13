package com.pineone.icbms.so.context.external.itf.sda;

import com.pineone.icbms.so.context.GeneralContext;

/**
 * Created by melvin on 2016. 7. 13..
 */
public class SdaController implements ContextInterface {

    public static SdaController newSdaController(){
        SdaController sdaController = new SdaController();
        return sdaController;
    }

    public String registerGeneralContext(GeneralContext generalContext){

        return null;
    }
}
