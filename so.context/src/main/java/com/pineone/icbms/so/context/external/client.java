package com.pineone.icbms.so.context.external;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import com.pineone.icbms.so.domain.service.clientService;
import com.withwiz.beach.network.http.message.IHttpResponseMessage;
import com.withwiz.jellyfish.service.IGenericService;
import com.withwiz.jellyfish.service.ServiceException;
import com.withwiz.service.network.http.client.httpclientservice.HttpClientService;
import com.withwiz.service.network.http.client.httpclientservice.HttpClientServiceRequestDeliveryMessage;
import com.withwiz.service.network.http.client.httpclientservice.HttpClientServiceResponseDeliveryMessage;


/**
 * Created by pahnj on 2016-07-11.
 */
public class client implements clientService {

    public static final int DATA_TIMEOUT_VALUE = 9000;

//    private final Logger log = LoggerFactory.getLogger(ClientService.class);

    @Override
    public String requestPostService(String uri, String data) {
//        log.info("[[Client Service requestPostService uri]] " + uri);
//        log.info("[[Client Service requestPostService data]] " + data);
        // request delivery message
        HttpClientServiceRequestDeliveryMessage req = new HttpClientServiceRequestDeliveryMessage();
        // add key-value list.
        HashMap<String, String> headerList = new HashMap<String, String>();
        headerList.put("Content-Type", "application/json");
        // headerList.put("Content-Length", "238");
        req.addValue(HttpClientService.KEY_HEADER_PARAMETERS, headerList);
        req.addValue(HttpClientService.KEY_SERVICE_URL, data);
        req.addValue(HttpClientService.KEY_CONNECTION_TIMEOUT, 50000);
        req.addValue(HttpClientService.KEY_HTTP_METHOD,
                HttpClientService.VALUE_HTTP_METHOD_POST);
        // req.addValue(HttpClientService);

        // body data
        // StringInputStream inputStream = new StringInputStream(body);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                data.getBytes());
        req.addValue(HttpClientService.KEY_BODY_INPUT_STREAM, inputStream);

        // response delivery message
        HttpClientServiceResponseDeliveryMessage res = new HttpClientServiceResponseDeliveryMessage();
        IHttpResponseMessage httpResponseMessage = null;
        // HttpClientService
        IGenericService service = new HttpClientService();
        try
        {
            // execute a service
            service.onService(req, res);
            // get a service response
            httpResponseMessage = res
                    .getValue(HttpClientService.KEY_HTTP_RESPONSE);
            // print a response
            System.out.println(res);
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
        }
        return "";
//        return httpResponseMessage;
    }

    @Override
    public String requestGetService(String uri) {
        // request delivery message
        HttpClientServiceRequestDeliveryMessage req = new HttpClientServiceRequestDeliveryMessage();
        // add key-value list.
        req.addValue(HttpClientService.KEY_SERVICE_URL, uri);
        req.addValue(HttpClientService.KEY_CONNECTION_TIMEOUT,DATA_TIMEOUT_VALUE);
        req.addValue(HttpClientService.KEY_HTTP_METHOD,
                HttpClientService.VALUE_HTTP_METHOD_GET);

        // response delivery message
        HttpClientServiceResponseDeliveryMessage res = new HttpClientServiceResponseDeliveryMessage();

        // HttpClientService
        IGenericService service = new HttpClientService();
        // return IHttpResponseMessage
        IHttpResponseMessage httpResponseMessage = null;
        try
        {
            // execute a service
            service.onService(req, res);
            // get a service response
            httpResponseMessage = res
                    .getValue(HttpClientService.KEY_HTTP_RESPONSE);
            // print a response
            System.out.println(res);
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
        }
//        return httpResponseMessage;
        return null;
    }

    private IHttpResponseMessage;


}
