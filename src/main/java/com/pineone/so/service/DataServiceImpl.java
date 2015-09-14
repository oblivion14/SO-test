package com.pineone.so.service;

import com.pineone.so.domain.ContextModel;
import com.pineone.so.domain.ContextModelDAO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Created by use on 2015-09-14.
 */
public class DataServiceImpl implements DataService{

    @Autowired
    private ContextModelDAO contextModelDAO;

    String AriconContext = "AIRCON";
    String CONTEXTMODELNAME = "ContextModelName";
    String DOMIANID = "DomianID";
    String SDADOMAIN ="http://localhost:8090/context/";



    public JSONObject parsingData(ContextModel contextModel){
        JSONObject object = new JSONObject();
        object.put(CONTEXTMODELNAME,contextModel.getContextModelName());
        object.put(DOMIANID,contextModel.getDomianID());
        return object;
    }

    public void requestSDA(String context){
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet Request = new HttpGet(SDADOMAIN+context);
            HttpResponse response = httpclient.execute(Request);
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public JSONObject ContextAwareness(String name){

        ContextModel contextModel = new ContextModel();
        if(AriconContext.equals(name)){
            contextModel.setContextModelName("SO-CONTEXT-001");
            contextModel.setDomianID("SO-DOMAIN-001");
        } else {
            contextModel.setContextModelName("SO-CONTEXT-999");
            contextModel.setDomianID("SO-DOMAIN-989");
        }

        return parsingData(contextModel);
    }

    /**
     * MongoDB 연동 부분 확인
     */
    public void insertMongoDB(){
        ContextModel contextModel = new ContextModel();
        contextModel.setContextModelName("SO-CONTEXT-001");
        contextModel.setDomianID("SO-DOMAIN-001");
        contextModelDAO.inserContextModel(contextModel);
    }





}
