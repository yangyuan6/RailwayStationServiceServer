package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.bean.PageBean;
import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.Question;
import com.imudges.web.railwaystationservice.util.IDTools;
import org.apache.commons.io.FileUtils;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yangy on 2018/2/5.
 */

@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/admin/login.html"}))
public class AdminQuestionModule {
    @Inject
    Dao dao;

    @At("admin/questionQuery")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object questionQuery(HttpServletRequest request, @Param("pc") int pc) {
        if (pc == 0)
            pc = 1;
        PageBean<Question> pageBean = getQuestionList(pc, 6);
        request.setAttribute("pb", pageBean);
        return "jsp:admin/question";
    }

    @At("admin/questionDelete")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object questionDelete(HttpServletRequest request, @Param("id") Integer questionId) {
        Msg msg = new Msg();
        request.setAttribute("msg", msg);
        if (questionId == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        Question question1 = dao.fetch(Question.class, questionId);
        if (question1 == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        try {

            String targetFilePath = request.getSession().getServletContext().getRealPath("") + "resource\\question\\cn\\china-" + question1.getVoice();
            String targetFilePathEn = request.getSession().getServletContext().getRealPath("") + "resource\\question\\en\\" + question1.getVoice();
            String targetFilePathMo = request.getSession().getServletContext().getRealPath("") + "resource\\question\\mo\\a\\mon-" + question1.getVoice();
            File file = new File(targetFilePath);
            File fileEn = new File(targetFilePathEn);
            File fileMo = new File(targetFilePathMo);
            /*if (!file.exists() || !fileEn.exists() || !fileMo.exists()) {
                msg.setMsg("参数错误！");
                return "jsp:admin/msg";
            }*/
            file.deleteOnExit();
            fileEn.deleteOnExit();
            fileMo.deleteOnExit();
            dao.delete(Question.class, questionId);
            msg.setMsg("删除成功！");
            msg.setState(1);
            msg.setUrl("questionQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("删除失败！");
        return "jsp:admin/msg";

    }

    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
    @At("admin/questionUpdate")
    @Ok("re")
    @Fail("http:500")
    @POST
    public Object questionUpdate(HttpServletRequest request,
                                 @Param("id") Integer id,
                                 @Param("question") String question,
                                 @Param("questionEn") String questionEn,
                                 @Param("questionMo") String questionMo,
                                 @Param("questionNewMo") String questionNewMo,
                                 @Param("answer") String answer,
                                 @Param("answerEn") String answerEn,
                                 @Param("answerMo") String answerMo,
                                 @Param("answerNewMo") String answerNewMo,
                                 @Param("voice") TempFile voiceFile,
                                 @Param("voiceMo") TempFile voiceFileMo,
                                 @Param("voiceEn") TempFile voiceFileEn

    ) {
        Msg msg = new Msg();
        request.setAttribute("msg", msg);
        if (id == null || question == null || "".equals(question)
                || questionEn == null || "".equals(questionEn)
                || questionMo == null || "".equals(questionMo)
                || questionNewMo == null || "".equals(questionNewMo)
                || answer == null || "".equals(answer)
                || answerEn == null || "".equals(answerEn)
                || answerMo == null || "".equals(answerMo)
                || answerNewMo == null || "".equals(answerNewMo)

                ) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        Question question1 = dao.fetch(Question.class, id);
        if (question1 == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        if (voiceFile != null && voiceFileEn == null
                && voiceFileMo == null) {
            String targetFilePath = request.getSession().getServletContext().getRealPath("") + "\\resource\\question\\cn\\china-" + question1.getVoice();
            String targetFilePathEn = request.getSession().getServletContext().getRealPath("") + "\\resource\\question\\en\\" + question1.getVoice();
            String targetFilePathMo = request.getSession().getServletContext().getRealPath("") + "\\resource\\question\\mo\\a\\mon-" + question1.getVoice();
            File file = new File(targetFilePath);
            File fileEn = new File(targetFilePathEn);
            File fileMo = new File(targetFilePathMo);
            if (!file.exists() || !fileEn.exists() || !fileMo.exists()) {
                msg.setMsg("参数错误！");
                return "jsp:admin/msg";
            }
            try {
                FileUtils.moveFile(voiceFile.getFile(), file);
                FileUtils.moveFile(voiceFileEn.getFile(), fileEn);
                FileUtils.moveFile(voiceFileMo.getFile(), fileMo);
            } catch (IOException e) {
                e.printStackTrace();
                msg.setMsg("更新失败！");
                return "jsp:admin/msg";
            }
        }
        Question question2 = new Question(id, question, questionEn, questionMo, questionNewMo, answer, answerEn, answerMo, answerNewMo, question1.getVoice());
        try {
            dao.update(question2);
            msg.setMsg("更新成功！");
            msg.setState(1);
            msg.setUrl("questionQuery.php");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "jsp:admin/msg";

    }

    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:myUpload"})
    @At("admin/questionAdd")
    @Ok("re")
    @Fail("http:500")
    @POST
    public Object questionAdd(HttpServletRequest request,
                              @Param("question") String question,
                              @Param("questionEn") String questionEn,
                              @Param("questionMo") String questionMo,
                              @Param("questionNewMo") String questionNewMo,
                              @Param("answer") String answer,
                              @Param("answerEn") String answerEn,
                              @Param("answerMo") String answerMo,
                              @Param("answerNewMo") String answerNewMo,
                              @Param("voice") TempFile voiceFile,
                              @Param("voiceMo") TempFile voiceFileMo,
                              @Param("voiceEn") TempFile voiceFileEn
    ) {
        Msg msg = new Msg();
        if (question == null || "".equals(question)
                || questionEn == null || "".equals(questionEn)
                || questionMo == null || "".equals(questionMo)
                || questionNewMo == null || "".equals(questionNewMo)
                || answer == null || "".equals(answer)
                || answerEn == null || "".equals(answerEn)
                || answerMo == null || "".equals(answerMo)
                || answerNewMo == null || "".equals(answerNewMo)
                || voiceFile == null || voiceFileEn == null
                || voiceFileMo == null
                ) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        String fileType = voiceFile.getFile().getName().substring(voiceFile.getFile().getName().lastIndexOf("."));
        String fileTypeEn = voiceFile.getFile().getName().substring(voiceFile.getFile().getName().lastIndexOf("."));
        String fileTypeMo = voiceFile.getFile().getName().substring(voiceFile.getFile().getName().lastIndexOf("."));
        if (!".wav".equals(fileType) || !".wav".equals(fileTypeEn) || !".wav".equals(fileTypeMo)) {
            msg.setMsg("请上传wav格式的音频文件！");
            return "jsp:admin/msg";
        }
        String voice = IDTools.getId() + ".wav";
        String targetFilePath = request.getSession().getServletContext().getRealPath("") + "\\resource\\question\\cn\\china-" + voice;
        String targetFilePathEn = request.getSession().getServletContext().getRealPath("") + "\\resource\\question\\en\\" + voice;
        String targetFilePathMo = request.getSession().getServletContext().getRealPath("") + "\\resource\\question\\mo\\a\\mon-" + voice;
        System.out.println(targetFilePath);
        File file = new File(targetFilePath);
        File fileEn = new File(targetFilePathEn);
        File fileMo = new File(targetFilePathMo);
        try {
            FileUtils.moveFile(voiceFile.getFile(), file);
            FileUtils.moveFile(voiceFileEn.getFile(), fileEn);
            FileUtils.moveFile(voiceFileMo.getFile(), fileMo);
        } catch (IOException e) {
            e.printStackTrace();
            msg.setMsg("添加失败！");
            return "jsp:admin/msg";
        }
        Question question2 = new Question();
        question2.setQuestion(question);
        question2.setQuestionEn(questionEn);
        question2.setQuestionMo(questionMo);
        question2.setQuestionNewMo(questionNewMo);
        question2.setAnswer(answer);
        question2.setAnswerEn(answerEn);
        question2.setAnswerMo(answerMo);
        question2.setAnswerNewMo(answerNewMo);
        question2.setVoice(voice);
        request.setAttribute("msg", msg);
        try {
            dao.insert(question2);
            msg.setMsg("添加成功！");
            msg.setState(1);
            msg.setUrl("questionQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("添加失败！");
        }
        return "jsp:admin/msg";

    }

    public PageBean<Question> getQuestionList(int pc, int pageSize) {
        Pager pager = dao.createPager(pc, pageSize);
        List<Question> list = dao.query(Question.class, null, pager);
        PageBean<Question> pageBean = new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(Question.class, null));
        return pageBean;
    }
}
