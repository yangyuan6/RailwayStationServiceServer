package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.entity.Admin;
import com.imudges.web.railwaystationservice.entity.Msg;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yangy on 2018/2/4.
 */
@IocBean
public class AdminModule {
    @Inject
    Dao dao;
    @At("admin/adminLogin")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object userLogin(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("userName") String userName, @Param("password")String password) {
        if(userName==null||userName.trim().isEmpty()||password==null||password.trim().isEmpty()){
            return ">>:/admin/adminLogin.html";
        }
        Admin admin=dao.fetch(Admin.class, Cnd.where("userName","=",userName).and("password","=",password));
        if(admin!=null){
            admin.setPassword("");
            session.setAttribute("user",admin);
            session.setAttribute("admin",admin);
            return "jsp:admin/adminIndex";
        }else{
            Msg msg=new Msg();
            msg.setMsg("用户名或密码错误！");
            request.setAttribute("msg",msg);
            return "jsp:admin/msg";
//            return ">>:/admin/login.html";
        }
    }
    @At("admin/adminLogout")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object userLogout(HttpServletRequest request, HttpSession session) {
            session.removeAttribute("user");
            session.removeAttribute("admin");
           return ">>:/admin/adminLogin.html";
    }
}
