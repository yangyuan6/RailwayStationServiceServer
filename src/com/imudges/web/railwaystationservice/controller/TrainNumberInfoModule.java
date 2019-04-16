package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.bean.DistanceTime;
import com.imudges.web.railwaystationservice.entity.Dict;
import com.imudges.web.railwaystationservice.entity.TicketMsg;
import com.imudges.web.railwaystationservice.entity.TrainInfo;
import com.imudges.web.railwaystationservice.util.DateUtil;
import com.imudges.web.railwaystationservice.util.GetVoiceUtil;
import com.imudges.web.railwaystationservice.util.PropertiesUtils;
import com.imudges.web.railwaystationservice.util.TicketQuery;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by yangy on 2018/1/9.
 */
@IocBean
public class TrainNumberInfoModule {
    @Inject
    Dao dao;

    @At("ticketquery")
    @Ok("json")
    @Fail("http:500")
    @GET
    @POST
    public Object ticketQuery(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("code") String code) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (code != null && !code.trim().equals("")) {
            TicketQuery.TicketData ticketData = new TicketQuery().doAction(code);
            if (ticketData != null) {
                hashMap.put("msg", "success");
                hashMap.put("state", "0");
                hashMap.put("data", ticketData);
                return hashMap;
            }
        }
        hashMap.put("msg", "");
        hashMap.put("state", 1);
        return hashMap;
    }

    @At("ticketqueryre")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object ticketQueryRE(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("code") String code) {
        TicketMsg ticketMsg = new TicketMsg();
        HashMap<String, Object> dataMap = new HashMap();
        ticketMsg.setUrl("state");
        ticketMsg.setUrl("second.html");
        ticketMsg.setState(1);
        try {
            if (code != null && !code.trim().equals("")) {
                TicketQuery.TicketData ticketData = new TicketQuery().doAction(code);
                if (ticketData != null) {
                    String trainNumber = ticketData.getTrainNumber();
                    TrainInfo trainInfo = dao.fetch(TrainInfo.class, Cnd.where("trainNumber", "=", trainNumber).and("trainStationName","=",ticketData.getDepartStation()));
                    if (trainInfo != null) {
                        String dateString = ticketData.getDateString();
                        dateString = dateString.replaceAll("开", "");
                        ticketData.setDateString(dateString);
                        Date endDate = DateUtil.parse(dateString);
                        String distanceTime = DateUtil.getDatePoor(endDate, new Date());
                        if(!"overdue".equals(distanceTime)){
                            dataMap.put("jianPiaoKou", trainInfo.getJianPiaoKou());
                            dataMap.put("newStation", trainInfo.getStation());
                            dataMap.put("witingRoom", trainInfo.getWaitingRoom());
                            dataMap.put("distanceTime", distanceTime);
                            request.setAttribute("dataMap", dataMap);
                            ticketMsg.setMsg("");
                            ticketMsg.setTicketData(ticketData);
                            request.setAttribute("ticketMsg", ticketMsg);
                            ticketMsg.setState(2);
                            String waitingRoom;
                            if(trainInfo.getWaitingRoom().contains("二")){
                                waitingRoom="2"+trainInfo.getWaitingRoom().replaceAll("二","");
                            }else{
                                waitingRoom="1"+trainInfo.getWaitingRoom().replaceAll("一","");
                            }
                            String voiceStr="您乘坐的@"+trainNumber+"@次列车，请到@"+waitingRoom+"@"+trainInfo.getJianPiaoKou()+"@检票口进入，经由通道至第@"+trainInfo.getStation()+"@站台乘车，距离发车还有约@"+distanceTime+"@";
                            String voiceName= new GetVoiceUtil().doAction(voiceStr);
                            request.setAttribute("audioUrl", PropertiesUtils.getProperty("audioUrl"));
                            request.setAttribute("voice", voiceName);
                        }else{
                            ticketMsg.setState(3);
                            ticketMsg.setMsg("您购买的  "+ticketData.getTrainNumber()+"  次列车车票已失效，请您扫描有效车票。");
                            request.setAttribute("ticketMsg", ticketMsg);
                            return "jsp:ticketMsg";
                        }
                        return "jsp:ticketMsg";
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ticketMsg.setMsg("参数错误！");
        request.setAttribute("ticketMsg", ticketMsg);
        return "jsp:ticketMsg";
    }

    @At("ticketqueryreEn")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object ticketQueryEn(HttpServletRequest request, @Param("code") String code) {
        TicketMsg ticketMsg = new TicketMsg();
        HashMap<String, Object> dataMap = new HashMap();
        ticketMsg.setUrl("state");
        ticketMsg.setUrl("secondEn.html");
        ticketMsg.setState(1);
        try {
            if (code != null && !code.trim().equals("")) {
                TicketQuery.TicketData ticketData = new TicketQuery().doAction(code);
                if (ticketData != null) {
                    String trainNumber = ticketData.getTrainNumber();
                    TrainInfo trainInfo = dao.fetch(TrainInfo.class, Cnd.where("trainNumber", "=", trainNumber).and("trainStationName","=",ticketData.getDepartStation()));
                    if (trainInfo != null) {
                        String dateString = ticketData.getDateString();
                        dateString = dateString.replaceAll("开", "");
                        ticketData.setDateString(dateString);
                        Date endDate = DateUtil.parse(dateString);
                        DistanceTime distanceTime = DateUtil.getDatePoorEn(endDate, new Date());
                        if(distanceTime.isFlag()){
                            /*HashMap<String,String> map=mapEnDict(trainInfo.getJianPiaoKou(),trainInfo.getStation(),trainInfo.getWaitingRoom());
                            dataMap.putAll(map);*/
                            dataMap.put("jiangPiaoKou",trainInfo.getJianPiaoKou());
                            dataMap.put("station",trainInfo.getStation());
                            dataMap.put("distanceTime", distanceTime);
                            dataMap.put("witingRoom",trainInfo.getWaitingRoomEn());
                            request.setAttribute("dataMap", dataMap);
                            ticketMsg.setMsg("");
                            ticketMsg.setTicketData(ticketData);
                            request.setAttribute("ticketMsg", ticketMsg);
                            String waitingRoom;
                            if(trainInfo.getWaitingRoom().contains("二")){
                                waitingRoom="2"+trainInfo.getWaitingRoom().replaceAll("二","");
                            }else{
                                waitingRoom="1"+trainInfo.getWaitingRoom().replaceAll("一","");
                            }
                            String voiceStr="您乘坐的@"+trainNumber+"@次列车，请到@"+waitingRoom+"@"+trainInfo.getJianPiaoKou()+"@检票口进入，经由通道至第@"+trainInfo.getStation()+"@站台乘车，距离发车还有约@"+distanceTime+"@";
                            String voiceName= new GetVoiceUtil().doAction(voiceStr);
                            request.setAttribute("voice", voiceName);
                            request.setAttribute("audioUrl", PropertiesUtils.getProperty("audioUrl"));
                            ticketMsg.setState(2);
                        }else{
                            ticketMsg.setState(3);
                            ticketMsg.setMsg("Your ticket has expired, please change a valid one.");
                            request.setAttribute("ticketMsg", ticketMsg);
                            return "jsp:ticketMsgEn";
                        }

                        return "jsp:ticketMsgEn";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ticketMsg.setMsg("参数错误！");
        request.setAttribute("ticketMsg", ticketMsg);
        return "jsp:ticketMsgEn";
    }
    @At("ticketqueryreNewMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object ticketqueryreNewMo(HttpServletRequest request, @Param("code") String code) {
        TicketMsg ticketMsg = new TicketMsg();
        HashMap<String, Object> dataMap = new HashMap();
        ticketMsg.setUrl("state");
        ticketMsg.setUrl("secondNewMo.html");
        ticketMsg.setState(1);
        try {
            if (code != null && !code.trim().equals("")) {
                TicketQuery.TicketData ticketData = new TicketQuery().doAction(code);
                if (ticketData != null) {
                    String trainNumber = ticketData.getTrainNumber();
                    TrainInfo trainInfo = dao.fetch(TrainInfo.class, Cnd.where("trainNumber", "=", trainNumber).and("trainStationName","=",ticketData.getDepartStation()));
                    if (trainInfo != null) {
                        String dateString = ticketData.getDateString();
                        dateString = dateString.replaceAll("开", "");
                        ticketData.setDateString(dateString);
                        Date endDate = DateUtil.parse(dateString);
                        DistanceTime distanceTime = DateUtil.getDatePoorNewMo(endDate, new Date());
                        if(distanceTime.isFlag()){
                            HashMap<String,String> map=mapNewMoDict(trainInfo.getJianPiaoKou(),trainInfo.getStation(),trainInfo.getWaitingRoom());
                            dataMap.putAll(map);
                            dataMap.put("distanceTime", distanceTime.getDistanceTime());
                            dataMap.put("witingRoom",trainInfo.getWaitingRoomSaoNewMo());
                            request.setAttribute("dataMap", dataMap);
                            ticketMsg.setMsg("");
                            ticketMsg.setTicketData(ticketData);
                            request.setAttribute("ticketMsg", ticketMsg);
                            String waitingRoom;
                            if(trainInfo.getWaitingRoom().contains("二")){
                                waitingRoom="2"+trainInfo.getWaitingRoom().replaceAll("二","");
                            }else{
                                waitingRoom="1"+trainInfo.getWaitingRoom().replaceAll("一","");
                            }
                            String voiceStr="您乘坐的@"+trainNumber+"@次列车，请到@"+waitingRoom+"@"+trainInfo.getJianPiaoKou()+"@检票口进入，经由通道至第@"+trainInfo.getStation()+"@站台乘车，距离发车还有约@"+distanceTime+"@";
                            String voiceName= new GetVoiceUtil().doAction(voiceStr);
                            request.setAttribute("voice", voiceName);
                            ticketMsg.setState(2);
                        }else{
                            ticketMsg.setState(3);
                            ticketMsg.setMsg("Танай худалдан авсан "+ticketData.getTrainNumber()+" дугаар ( дүгээр) галт тэргэний билет нэгэнт хүчнээ алдав , да хүчтэй билет ширвээрэй .");
                            request.setAttribute("ticketMsg", ticketMsg);
                            request.setAttribute("audioUrl", PropertiesUtils.getProperty("audioUrl"));
                            return "jsp:ticketMsgNewMo";
                        }

                        return "jsp:ticketMsgNewMo";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ticketMsg.setMsg("参数错误！");
        request.setAttribute("ticketMsg", ticketMsg);
        return "jsp:ticketMsgEn";
    }
    @At("ticketqueryOldMongolian")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object ticketQueryMongolian(HttpServletRequest request, HttpSession session, HttpServletResponse response,@Param("code") String code) {
        TicketMsg ticketMsg = new TicketMsg();
        HashMap<String, Object> dataMap = new HashMap();
        ticketMsg.setUrl("state");
        ticketMsg.setUrl("secondMo.html");
        ticketMsg.setState(1);
        try {
            if (code != null && !code.trim().equals("")) {
                TicketQuery.TicketData ticketData = new TicketQuery().doAction(code);
                if (ticketData != null) {
                    String trainNumber = ticketData.getTrainNumber();
                    TrainInfo trainInfo = dao.fetch(TrainInfo.class, Cnd.where("trainNumber", "=", trainNumber).and("trainStationName","=",ticketData.getDepartStation()));
                    if (trainInfo != null) {
                        String dateString = ticketData.getDateString();
                        dateString = dateString.replaceAll("开", "");
                        ticketData.setDateString(dateString);
                        Date endDate = DateUtil.parse(dateString);
                        DistanceTime distanceTime = DateUtil.getDatePoorMo(endDate, new Date());
                        if(distanceTime.isFlag()){
                            HashMap<String,String> map=mapDict(trainInfo.getJianPiaoKou(),trainInfo.getStation(),trainInfo.getWaitingRoom());
                            dataMap.putAll(map);
                            dataMap.put("distanceTime", distanceTime.getDistanceTime());
                            dataMap.put("witingRoom",trainInfo.getWaitingRoomSaoMo());
                            request.setAttribute("dataMap", dataMap);
                            ticketMsg.setMsg("");
                            ticketMsg.setTicketData(ticketData);
                            request.setAttribute("ticketMsg", ticketMsg);
                            request.setAttribute("trainInfo",trainInfo);
                            String waitingRoom;
                            if(trainInfo.getWaitingRoom().contains("二")){
                                waitingRoom="2"+trainInfo.getWaitingRoom().replaceAll("二","");
                            }else{
                                waitingRoom="1"+trainInfo.getWaitingRoom().replaceAll("一","");
                            }
                            String voiceStr="您乘坐的@"+trainNumber+"@次列车，请到@"+waitingRoom+"@"+trainInfo.getJianPiaoKou()+
                                    "@检票口进入，经由通道至第@"+trainInfo.getStation()+"@站台乘车，距离发车还有约@"+distanceTime+"@";
                            String voiceName= new GetVoiceUtil().doAction(voiceStr);
                            request.setAttribute("voice", voiceName);
                            request.setAttribute("audioUrl", PropertiesUtils.getProperty("audioUrl"));
                            ticketMsg.setState(2);
                        }else{
                            ticketMsg.setState(3);
                            ticketMsg.setMsg("ᠲᠠᠨ ᠤ ᠬᠤᠳᠠᠯᠳᠤᠨ ᠠᠪᠤᠭᠰᠠᠨ "+ticketData.getTrainNumber()+"  ᠳ᠋ᠤᠭᠠᠷ ( ᠳ᠋ᠦ᠋ᠭᠡᠷ) ᠭᠠᠯᠲᠤ ᠲᠡᠷᠭᠡᠨ ᠦ ᠪᠢᠯᠧᠲ ᠨᠢᠭᠡᠨᠲᠡ ᠬᠦᠴᠦᠨ ᠢᠶᠡᠨ ᠠᠯᠳᠠᠪᠠ ᠂ ᠲᠠ ᠬᠦᠴᠦᠨ ᠲᠡᠢ ᠪᠢᠯᠧᠲ ᠰᠢᠷᠪᠢᠭᠡᠷᠡᠢ ᠃");
                            request.setAttribute("ticketMsg", ticketMsg);
                            return "jsp:ticketMsgDetailMo";
                        }
                        return "jsp:ticketMsgDetailMo";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ticketMsg.setMsg("参数错误！");
        request.setAttribute("ticketMsg", ticketMsg);
        return "jsp:msgmongolian";
    }
    private HashMap<String,String> mapDict(String jiangPiaoKou,String station,String witingRoom){
        HashMap<String,String> hashMap=new HashMap<>();
        Dict dict1=dao.fetch(Dict.class,Cnd.where("chinese","=",jiangPiaoKou));
        Dict dict2=dao.fetch(Dict.class,Cnd.where("chinese","=",station));
        hashMap.put("jiangPiaoKou",dict1.getOldMongolian());
        hashMap.put("station",dict2.getOldMongolian());
        return hashMap;
    }
    private HashMap<String,String> mapEnDict(String jiangPiaoKou,String station,String witingRoom){
        HashMap<String,String> hashMap=new HashMap<>();
        Dict dict1=dao.fetch(Dict.class,Cnd.where("chinese","=",jiangPiaoKou));
        Dict dict2=dao.fetch(Dict.class,Cnd.where("chinese","=",station));
        hashMap.put("jiangPiaoKou",dict1.getEnglish());
        hashMap.put("station",dict2.getEnglish());
        return hashMap;
    }
    private HashMap<String,String> mapNewMoDict(String jiangPiaoKou,String station,String witingRoom){
        HashMap<String,String> hashMap=new HashMap<>();
        Dict dict1=dao.fetch(Dict.class,Cnd.where("chinese","=",jiangPiaoKou));
        Dict dict2=dao.fetch(Dict.class,Cnd.where("chinese","=",station));
        hashMap.put("jiangPiaoKou",dict1.getNewMongolian());
        hashMap.put("station",dict2.getNewMongolian());
        return hashMap;
    }
}