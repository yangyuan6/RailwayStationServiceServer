package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.util.PropertiesUtils;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yangy on 2018/3/1.
 */
@IocBean
public class TestPro {
    @At("testProperties")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object test(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        Msg msg=new Msg();
        String audioUrl= PropertiesUtils.getProperty("audioUrl");
        request.setAttribute("audioUrl",audioUrl);
        return "jsp:test";
    }
}
