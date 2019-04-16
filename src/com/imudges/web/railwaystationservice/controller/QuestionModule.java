package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.bean.PageBean;
import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.Question;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangy on 2018/1/9.
 */
@IocBean
public class QuestionModule {
    @Inject
    Dao dao;
    @At("questionQuery")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQuery(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("question") String question,@Param("pc")int pc) {
        if(pc==0)
            pc=1;
        /*if(question==null||question.trim().isEmpty()){
            return ">>:/question.html";
        }*/
        if (question == null) {
            question = "";
        }
        PageBean<Question> pageBean=getQuestionList(question,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("question",question);
        return "jsp:question";
    }
    @At("questionQueryAll")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQueryAll(HttpServletRequest request) {

        List<Question> questions=dao.query(Question.class,Cnd.where("question","like","%%"));
        int halfsize=questions.size()/2;
        ArrayList<Question> questions1=new ArrayList<>();
        ArrayList<Question> questions2=new ArrayList<>();
        for(int i=0;i<questions.size();i++){
            if (i<halfsize){
                questions1.add(questions.get(i));
            }else
                questions2.add(questions.get(i));
        }
        request.setAttribute("questions1",questions1);
        request.setAttribute("questions2",questions2);
        return "jsp:questionAll";
    }
    @At("questionQueryAllEn")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQueryAllEn(HttpServletRequest request) {

        List<Question> questions=dao.query(Question.class,Cnd.where("question","like","%%"));
        int halfsize=questions.size()/2;
        ArrayList<Question> questions1=new ArrayList<>();
        ArrayList<Question> questions2=new ArrayList<>();
        for(int i=0;i<questions.size();i++){
            if (i<halfsize){
                questions1.add(questions.get(i));
            }else
                questions2.add(questions.get(i));
        }
        request.setAttribute("questions1",questions1);
        request.setAttribute("questions2",questions2);
        return "jsp:questionAllEn";
    }
    @At("questionQueryAllNewMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQueryAllNewMo(HttpServletRequest request) {

        List<Question> questions=dao.query(Question.class,Cnd.where("question","like","%%"));
        int halfsize=questions.size()/2;
        ArrayList<Question> questions1=new ArrayList<>();
        ArrayList<Question> questions2=new ArrayList<>();
        for(int i=0;i<questions.size();i++){
            if (i<halfsize){
                questions1.add(questions.get(i));
            }else
                questions2.add(questions.get(i));
        }
        request.setAttribute("questions1",questions1);
        request.setAttribute("questions2",questions2);
        return "jsp:questionAllNewMo";
    }
    @At("questionQueryAllMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQueryAllMo(HttpServletRequest request) {

        List<Question> questions=dao.query(Question.class,Cnd.where("question","like","%%"),new Pager(1,15));
        int halfsize=questions.size()/2;
        ArrayList<Question> questions1=new ArrayList<>();
        ArrayList<Question> questions2=new ArrayList<>();
        for(int i=0;i<questions.size();i++){
            if (i<halfsize){
                questions1.add(questions.get(i));
            }else
                questions2.add(questions.get(i));
        }
        request.setAttribute("questions1",questions1);
        request.setAttribute("questions2",questions2);
        return "jsp:questionAllMo";
    }

    @At("questionQueryMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionMoQuery(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("question") String question,@Param("pc")int pc) {
        if(pc==0)
            pc=1;
        /*if(question==null||question.trim().isEmpty()){
            return ">>:/questionMo.html";
        }*/
        if (question == null) {
            question = "";
        }
        PageBean<Question> pageBean=getQuestionMoList(question,pc,6);
        request.setAttribute("pb",pageBean);
        request.setAttribute("question",question);
        return "jsp:questionMo";
    }
    @At("questionQueryEn")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQueryEn(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("question") String question,@Param("pc")int pc) {
        if(pc==0)
            pc=1;
        /*if(question==null||question.trim().isEmpty()){
            return ">>:/questionEn.html";
        }
*/
        if (question == null) {
            question = "";
        }
        PageBean<Question> pageBean=getQuestionEnList(question,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("question",question);
        return "jsp:questionEn";
    }
    @At("questionQueryNewMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionQueryNewMo(HttpServletRequest request, HttpSession session, HttpServletResponse response, @Param("question") String question,@Param("pc")int pc) {
        if(pc==0)
            pc=1;
      /*  if(question==null||question.trim().isEmpty()){
            return ">>:/questionNewMo.html";
        }
*/
        if (question == null) {
            question = "";
        }
        PageBean<Question> pageBean=getQuestionNewMoList(question,pc,6);


        request.setAttribute("pb",pageBean);
        request.setAttribute("question",question);
        return "jsp:questionNewMo";
    }
    public PageBean<Question> getQuestionList(String question, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<Question> list = dao.query(Question.class, Cnd.where("question","like","%"+question+"%"), pager);
        PageBean<Question> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(Question.class,Cnd.where("question","like","%"+question+"%")));
        return pageBean;
    }
    public PageBean<Question> getQuestionMoList(String question, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<Question> list = dao.query(Question.class, Cnd.where("questionMo","like","%"+question+"%"), pager);
        PageBean<Question> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(Question.class,Cnd.where("questionMo","like","%"+question+"%")));
        return pageBean;
    }
    public PageBean<Question> getQuestionEnList(String question, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<Question> list = dao.query(Question.class, Cnd.where("questionEn","like","%"+question+"%"), pager);
        PageBean<Question> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(Question.class,Cnd.where("questionEn","like","%"+question+"%")));
        return pageBean;
    }
    public PageBean<Question> getQuestionNewMoList(String question, int pc, int pageSize){
        Pager pager = dao.createPager(pc, pageSize);
        List<Question> list = dao.query(Question.class, Cnd.where("questionNewMo","like","%"+question+"%"), pager);
        PageBean<Question> pageBean=new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(Question.class,Cnd.where("questionNewMo","like","%"+question+"%")));
        return pageBean;
    }

    @At("questionDetail")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionDetail(HttpServletRequest request,  @Param("questionId") int questionId) {
        Msg msg=new Msg();
        msg.setUrl("question.html");
        Question question=dao.fetch(Question.class,questionId);
        if(question==null){
            msg.setState(1);
            msg.setMsg("没有该问题！");
            return "jsp:questionDetail";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("question",question);
        return "jsp:questionDetail";
    }
    @At("questionDetailMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionMoDetail(HttpServletRequest request,  @Param("questionId") int questionId) {
        Msg msg=new Msg();
        msg.setUrl("questionMo.html");
        Question question=dao.fetch(Question.class,questionId);
        if(question==null){
            msg.setState(1);
            msg.setMsg("没有该问题！");
            return "jsp:questionMoDetail";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("question",question);
        return "jsp:questionDetailMo";
    }
    @At("questionDetailEn")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionDetailEn(HttpServletRequest request,  @Param("questionId") int questionId) {
        Msg msg=new Msg();
        msg.setUrl("questionEn.html");
        Question question=dao.fetch(Question.class,questionId);
        if(question==null){
            msg.setState(1);
            msg.setMsg("没有该问题！");
            return "jsp:questionDetailEn";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("question",question);
        return "jsp:questionDetailEn";
    }
    @At("questionDetailNewMo")
    @Ok("re")
    @Fail("http:500")
    @GET
    @POST
    public Object questionDetailNewMo(HttpServletRequest request,  @Param("questionId") int questionId) {
        Msg msg=new Msg();
        msg.setUrl("questionNewMo.html");
        Question question=dao.fetch(Question.class,questionId);
        if(question==null){
            msg.setState(1);
            msg.setMsg("没有该问题！");
            return "jsp:questionDetailNewMo";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("question",question);
        return "jsp:questionDetailNewMo";
    }

}
