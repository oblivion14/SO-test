package com.pineone.icbms.so.context.device;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melvin on 2016. 7. 11..
 */
public class DeviceCenter {

    public static ArrayList<DeviceObject> deviceObjectArrayList;

    public static DeviceCenter newDeviceCenter(){
        DeviceCenter deviceCenter = new DeviceCenter();
        return deviceCenter;
    }

    public static List<DeviceObject> retrieveDeviceObjectList(){
        deviceObjectArrayList = new ArrayList<DeviceObject>();
        for(VirtualObject virtualObject : VirtualObject.values()) {
            deviceObjectArrayList.add(virtualObject);
        }
        for(CompositeVirtualObject compositeVirtualObject : CompositeVirtualObject.values()){
            deviceObjectArrayList.add(compositeVirtualObject);
        }
        return deviceObjectArrayList;
    }

    public List<ConceptService> retrieveConceptServiceList(DeviceObject deviceObject){
        List<ConceptService> conceptServiceList = new ArrayList<ConceptService>();
        if(deviceObject.equals(VirtualObject.TemperatureSensor001)){
            for(TempConceptService tempConceptService : TempConceptService.values()){
                conceptServiceList.add(tempConceptService);
            }
            return conceptServiceList;
        }
        else if(deviceObject.equals(VirtualObject.hanyangSensor)){
            for(HanyangConceptService hanyangConceptService : HanyangConceptService.values()){
                conceptServiceList.add(hanyangConceptService);
            }
            return conceptServiceList;
        }
            return null;
    }
}
