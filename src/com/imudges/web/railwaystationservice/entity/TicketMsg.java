package com.imudges.web.railwaystationservice.entity;

import com.imudges.web.railwaystationservice.util.TicketQuery;

public class TicketMsg {
    private String msg;
    private Integer state;
    private String url;
    private TicketQuery.TicketData ticketData;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TicketQuery.TicketData getTicketData() {
        return ticketData;
    }

    public void setTicketData(TicketQuery.TicketData ticketData) {
        this.ticketData = ticketData;
    }
}
