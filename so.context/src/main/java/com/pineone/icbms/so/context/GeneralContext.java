package com.pineone.icbms.so.context;

import com.pineone.icbms.so.context.device.ConceptService;
import com.pineone.icbms.so.context.device.DeviceCenter;
import com.pineone.icbms.so.context.device.DeviceObject;

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
    Map<String, GeneralContext> generalContextStore;

    public GeneralContext(){}

    public static GeneralContext newGeneralContext(){
        GeneralContext generalContext = new GeneralContext();
        return generalContext;
    }

    public GeneralContext(String id, String name, DeviceObject deviceObject, ConceptService conceptService,
                                          int minValue, int maxValue){
        this.id = id;
        this.name = name;
        this.deviceObject = deviceObject;
        this.conceptService = conceptService;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    // DB 저장 모듈
    public Map registerGeneralContext(String id, String name, DeviceObject deviceObject, ConceptService conceptService,
                          int minValue, int maxValue){
        GeneralContext generalContext = new GeneralContext(id, name, deviceObject, conceptService, minValue, maxValue);

        generalContextStore = new HashMap<String, GeneralContext>();
        generalContextStore.put(name,generalContext);

        return generalContextStore;
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

//    public List<ContextType> requestContextMaking(){
//        contextTypeArrayList = new ArrayList<ContextType>();
//        for(ContextType contextType : ContextType.values()){
//            contextTypeArrayList.add(contextType);
//        }
//        return contextTypeArrayList;
//    }

    public List<DeviceObject> requestContextMaking(){
        return DeviceCenter.retrieveDeviceObjectList();
    }

    public List<ConceptService> retrieveConceptService(DeviceObject deviceObject){
        return DeviceCenter.newDeviceCenter().retrieveConceptServiceList(deviceObject);
    }
}
