package com.pineone.icbms.so;

import com.pineone.icbms.so.context.GeneralContext;
import com.pineone.icbms.so.context.device.ConceptService;
import com.pineone.icbms.so.context.device.DeviceObject;
import com.pineone.icbms.so.context.device.TempConceptService;
import com.pineone.icbms.so.context.device.VirtualObject;

import com.pineone.icbms.so.context.external.AddressStore;
import com.pineone.icbms.so.context.external.itf.sda.ContextAddress;
import com.pineone.icbms.so.context.util.DataConversion;
import com.withwiz.beach.network.http.message.IHttpResponseMessage;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by melvin on 2016. 7. 7..
 */
public class ContextUserTest {

    GeneralContext generalContext;
    List<DeviceObject> deviceObjectList;
    ContextAddress contextAddress;

//    NOTE : ContextModel 에 사용될 ContextType
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
    //NOTE: GeneralContext 저작 요청을 하고 DeviceObject 를 수신
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
    //NOTE: DeviceObject 를 선택하고 ConceptServiceLisr 를 수신
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
    //NOTE : GeneralContext 정보를 입력 받아서 SDA 에 등록
    public void registerGeneralContextToSDATest() throws Exception {

        ClientAndServer mockServer = ClientAndServer.startClientAndServer(18080);
        //User Field
        String name = "EmergencyTempContext";
        int minValue = 60;
        int maxValue = 100;
        DeviceObject deviceObject = VirtualObject.TemperatureSensor001;
        ConceptService conceptService = TempConceptService.temperature_measure_service;

        //SDA register
        generalContext = GeneralContext.newGeneralContext();
        generalContext.setName(name);
        generalContext.setMinValue(minValue);
        generalContext.setMaxValue(maxValue);
        generalContext.setDeviceObject(deviceObject);
        generalContext.setConceptService(conceptService);

//        generalContext.registerGeneralContext(generalContext);

        String sendData = DataConversion.objectToString(generalContext);
        contextAddress = ContextAddress.newContextAddress();

        mockServer
                .when(HttpRequest.request().withMethod("POST").withBody(sendData)
                        .withPath(AddressStore.REGISTER_GENERALCONTEXT))
                .respond(HttpResponse.response().withStatusCode(200).withBody(sendData));
    }

    //NOTE: DB 저장 및 조회
    @Test
    public void registerGeneralContextToDB() throws Exception {

        //User Field
        String name = "EmergencyTempContext";
        int minValue = 60;
        int maxValue = 100;
        DeviceObject deviceObject = VirtualObject.TemperatureSensor001;
        ConceptService conceptService = TempConceptService.temperature_measure_service;

        generalContext = GeneralContext.newGeneralContext();
        generalContext.setName(name);
        generalContext.setMinValue(minValue);
        generalContext.setMaxValue(maxValue);
        generalContext.setDeviceObject(deviceObject);
        generalContext.setConceptService(conceptService);

        generalContext.createGeneralContext(generalContext);
        List<GeneralContext> generalContextList = generalContext.retrieveGeneralContextList();
        for(GeneralContext generalContext : generalContextList){
            System.out.println(generalContext.getName());
        }

    }
}
