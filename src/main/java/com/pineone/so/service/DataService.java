package com.pineone.so.service;


import com.pineone.so.domain.ContextModel;
import com.pineone.so.domain.DeviceControlMessage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Created by use on 2015-09-09.
 */
@Service
public class DataService {

    String AriconContext = "AIRCON";
    String CONTEXTMODELNAME = "ContextModelName";
    String DOMIANID = "DomianID";
    String SDADOMAIN = "http://localhost:8090/context/";

    String DCMURI ="_uri";
    String DCMCOMMAND = "_command";
    String DCMCNF = "cnf";
    String DCMCON = "con";

    public JSONObject parsingData(ContextModel contextModel) {
        JSONObject object = new JSONObject();
        object.put(CONTEXTMODELNAME, contextModel.getContextModelName());
        object.put(DOMIANID, contextModel.getDomianID());
        return object;
    }

    public void requestSDA(String context) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet Request = new HttpGet(SDADOMAIN + context);
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

    public JSONObject ContextAwareness(String name) {

        ContextModel contextModel = new ContextModel();
        if (AriconContext.equals(name)) {
            contextModel.setContextModelName("SO-CONTEXT-001");
            contextModel.setDomianID("SO-DOMAIN-001");
        } else {
            contextModel.setContextModelName("SO-CONTEXT-999");
            contextModel.setDomianID("SO-DOMAIN-989");
        }

        return parsingData(contextModel);
    }

    public void testResponse() {
        try {
            HttpClient client = new DefaultHttpClient();

            HttpPost post = new HttpPost("http://localhost:8090/test");
            post.setHeader("Accept-Encoding", "identity");
            post.setHeader("Content-Type", "application/json");

            JSONObject object = ContextAwareness("aircon");
            HttpEntity entity = new ByteArrayEntity(object.toString().getBytes("UTF-8"));
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("Output from Server A .... \n");
            System.out.println(result);
        } catch (ClientProtocolException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JSONObject parsingDeviceControlMessageData(DeviceControlMessage deviceControlMessage) {
        JSONObject object = new JSONObject();
        object.put(DCMURI, deviceControlMessage.get_uri());
        object.put(DCMCOMMAND, deviceControlMessage.get_command());
        object.put(DCMCNF, deviceControlMessage.getCnf());
        object.put(DCMCON, deviceControlMessage.getCon());
        return object;
    }

    /**
     * JsonData 받아서 DeviceControlMessage로 가공.
     */
    public DeviceControlMessage processData(JSONObject jsonObject){
        DeviceControlMessage deviceControlMessage = new DeviceControlMessage();

        // 가공 처리
        deviceControlMessage.set_uri((String) jsonObject.get(DCMURI));
        deviceControlMessage.set_command((String) jsonObject.get(DCMCOMMAND));
        deviceControlMessage.setCnf((String) jsonObject.get(DCMCNF));
        deviceControlMessage.setCon((String) jsonObject.get(DCMCON));

        // test print
        System.out.println(deviceControlMessage.toString());

        return deviceControlMessage;
    }

    public JSONObject jsonConvertResponse(HttpResponse response){
        JSONObject object = new JSONObject();
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            Object output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            object  = (JSONObject)output;

        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }



}
