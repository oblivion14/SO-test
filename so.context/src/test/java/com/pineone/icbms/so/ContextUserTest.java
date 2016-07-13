package com.pineone.icbms.so;

import com.pineone.icbms.so.context.ContextType;
import com.pineone.icbms.so.context.GeneralContext;
import com.pineone.icbms.so.context.device.ConceptService;
import com.pineone.icbms.so.context.device.DeviceObject;
import com.pineone.icbms.so.context.device.TempConceptService;
import com.pineone.icbms.so.context.device.VirtualObject;
import com.pineone.icbms.so.context.external.AddressStore;
import com.pineone.icbms.so.context.external.ContextAddress;
import com.withwiz.beach.network.http.message.IHttpResponseMessage;
import com.withwiz.jellyfish.service.IGenericService;
import com.withwiz.jellyfish.service.ServiceException;
import com.withwiz.service.network.http.client.httpclientservice.HttpClientService;
import com.withwiz.service.network.http.client.httpclientservice.HttpClientServiceRequestDeliveryMessage;
import com.withwiz.service.network.http.client.httpclientservice.HttpClientServiceResponseDeliveryMessage;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
//        contextTypeArrayList = generalContext.requestContextMaking();
//        System.out.println(" *** Step1 : ContextType Request ***");
//        for(ContextType contextType : contextTypeArrayList){
//            System.out.println(contextType);
//        }
//    }


    @Test
    public void requestContextMakingTest() throws Exception {
        generalContext = GeneralContext.newGeneralContext();
        deviceObjectList = generalContext.requestContextMaking();
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

        //SDA 에서 ID 받아왔다는 가정,
        String id = "CI-1-1-001";

        //DB 저장
        generalContext = GeneralContext.newGeneralContext();
        Map map = generalContext.registerGeneralContext(id, name, VirtualObject.TemperatureSensor001, TempConceptService.temperature_measure_service,
                minValue, maxValue);

        GeneralContext saveContext = (GeneralContext) map.get(name);
        if(saveContext.getName() == name){
            System.out.println("Register Success");
        }
    }


}
