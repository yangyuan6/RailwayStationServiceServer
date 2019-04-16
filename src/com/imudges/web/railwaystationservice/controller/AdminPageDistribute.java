package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.Question;
import com.imudges.web.railwaystationservice.entity.TrainInfo;
import com.imudges.web.railwaystationservice.entity.User;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CheckSession;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangy on 2018/2/26.
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/admin/login.html"}))
public class AdminPageDistribute {
    @Inject
    Dao dao;
    @At("admin/addQuestion")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object addQuestion(HttpServletRequest request) {
        return "jsp:admin/addQuestion";
    }
    @At("admin/updateQuestion")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object updateQuestion(HttpServletRequest request, @Param("id") Integer id) {
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if(id==null){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        Question question1 = dao.fetch(Question.class, id);
        if (question1 == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        request.setAttribute("question",question1);
        return "jsp:admin/updateQuestion";
    }
    @At("admin/addTrainInfo")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object addTrainInfo(HttpServletRequest request) {
        return "jsp:admin/addTrainInfo";
    }
    @At("admin/updateTrainInfo")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object updateTrainInfo(HttpServletRequest request, @Param("id") Integer id) {
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if(id==null){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        TrainInfo trainInfo = dao.fetch(TrainInfo.class, id);
        if (trainInfo == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        request.setAttribute("trainInfo",trainInfo);
        return "jsp:admin/updateTrainInfo";
    }

    @At("admin/addUser")
    @Filters(@By(type=CheckSession.class, args={"admin", "/admin/adminLogin.html"}))
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object addUser(HttpServletRequest request) {
        return "jsp:admin/addUser";
    }
    @At("admin/updateUser")
    @Filters(@By(type=CheckSession.class, args={"admin", "/admin/adminLogin.html"}))
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object updateUser(HttpServletRequest request, @Param("id") Integer id) {
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if(id==null){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        User user = dao.fetch(User.class, id);
        if (user == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        request.setAttribute("user",user);
        return "jsp:admin/updateUser";
    }
}
