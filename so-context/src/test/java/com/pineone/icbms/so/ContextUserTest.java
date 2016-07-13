package com.pineone.icbms.so;

import com.pineone.icbms.so.context.GeneralContext;
import com.pineone.icbms.so.context.device.ConceptService;
import com.pineone.icbms.so.context.device.DeviceObject;
import com.pineone.icbms.so.context.device.TempConceptService;
import com.pineone.icbms.so.context.device.VirtualObject;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by melvin on 2016. 7. 7..
 */
public class ContextUserTest {

    GeneralContext generalContext;
    List<DeviceObject> deviceObjectList;


//    NOTE : ContextModel에 사용될 ContextType
//    @Test
//    public void requestContext() throws Exception {
//        generalContext = GeneralContext.newGeneralContext();
//        List<ContextType> contextTypeArrayList;
//        contextTypeArrayList = generalContext.retrieveDeviceObjectList();
//        System.out.println(" *** Step1 : ContextType Request ***");
//        for(ContextType contextType : contextTypeArrayList){
//            System.out.println(contextType);
//        }
//    }


    @Test
    public void requestContextMakingTest() throws Exception {
        generalContext = GeneralContext.newGeneralContext();
        deviceObjectList = generalContext.retrieveDeviceObjectList();
        System.out.println(" *** Step1 - Request : ContextMaking , Response : DeviceObjectList ***");
        for(DeviceObject deviceObject : deviceObjectList){
            System.out.println(deviceObject);
        }
        System.out.println();
    }

    @Test
    public void chooseDeviceObjectTest() throws Exception {
        generalContext = GeneralContext.newGeneralContext();
        List<ConceptService> conceptServiceList = generalContext.retrieveConceptService(VirtualObject.TemperatureSensor001);
        System.out.println(" *** Step2 - Request : retrieveConceptServiceList , Response : ConceptServiceList ***");
        for(ConceptService conceptService : conceptServiceList){
            System.out.println(conceptService);
        }
        System.out.println();
    }

    @Test
    public void registerGeneralContextTest() throws Exception {

        //User Field
        String name = "EmergencyTempContext";
        int minValue = 60;
        int maxValue = 100;
        DeviceObject deviceObject = VirtualObject.TemperatureSensor001;

        //DB 저장
        generalContext = GeneralContext.newGeneralContext();
        generalContext.registerGeneralContext(name, VirtualObject.TemperatureSensor001, TempConceptService.temperature_measure_service,
                minValue, maxValue);
    }


}
