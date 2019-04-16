package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.bean.PageBean;
import com.imudges.web.railwaystationservice.entity.Dict;
import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.TrainInfo;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yangy on 2018/1/20.
 */
@IocBean
public class TrainInfoQueryModule {
    @Inject
    Dao dao;
    @At("trainInfoQuery")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoQuery(HttpServletRequest request,  @Param("keyword") String keyword, @Param("pc")int pc) {
        if(pc==0)
            pc=1;
        if(keyword==null||keyword.trim().isEmpty()){
            return ">>:/trainInfoQuery.html";
        }

        PageBean<TrainInfo> pageBean=getTrainInfoList(keyword,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("keyword",keyword);
        return "jsp:trainInfoQuery";
    }
    @At("trainInfoQueryEn")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoQueryEn(HttpServletRequest request,  @Param("keyword") String keyword, @Param("pc")int pc) {
        if(pc==0)
            pc=1;
        if(keyword==null||keyword.trim().isEmpty()){
            return ">>:/trainInfoQueryEn.html";
        }

        PageBean<TrainInfo> pageBean=getTrainInfoEnList(keyword,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("keyword",keyword);
        return "jsp:trainInfoQueryEn";
    }
    @At("trainInfoQueryNewMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoQueryNewMo(HttpServletRequest request,  @Param("keyword") String keyword, @Param("pc")int pc) {
        if(pc==0)
            pc=1;
        if(keyword==null||keyword.trim().isEmpty()){
            return ">>:/trainInfoQueryNewMo.html";
        }

        PageBean<TrainInfo> pageBean=getTrainInfoNewMoList(keyword,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("keyword",keyword);
        return "jsp:trainInfoQueryNewMo";
    }
    @At("trainInfoQueryMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoQueryMo(HttpServletRequest request,  @Param("keyword") String keyword, @Param("pc")int pc) {
        if(pc==0)
            pc=1;
        if(keyword==null||keyword.trim().isEmpty()){
            return ">>:/trainInfoQueryMo.html";
        }

        PageBean<TrainInfo> pageBean=getTrainInfoMoList(keyword,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("keyword",keyword);
        return "jsp:trainInfoQueryMo";
    }

    public PageBean<TrainInfo> getTrainInfoList(String keyword, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<TrainInfo> list = dao.query(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStation","like","%"+keyword+"%").or("terminus","like","%"+keyword+"%"), pager);
        PageBean<TrainInfo> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStation","like","%"+keyword+"%").or("terminus","like","%"+keyword+"%")));
        return pageBean;
    }
    public PageBean<TrainInfo> getTrainInfoEnList(String keyword, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<TrainInfo> list = dao.query(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStationEn","like","%"+keyword+"%").or("terminusEn","like","%"+keyword+"%"), pager);
        PageBean<TrainInfo> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStationEn","like","%"+keyword+"%").or("terminusEn","like","%"+keyword+"%")));
        return pageBean;
    }
    public PageBean<TrainInfo> getTrainInfoMoList(String keyword, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<TrainInfo> list = dao.query(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStationMo","like","%"+keyword+"%").or("terminusMo","like","%"+keyword+"%"), pager);
        PageBean<TrainInfo> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStationMo","like","%"+keyword+"%").or("terminusMo","like","%"+keyword+"%")));
        return pageBean;
    }
    public PageBean<TrainInfo> getTrainInfoNewMoList(String keyword, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<TrainInfo> list = dao.query(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStationNewMo","like","%"+keyword+"%").or("terminusNewMo","like","%"+keyword+"%"), pager);
        PageBean<TrainInfo> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                .or("startStationNewMo","like","%"+keyword+"%").or("terminusNewMo","like","%"+keyword+"%")));
        return pageBean;
    }
    public PageBean<TrainInfo> getTrainInfoListMo(String keyword, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        Dict dict=dao.fetch(Dict.class,Cnd.where("oldMongolian","=",keyword));
        PageBean<TrainInfo> pageBean=new PageBean<>();
        List<TrainInfo> list=null;
        if(dict!=null){
            dict.setChinese(dict.getChinese().replaceAll("到",""));
            dict.setChinese(dict.getChinese().replaceAll("从",""));
            list = dao.query(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                    .or("startStation","like","%"+dict.getChinese()+"%").or("terminus","like","%"+dict.getChinese()+"%"), pager);
            pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")
                    .or("startStation","like","%"+dict.getChinese()+"%").or("terminus","like","%"+dict.getChinese()+"%")));
        }else{
            list = dao.query(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%"), pager);
            pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber","like","%"+keyword+"%")));
        }
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        return pageBean;
    }
    @At("trainInfoDetail")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoDetail(HttpServletRequest request,  @Param("trainInfoId") int trainInfoId) {
        Msg msg=new Msg();
        TrainInfo trainInfo=dao.fetch(TrainInfo.class,trainInfoId);
        if(trainInfo==null){
            msg.setState(1);
            msg.setMsg("没有该列车信息！");
        }
        request.setAttribute("msg",msg);
        request.setAttribute("trainInfo",trainInfo);
        return "jsp:trainInfoDetail";
    }
    @At("trainInfoDetailEn")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoDetailEn(HttpServletRequest request,  @Param("trainInfoId") int trainInfoId) {
        Msg msg=new Msg();
        TrainInfo trainInfo=dao.fetch(TrainInfo.class,trainInfoId);
        if(trainInfo==null){
            msg.setState(1);
            msg.setMsg("没有该列车信息！");
        }
        request.setAttribute("msg",msg);
        request.setAttribute("trainInfo",trainInfo);
        return "jsp:trainInfoDetailEn";
    }
    @At("trainInfoDetailMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoDetailMo(HttpServletRequest request,  @Param("trainInfoId") int trainInfoId) {
        Msg msg=new Msg();
        TrainInfo trainInfo=dao.fetch(TrainInfo.class,trainInfoId);
        if(trainInfo==null){
            msg.setState(1);
            msg.setMsg("没有该列车信息！");
        }
        msg.setState(2);
        request.setAttribute("msg",msg);
        request.setAttribute("trainInfo",trainInfo);
        return "jsp:trainInfoDetailMo";
    }
    @At("trainInfoDetailNewMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object trainInfoDetailNewMo(HttpServletRequest request,  @Param("trainInfoId") int trainInfoId) {
        Msg msg=new Msg();
        TrainInfo trainInfo=dao.fetch(TrainInfo.class,trainInfoId);
        if(trainInfo==null){
            msg.setState(1);
            msg.setMsg("没有该列车信息！");
        }
        request.setAttribute("msg",msg);
        request.setAttribute("trainInfo",trainInfo);
        return "jsp:trainInfoDetailNewMo";
    }

}
