package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.User;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CheckSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yangy on 2018/1/3.
 */
@IocBean
public class UserModule {
    @Inject
    Dao dao;

    @At("admin/login")
    @Ok("re")
    @Fail("http:500")
    @POST
    public Object login(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("userName") String userName, @Param("password") String password) {
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if (userName == null || password == null || "".equals(userName) || "".equals(password)) {
            msg.setMsg("户名或密码错误！");
            return "jsp:admin/msg";
        }
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        User user1=dao.fetch(User.class, Cnd.where("userName","=",userName).and("password","=",password));
        if(user1==null){
            msg.setMsg("户名或密码错误！");
            return "jsp:admin/msg";
        }
        user1.setPassword("");
        session.setAttribute("user",user1);
        return "jsp:admin/index";
    }
    @At("admin/logout")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object logout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        session.removeAttribute("user");
        return ">>:/admin/login.html";
    }
    @Filters(@By(type=CheckSession.class, args={"user", "/admin/login.html"}))
    @At("admin/index")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object admin(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        return ">>:/admin/index";
    }
}
