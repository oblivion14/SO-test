package com.pineone.so.service;


import com.pineone.so.domain.ContextModel;
import com.pineone.so.domain.ContextModelDAO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Created by use on 2015-09-09.
 */
@Service
public interface DataService {

    public JSONObject parsingData(ContextModel contextModel);

    public void requestSDA(String context);

    public JSONObject ContextAwareness(String name);

    public void insertMongoDB();


}
