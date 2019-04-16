package com.imudges.web.railwaystationservice.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by yangy on 2018/1/29.
 */
public class GetVoiceUtil {
    //private static String BASE_URL="http://222.39.6.58:8080/WebService.asmx/Get_final_wav_sample1";
    private static String audioUrl= PropertiesUtils.getProperty("audioUrl");
    private static String BASE_URL=audioUrl+"/WebService.asmx/Get_final_wav_sample1";
    private OkHttpClient client=(new OkHttpClient.Builder()).build();
    public  String doAction(String text){
        if(text!=null&&!text.trim().equals("")){
            Request request=(new Request.Builder()).url(BASE_URL+"?voiceText="+text).build();;
            Call call=this.client.newCall(request);
            Response response;
            try {
                response=call.execute();
                String body=response.body().string();
                body=body.replaceAll("\n","").replaceAll("<[?]xml version=\"1.0\" encoding=\"utf-8\"[?]>","")
                        .replaceAll("<string xmlns=\"http://tempuri.org/\">","").replaceAll("</string>","");
                return body;
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str="您乘坐的@K1674@次列车，请到@2楼西候车区@3@检票口进入，经由通道至第@5@站台乘车，距离发车还有约@2个小时15分钟@";
//        String str="您乘坐的@k2356@次列车，请到@2楼西候车区@3@检票口进入，经由通道至@5@站台乘车，距离发车还有约@2天3个小时20分钟@";
        GetVoiceUtil getVoiceUtil=new GetVoiceUtil();
        System.out.println(getVoiceUtil.doAction(str));
    }
}
