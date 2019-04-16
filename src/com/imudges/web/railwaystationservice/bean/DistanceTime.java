package com.imudges.web.railwaystationservice.bean;

/**
 * Created by yangy on 2018/1/29.
 */
public class DistanceTime {
    private boolean flag=true;
    private String distanceTime;
    private String getDistanceTimeCn;

    public String getDistanceTime() {
        return distanceTime;
    }

    public void setDistanceTime(String distanceTime) {
        this.distanceTime = distanceTime;
    }

    public String getGetDistanceTimeCn() {
        return getDistanceTimeCn;
    }

    public void setGetDistanceTimeCn(String getDistanceTimeCn) {
        this.getDistanceTimeCn = getDistanceTimeCn;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
