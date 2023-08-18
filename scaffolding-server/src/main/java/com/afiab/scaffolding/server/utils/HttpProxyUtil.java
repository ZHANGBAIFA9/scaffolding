package com.afiab.scaffolding.server.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 14:42
 * @Description:
 */
@Slf4j
public class HttpProxyUtil {
    /**
     * 编码
     */
    public static String ENCODING = "utf-8";
    /**
     * 是否打印日志
     */
    public static boolean isPrint = true;
    /**
     * httpClient 客户端
     */
    public static CloseableHttpClient httpClient;
    /**
     * 发送get请求，不带请求头和请求参数
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        return get(url, null);
    }

    /**
     * 发送get请求，带请求参数
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        return get(url, null, params);
    }

    /**
     * 发送get请求，带请求头和请求参数
     *
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> headers, Map<String, String> params) {
        //创建访问的地址
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null) {
                params.forEach((k, v) -> uriBuilder.setParameter(k, v));
            }
            //创建http对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            packageHeader(headers, httpGet);
            return execute(httpGet);
        } catch (URISyntaxException e) {
            log.error("根据url创建URIBuilder失败 --> {}", e.getMessage());
            return null;
        }
    }

    /**
     * post 请求 不带请求头和请求参数
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String post(String url) {
        return post(url, null);
    }

    /**
     * post请求 带请求参数
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> params) {
        return post(url, null, params);
    }

    /**
     * 发送post请求 带请求头和请求参数
     *
     * @param url
     * @param headers
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> headers,
                              Map<String, String> params) {
        //创建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        packageHeader(headers, httpPost);
        packageParam(params, httpPost);
        return execute(httpPost);
    }

    /**
     * 发送post请求 带json参数
     *
     * @param url
     * @param jsonString
     * @return
     */
    public static String postJson(String url, String jsonString) {
        return postJson(url,null,jsonString);
    }

    /**
     * 发送post请求，带请求头和json参数
     * @param url
     * @param headers
     * @param jsonString
     * @return
     */
    public static String postJson(String url,Map<String,String> headers,String jsonString){
        HttpPost httpPost = new HttpPost(url);
        packageHeader(headers,httpPost);
        httpPost.setEntity(new StringEntity(jsonString,ContentType.APPLICATION_JSON));
        return execute(httpPost);
    }

    public static String postJson(String url,Map<String,String> headers,Map<String,String> params){
        HttpPost httpPost = new HttpPost(url);
        packageHeader(headers,httpPost);
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(params),ContentType.APPLICATION_JSON));
        return execute(httpPost);
    }

    /**
     * 发送post请求 带xml参数
     *
     * @param url
     * @param jsonString
     * @return
     */
    public static String postXml(String url, String jsonString) {
        //charset=utf-8
        Map<String,String> headers = new HashMap<>();
        headers.put("charset", ENCODING);
        return postXml(url,headers,jsonString);
    }

    /**
     * 发送post请求，带请求头和xml参数
     * @param url
     * @param headers
     * @param jsonString
     * @return
     */
    public static String postXml(String url,Map<String,String> headers,String jsonString){
        HttpPost httpPost = new HttpPost(url);
        packageHeader(headers,httpPost);
        httpPost.setEntity(new StringEntity(jsonString, ContentType.create("application/xml", Consts.UTF_8)));
        return execute(httpPost);
    }

    /**
     * 发送put请求，不带请求参数
     *
     * @param url
     * @return
     */
    public static String put(String url) {
        return put(url, null);
    }

    /**
     * 发送put请求，带请求参数
     *
     * @param url
     * @param params
     * @return
     */
    public static String put(String url, Map<String, String> params) {
        HttpPut httpPut = new HttpPut(url);
        packageParam(params, httpPut);
        httpPut.setHeader("Content-Type", "application/json");
        return execute(httpPut);
    }

    public static String putJson(String url, Map<String, String> params) {
        HttpPut httpPut = new HttpPut(url);
        packageParam(params, httpPut);
        httpPut.setEntity(new StringEntity(JSON.toJSONString(params),ContentType.APPLICATION_JSON));
        return execute(httpPut);
    }




    public static String delete(String url) {
        HttpDelete httpDelete = new HttpDelete(url);
        return execute(httpDelete);
    }
//    public static String deleteJson(String url,Map<String,String> headers,String jsonString){
//        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(url) ;
//        httpDelete.setEntity(new StringEntity(jsonString,ContentType.APPLICATION_JSON));
//        packageHeader(headers,httpDelete);
//        return execute(httpDelete);
//    }
    /**
     * 封装请求头
     *
     * @param params
     * @param httpRequestBase
     */
    private static void packageHeader(Map<String, String> params, HttpRequestBase httpRequestBase) {
        //封装请求头
        if (params != null) {
            params.forEach((k, v) -> httpRequestBase.setHeader(k, v));
        }
    }

    /**
     * 封装请求参数
     *
     * @param params
     * @param httpMethod
     */
    private static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod) {
        //封装请求参数
        if (params != null) {
            List<NameValuePair> nameValuePairs = new ArrayList<>(params.size());
            params.forEach((k, v) -> nameValuePairs.add(new BasicNameValuePair(k, v)));
            //设置请求参数到http对象中
            try {
                httpMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs,ENCODING));
            } catch (UnsupportedEncodingException e) {
                log.error("将请求参数设置到http对象异常 --> {}", e.getMessage());
            }
        }
    }

    /**
     * 获取响应结果
     *
     * @param httpMethod
     * @return
     * @throws IOException
     */
    private static String execute(HttpRequestBase httpMethod) {
        CloseableHttpResponse httpResponse = null;
        //执行请求
        try {
            httpResponse = httpClient.execute(httpMethod);
            //获取返回结果
            if (httpResponse != null) {
                if (isPrint) {
                    log.info("http 请求url {} --> 响应码[{}]", httpMethod.getURI(), httpResponse.getStatusLine().getStatusCode());
                }
                if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                    if(isPrint){
                        Header[] headers = httpResponse.getAllHeaders();
                        log.info("响应内容 --> {}",headers);
                        String content = EntityUtils.toString(httpResponse.getEntity(),ENCODING);
                        log.info("响应内容 --> {}",content);
                        return content;
                    }
                    return EntityUtils.toString(httpResponse.getEntity(),ENCODING);
                }else{
                    if(httpResponse.getEntity() != null){
                        if(isPrint){
                            log.info("响应内容 --> {}",EntityUtils.toString(httpResponse.getEntity(),ENCODING));
                        }
                    }
                }
            }
            return null;
        } catch (IOException e) {
            log.error("执行http请求异常 --> {}", e.getMessage());
            return null;
        } finally {
            if(httpResponse != null){
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<String> getPutList(String logTraceId , int count) {
        List<String> putList = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            String logContent = "TID:"+logTraceId+"|应用:data-rd-center | 端口:12010 | 注解位置: 保存调度配置| 方法描述: | 目标类名: com.yonghui.data.rd.center.api.impl.SqlCenterClientImpl| 目标方法: save| 调用参数: [{\"creater\":50012759,\"nodeId\":939,\"sql\":\"-- 测试nSELECTt id,namenFROMt dwd.galaxytest \"}]| 返回结果: {\"code\":\"0000000\",\"data\":409,\"message\":\"\",\"now\":1586415027668,\"success\":true}| 序号："+i+"| 花费时间: 12";
            putList.add(logContent);
        }
        return putList;
    }

    // 自定义内部类，此种调用不符合规范
//    static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
//
//        public static final String METHOD_NAME = "DELETE";
//        @Override
//        public String getMethod() { return METHOD_NAME; }
//
//        public HttpDeleteWithBody(final String uri) {
//            super();
//            setURI(URI.create(uri));
//        }
//        public HttpDeleteWithBody(final URI uri) {
//            super();
//            setURI(uri);
//        }
//        public HttpDeleteWithBody() { super(); }
//
//    }

    /**
     * 获取请求真实IP
     *
     * @param request request
     * @return realIp
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        try {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            // "***.***.***.***".length()
            if (ip != null && ip.length() > 15) {
                // = 15
                if (ip.indexOf(",") > 0) {
                    ip = ip.substring(0, ip.indexOf(","));
                }
            }
        } catch (Exception e) {
            ip = "";
        }
        return ip;
    }
}
