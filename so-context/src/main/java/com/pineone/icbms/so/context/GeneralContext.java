package com.pineone.icbms.so.context;

import com.pineone.icbms.so.context.device.ConceptService;
import com.pineone.icbms.so.context.device.DeviceCenter;
import com.pineone.icbms.so.context.device.DeviceObject;
import com.pineone.icbms.so.context.external.itf.database.DatabaseInterface;
import com.pineone.icbms.so.context.external.itf.database.MapController;
import com.sun.tools.javac.jvm.Gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by melvin on 2016. 7. 7..
 */
public class GeneralContext implements Context {
    private String id;
    private String name;
    private DeviceObject deviceObject;
    private int minValue;
    private int maxValue;
    private ConceptService conceptService;

    public GeneralContext(){}

    public static GeneralContext newGeneralContext(){
        //
        GeneralContext generalContext = new GeneralContext();
        return generalContext;
    }

    public GeneralContext(String id, String name, DeviceObject deviceObject, ConceptService conceptService,
                                          int minValue, int maxValue){
        //
        this.id = id;
        this.name = name;
        this.deviceObject = deviceObject;
        this.conceptService = conceptService;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public GeneralContext(String name, DeviceObject deviceObject, ConceptService conceptService,
                          int minValue, int maxValue){
        //
        this.name = name;
        this.deviceObject = deviceObject;
        this.conceptService = conceptService;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceObject getDeviceObject() {
        return deviceObject;
    }

    public void setDeviceObject(DeviceObject deviceObject) {
        this.deviceObject = deviceObject;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public ConceptService getConceptService() {
        return conceptService;
    }

    public void setConceptService(ConceptService conceptService) {
        this.conceptService = conceptService;
    }

//    public List<ContextType> retrieveDeviceObjectList(){
//        contextTypeArrayList = new ArrayList<ContextType>();
//        for(ContextType contextType : ContextType.values()){
//            contextTypeArrayList.add(contextType);
//        }
//        return contextTypeArrayList;
//    }

    public List<DeviceObject> retrieveDeviceObjectList(){
        //
        return DeviceCenter.retrieveDeviceObjectList();
    }

    public List<ConceptService> retrieveConceptService(DeviceObject deviceObject){
        //
        return DeviceCenter.newDeviceCenter().retrieveConceptServiceList(deviceObject);
    }

    // DB 저장 모듈
    public void createGeneralContext(GeneralContext generalContext){
        //
        MapController mapController = MapController.newMapController();
        mapController.createGeneralContext(generalContext);
    }
    // SDA에 컨텍스트 저장 모듈
    public void registerGeneralContext(GeneralContext generalContext){
        //
        //sdaInterface.registerGeneralContextToSDA(generalContext)
        this.createGeneralContext(generalContext);
    }

    // DB _ GeneralContext 조회
    public List<GeneralContext> retrieveGeneralContextList(){
        //
        MapController mapController = MapController.newMapController();
        List<GeneralContext> generalContextList = mapController.retrieveGeneralContextList();
        return generalContextList;
    }

    // SDA_GeneralContextList 조회
    public List<GeneralContext> retrieveGeneralContextListFromSDA(){
        //
        List<GeneralContext> generalContextList = new ArrayList<>();
        //generalContextList = sdaInterface.retrieveGeneralContextList();
        return null; //generalContextList
    }

    // SDA_GeneralContext 상세 조회
    public GeneralContext retrieveGeneralContext(String generalContextName){
        //
        GeneralContext generalContext = newGeneralContext();
        //generalContext = sdaInterface.retrieveGeneralContext(generalContextName);
        return null; // generalContext
    }
}
