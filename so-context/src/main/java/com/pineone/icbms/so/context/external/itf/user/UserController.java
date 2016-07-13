package com.pineone.icbms.so.context.external.itf.user;

import com.pineone.icbms.so.context.GeneralContext;
import com.pineone.icbms.so.context.DataValidation;
import com.pineone.icbms.so.context.device.ConceptService;
import com.pineone.icbms.so.context.device.DeviceObject;
import com.pineone.icbms.so.context.exception.DataLossException;
import com.pineone.icbms.so.context.external.AddressStore;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by melvin on 2016. 7. 13..
 */

@Controller
public class UserController {
    //
    GeneralContext generalContext;

    @RequestMapping(value = AddressStore.REQUIRE_GENERALCONTEXT, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<DeviceObject> requestGeneralContextMaking(){
        //
        generalContext = generalContext.newGeneralContext();
        List<DeviceObject> deviceObjectList = generalContext.retrieveDeviceObjectList();
        return deviceObjectList;
    }

    @RequestMapping(value = AddressStore.RETRIEVE_CONCEPTSERVICE, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<ConceptService> retrieveConceptServiceController(@PathVariable("deviceobject") DeviceObject deviceObject){
        //
        generalContext = generalContext.newGeneralContext();
        List<ConceptService> conceptServiceList = generalContext.retrieveConceptService(deviceObject);
        return conceptServiceList;
    }

    @RequestMapping(value = AddressStore.REGISTER_GENERALCONTEXT, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseMessageToUser registerGeneralContextController(@RequestBody GeneralContext generalContext){
        //
        DataValidation dataValidation = DataValidation.newGeneralContextValidation();
        ResponseMessageToUser responseMessage = ResponseMessageToUser.newResponseMessage();
        try {
            dataValidation.inspectGeneralContext(generalContext);
        } catch (DataLossException e) {
            responseMessage.setExceptionMessage(e.getMessage());
            return responseMessage;
        }
        generalContext.registerGeneralContext(generalContext);
        responseMessage.setMessage(responseMessage.generalContextResultMessage(generalContext));
        return responseMessage;
    }

    @RequestMapping(value = AddressStore.RETRIEVE_GENERALCONTEXT, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<GeneralContext> retrieveGeneralContextListController(){
        //
        generalContext = generalContext.newGeneralContext();
        List<GeneralContext> generalContextList = generalContext.retrieveGeneralContextList();
        return generalContextList;
    }

    @RequestMapping(value = AddressStore.RETRIEVE_GENERALCONTEXT_DETAIL, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public GeneralContext retrieveGeneralContextController(@PathVariable("contextname") String contextName){
        //
        generalContext = generalContext.newGeneralContext().retrieveGeneralContext(contextName);
        return generalContext;
    }

}
