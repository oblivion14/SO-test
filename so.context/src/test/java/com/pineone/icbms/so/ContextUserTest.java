package com.pineone.icbms.so;

import com.pineone.icbms.so.context.ContextType;
import com.pineone.icbms.so.context.GeneralContext;
import org.junit.Test;

import java.util.List;

/**
 * Created by melvin on 2016. 7. 7..
 */
public class ContextUserTest {

    GeneralContext generalContext;

    @Test
    public void requestContextMakingTest() throws Exception {
        generalContext = GeneralContext.newGeneralContext();
        List<ContextType> contextTypeArrayList;
        contextTypeArrayList = generalContext.requestContextMaking();
        for(ContextType contextType : contextTypeArrayList){
            System.out.println(contextType);
        }
    }
}
