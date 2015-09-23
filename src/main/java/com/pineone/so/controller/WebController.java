package com.pineone.so.controller;

import com.pineone.so.domain.ContextModel;
import com.pineone.so.domain.DeviceControlMessage;
import com.pineone.so.service.ClientService;
import com.pineone.so.service.DataService;
import org.apache.http.HttpResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by use on 2015-09-09.
 */
@Controller
public class WebController {

    @Autowired
    DataService dataService;

    @Autowired
    ClientService clientService;

    @ResponseBody
    @RequestMapping(value = "/domain/{name}", method = RequestMethod.GET)
    public JSONObject domainTest(@PathVariable String name){
        return dataService.ContextAwareness(name);
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JSONObject test(){
        return dataService.ContextAwareness("test");
    }

    @ResponseBody
    @RequestMapping(value = "/checkData/{name}", method = RequestMethod.GET)
    public String sendSDAContext(@PathVariable String name){

        dataService.requestSDA(name);

        return "success";
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/tt", method = RequestMethod.GET)
    public String testresponse(){

        // 임의 데이터 세팅.
        DeviceControlMessage deviceControlMessage = new DeviceControlMessage("casebase/SAE_0021","switch_ctl","text/plain:0","ON");

        // 요청 후 데이터 받음.
        HttpResponse response = clientService.requestPostData(ClientService.REQUEST_POST, ClientService.SICOMMAND, dataService.parsingDeviceControlMessageData(deviceControlMessage));

        /*

        // response 데이터 가공해서 json으로 변환
        JSONObject object = dataService.jsonConvertResponse(response);

        // json데이터를 deviceControlMessage로 변환.
        dataService.processData(object);

        */

        return "test OK";
    }


}
