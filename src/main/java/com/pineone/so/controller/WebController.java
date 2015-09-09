package com.pineone.so.controller;

import com.pineone.so.domain.ContextModel;
import com.pineone.so.service.DataService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by use on 2015-09-09.
 */
@Controller
public class WebController {

    @Autowired
    DataService dataService;

    @ResponseBody
    @RequestMapping(value = "/domain/{name}", method = RequestMethod.GET)
    public String domainTest(@PathVariable String name){
        return dataService.ContextAwareness(name).toJSONString();
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

}
