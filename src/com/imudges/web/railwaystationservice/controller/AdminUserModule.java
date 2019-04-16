package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.bean.PageBean;
import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.User;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CheckSession;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yangy on 2018/2/28.
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"admin", "/admin/adminLogin.html"}))
public class AdminUserModule {
    @Inject
    Dao dao;

    @At("admin/userQuery")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object userQuery(HttpServletRequest request,  @Param("pc") int pc) {
        if (pc == 0)
            pc = 1;
        PageBean<User> pageBean = getUserList(pc, 10);
        request.setAttribute("pb", pageBean);
        return "jsp:admin/user";
    }
    @At("admin/userAdd")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object userAdd(HttpServletRequest request, @Param("userName")String userName, @Param("password")String password){
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if(userName==null||"".equals(userName)||password==null||"".equals(password)){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        try {
            dao.insert(user);
            msg.setMsg("添加成功！");
            msg.setState(1);
            msg.setUrl("userQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("添加失败！");
        return "jsp:admin/msg";
    }
    @At("admin/userUpdate")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object userUpdate(HttpServletRequest request,@Param("id")Integer id,@Param("userName")String userName,@Param("password")String password){
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if(id==null||userName==null||"".equals(userName)||password==null||"".equals(password)){
            request.setAttribute("msg",msg);
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        User user=dao.fetch(User.class,id);
        if(user==null){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        User user1=new User();
        user.setUserName(userName);
        user.setPassword(password);
        try {
            dao.update(user1);
            msg.setMsg("更新成功！");
            msg.setState(1);
            msg.setUrl("userQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("更新失败！");
        return "jsp:admin/msg";
    }
    @At("admin/userDelete")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object userDelete(HttpServletRequest request,@Param("id")Integer id){
        Msg msg=new Msg();
        request.setAttribute("msg",msg);
        if(id==null){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        User user=dao.fetch(User.class,id);
        if(user==null){
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        try {
            dao.delete(User.class, id);
            msg.setMsg("删除成功！");
            msg.setState(1);
            msg.setUrl("userQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("删除失败！");
        return "jsp:admin/msg";
    }
    public PageBean<User> getUserList(int pc, int pageSize) {
        Pager pager = dao.createPager(pc, pageSize);
        List<User> list = dao.query(User.class,null, pager);
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(User.class, null));
        return pageBean;
    }
}
