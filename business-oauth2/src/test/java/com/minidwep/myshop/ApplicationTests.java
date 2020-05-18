package com.minidwep.myshop;

import com.google.common.collect.Maps;
import com.minidwep.myshop.util.MapperUtils;
import com.minidwep.myshop.util.OkHttpClientUtil;
import okhttp3.*;
import org.apache.commons.collections.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Test
    public void testGet() {
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9041/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client_pwd")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUtilPost(){
        String url = "http://localhost:9041/oauth/token";
        Map<String,String> params = Maps.newHashMap();
        params.put("username", "admin");
        params.put("password", "123456");
        params.put("grant_type", "password");
        params.put("client_id", "client_pwd");
        params.put("client_secret", "secret");
        try {
            Response response = OkHttpClientUtil.getInstance().postData(url, params);
            String jsonString = response.body().string();
            Map<String, Object> stringObjectMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(stringObjectMap.get("access_token"));
            System.out.println(token);
//            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
