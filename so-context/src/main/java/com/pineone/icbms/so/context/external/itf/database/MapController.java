package com.pineone.icbms.so.context.external.itf.database;

import com.pineone.icbms.so.context.GeneralContext;

import java.util.*;

/**
 * Created by melvin on 2016. 7. 13..
 */
public class MapController implements DatabaseInterface{

    private Map<String, GeneralContext> generalContextStore = new HashMap<String, GeneralContext>();

    public static MapController newMapController(){
        //
        MapController mapController = new MapController();
        return mapController;
    }

    public void createGeneralContext(GeneralContext generalContext){
        //
        generalContextStore.put(generalContext.getName(),generalContext);
    }

    public List<GeneralContext> retrieveGeneralContextList(){
        //
        List<GeneralContext> generalContextList = new ArrayList<>();
        for(String key : generalContextStore.keySet()){
            generalContextList.add(generalContextStore.get(key));
        }
        return generalContextList;
    }
}
