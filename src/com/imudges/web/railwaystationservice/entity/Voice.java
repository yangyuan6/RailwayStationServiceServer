package com.imudges.web.railwaystationservice.entity;

import java.util.ArrayList;

/**
 * Created by yangy on 2018/1/15.
 */
public class Voice {
    private String text;
    private ArrayList<String> replaceStrs;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getReplaceStrs() {
        return replaceStrs;
    }

    public void setReplaceStrs(ArrayList<String> replaceStrs) {
        this.replaceStrs = replaceStrs;
    }
}
