package com.imudges.web.railwaystationservice.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by yangy on 2018/1/9.
 */
@Table("tb_question")
public class Question {
    @Id
    private int id;
    @Column
    private String question;
    @Column
    private String questionEn;
    @Column
    private String questionMo;
    @Column
    private String questionNewMo;
    @Column
    private String answer;
    @Column
    private String answerEn;
    @Column
    private String answerMo;
    @Column
    private String answerNewMo;
    @Column
    private String voice;

    public Question() {
    }

    public Question(int id, String question, String questionEn, String questionMo, String questionNewMo, String answer, String answerEn, String answerMo, String answerNewMo, String voice) {
        this.id = id;
        this.question = question;
        this.questionEn = questionEn;
        this.questionMo = questionMo;
        this.questionNewMo = questionNewMo;
        this.answer = answer;
        this.answerEn = answerEn;
        this.answerMo = answerMo;
        this.answerNewMo = answerNewMo;
        this.voice = voice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionEn() {
        return questionEn;
    }

    public void setQuestionEn(String questionEn) {
        this.questionEn = questionEn;
    }

    public String getQuestionMo() {
        return questionMo;
    }

    public void setQuestionMo(String questionMo) {
        this.questionMo = questionMo;
    }

    public String getQuestionNewMo() {
        return questionNewMo;
    }

    public void setQuestionNewMo(String questionNewMo) {
        this.questionNewMo = questionNewMo;
    }

    public String getAnswerEn() {
        return answerEn;
    }

    public void setAnswerEn(String answerEn) {
        this.answerEn = answerEn;
    }

    public String getAnswerMo() {
        return answerMo;
    }

    public void setAnswerMo(String answerMo) {
        this.answerMo = answerMo;
    }

    public String getAnswerNewMo() {
        return answerNewMo;
    }

    public void setAnswerNewMo(String answerNewMo) {
        this.answerNewMo = answerNewMo;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
