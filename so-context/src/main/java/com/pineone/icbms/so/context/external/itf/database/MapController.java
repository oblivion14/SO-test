package com.pineone.icbms.so.context.external.itf.database;

import com.pineone.icbms.so.context.GeneralContext;

import java.util.*;

/**
 * Created by melvin on 2016. 7. 13..
 * NOTE: DB 생성 전까지 MAP 사용.
 */
public class MapController implements DatabaseInterface{

    private static MapController instance;
    private MapController(){}
    private Map<String, GeneralContext> generalContextStore = new HashMap<String, GeneralContext>();

    //NOTE: DB에 GeneralContext 데이터 생성
    public void createGeneralContext(GeneralContext generalContext){
        //
        generalContextStore.put(generalContext.getName(),generalContext);
    }

    //NOTE: DB 에서 GeneralContextList 조회
    public List<GeneralContext> retrieveGeneralContextList() {
        //
        List<GeneralContext> generalContextList = new ArrayList<>();
        for (String key : generalContextStore.keySet()) {
            generalContextList.add(generalContextStore.get(key));
        }
        return generalContextList;
    }

    public static MapController getInstance(){
        if(instance == null)
            instance = new MapController();
        return instance;
    }
}

