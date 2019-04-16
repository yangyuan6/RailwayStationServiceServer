package com.imudges.web.railwaystationservice.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by yangy on 2018/1/16.
 */
@Table("tb_dict")
public class Dict {
    @Id
    private int id;
    @Column
    private String chinese;
    @Column
    private String oldMongolian;
    @Column
    private String newMongolian;
    @Column
    private String english;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getOldMongolian() {
        return oldMongolian;
    }

    public void setOldMongolian(String oldMongolian) {
        this.oldMongolian = oldMongolian;
    }

    public String getNewMongolian() {
        return newMongolian;
    }

    public void setNewMongolian(String newMongolian) {
        this.newMongolian = newMongolian;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
