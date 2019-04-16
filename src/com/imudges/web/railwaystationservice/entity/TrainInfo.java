package com.imudges.web.railwaystationservice.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by yangy on 2018/1/9.
 */
@Table("tb_train_info")
public class TrainInfo {
    @Id
    private int id;
    @Column
    private String trainNumber;

    @Column
    private String startStation;
    @Column
    private String startStationMo;
    @Column
    private String startStationNewMo;
    @Column
    private String startStationEn;
    //终点站
    @Column
    private String terminus;
    @Column
    private String terminusMo;
    @Column
    private String terminusNewMo;
    @Column
    private String terminusEn;
    @Column
    private String daoDian;
    @Column
    private String kaiDian;
    @Column
    private String station;
    @Column
    private String jianPiaoKou;
    @Column
    private String trainStationName;
    @Column
    private String trainStationNameMo;
    @Column
    private String trainStationNameEn;
    @Column
    private String trainStationNameNewMo;
    @Column
    private String trainType;
    @Column
    private String waitingRoom;
    @Column
    private String waitingRoomSaoMo;
    @Column
    private String waitingRoomSaoNewMo;
    @Column
    private String waitingRoomMo;
    @Column
    private String waitingRoomNewMo;
    @Column
    private String waitingRoomEn;

    public TrainInfo() {
    }

    public TrainInfo(int id, String trainNumber, String startStation, String startStationMo, String startStationNewMo, String startStationEn, String terminus, String terminusMo, String terminusNewMo, String terminusEn, String daoDian, String kaiDian, String station, String jianPiaoKou, String trainStationName, String trainStationNameMo, String trainStationNameEn, String trainStationNameNewMo, String trainType, String waitingRoom, String waitingRoomSaoMo, String waitingRoomSaoNewMo, String waitingRoomMo, String waitingRoomNewMo, String waitingRoomEn) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.startStation = startStation;
        this.startStationMo = startStationMo;
        this.startStationNewMo = startStationNewMo;
        this.startStationEn = startStationEn;
        this.terminus = terminus;
        this.terminusMo = terminusMo;
        this.terminusNewMo = terminusNewMo;
        this.terminusEn = terminusEn;
        this.daoDian = daoDian;
        this.kaiDian = kaiDian;
        this.station = station;
        this.jianPiaoKou = jianPiaoKou;
        this.trainStationName = trainStationName;
        this.trainStationNameMo = trainStationNameMo;
        this.trainStationNameEn = trainStationNameEn;
        this.trainStationNameNewMo = trainStationNameNewMo;
        this.trainType = trainType;
        this.waitingRoom = waitingRoom;
        this.waitingRoomSaoMo = waitingRoomSaoMo;
        this.waitingRoomSaoNewMo = waitingRoomSaoNewMo;
        this.waitingRoomMo = waitingRoomMo;
        this.waitingRoomNewMo = waitingRoomNewMo;
        this.waitingRoomEn = waitingRoomEn;
    }

    public TrainInfo(String trainNumber, String startStation, String startStationMo, String startStationNewMo, String startStationEn, String terminus, String terminusMo, String terminusNewMo, String terminusEn, String daoDian, String kaiDian, String station, String jianPiaoKou, String trainStationName, String trainStationNameMo, String trainStationNameEn, String trainStationNameNewMo, String trainType, String waitingRoom, String waitingRoomSaoMo, String waitingRoomSaoNewMo, String waitingRoomMo, String waitingRoomNewMo, String waitingRoomEn) {
        this.trainNumber = trainNumber;
        this.startStation = startStation;
        this.startStationMo = startStationMo;
        this.startStationNewMo = startStationNewMo;
        this.startStationEn = startStationEn;
        this.terminus = terminus;
        this.terminusMo = terminusMo;
        this.terminusNewMo = terminusNewMo;
        this.terminusEn = terminusEn;
        this.daoDian = daoDian;
        this.kaiDian = kaiDian;
        this.station = station;
        this.jianPiaoKou = jianPiaoKou;
        this.trainStationName = trainStationName;
        this.trainStationNameMo = trainStationNameMo;
        this.trainStationNameEn = trainStationNameEn;
        this.trainStationNameNewMo = trainStationNameNewMo;
        this.trainType = trainType;
        this.waitingRoom = waitingRoom;
        this.waitingRoomSaoMo = waitingRoomSaoMo;
        this.waitingRoomSaoNewMo = waitingRoomSaoNewMo;
        this.waitingRoomMo = waitingRoomMo;
        this.waitingRoomNewMo = waitingRoomNewMo;
        this.waitingRoomEn = waitingRoomEn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getTerminus() {
        return terminus;
    }

    public void setTerminus(String terminus) {
        this.terminus = terminus;
    }

    public String getDaoDian() {
        return daoDian;
    }

    public void setDaoDian(String daoDian) {
        this.daoDian = daoDian;
    }

    public String getKaiDian() {
        return kaiDian;
    }

    public void setKaiDian(String kaiDian) {
        this.kaiDian = kaiDian;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getJianPiaoKou() {
        return jianPiaoKou;
    }

    public void setJianPiaoKou(String jianPiaoKou) {
        this.jianPiaoKou = jianPiaoKou;
    }

    public String getTrainStationName() {
        return trainStationName;
    }

    public void setTrainStationName(String trainStationName) {
        this.trainStationName = trainStationName;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getWaitingRoom() {
        return waitingRoom;
    }

    public void setWaitingRoom(String waitingRoom) {
        this.waitingRoom = waitingRoom;
    }

    public String getStartStationMo() {
        return startStationMo;
    }

    public void setStartStationMo(String startStationMo) {
        this.startStationMo = startStationMo;
    }

    public String getStartStationNewMo() {
        return startStationNewMo;
    }

    public void setStartStationNewMo(String startStationNewMo) {
        this.startStationNewMo = startStationNewMo;
    }

    public String getStartStationEn() {
        return startStationEn;
    }

    public void setStartStationEn(String startStationEn) {
        this.startStationEn = startStationEn;
    }

    public String getTerminusMo() {
        return terminusMo;
    }

    public void setTerminusMo(String terminusMo) {
        this.terminusMo = terminusMo;
    }

    public String getTerminusNewMo() {
        return terminusNewMo;
    }

    public void setTerminusNewMo(String terminusNewMo) {
        this.terminusNewMo = terminusNewMo;
    }

    public String getTerminusEn() {
        return terminusEn;
    }

    public void setTerminusEn(String terminusEn) {
        this.terminusEn = terminusEn;
    }

    public String getWaitingRoomMo() {
        return waitingRoomMo;
    }

    public void setWaitingRoomMo(String waitingRoomMo) {
        this.waitingRoomMo = waitingRoomMo;
    }

    public String getWaitingRoomNewMo() {
        return waitingRoomNewMo;
    }

    public void setWaitingRoomNewMo(String waitingRoomNewMo) {
        this.waitingRoomNewMo = waitingRoomNewMo;
    }

    public String getWaitingRoomEn() {
        return waitingRoomEn;
    }

    public void setWaitingRoomEn(String waitingRoomEn) {
        this.waitingRoomEn = waitingRoomEn;
    }

    public String getTrainStationNameMo() {
        return trainStationNameMo;
    }

    public void setTrainStationNameMo(String trainStationNameMo) {
        this.trainStationNameMo = trainStationNameMo;
    }

    public String getTrainStationNameEn() {
        return trainStationNameEn;
    }

    public void setTrainStationNameEn(String trainStationNameEn) {
        this.trainStationNameEn = trainStationNameEn;
    }

    public String getTrainStationNameNewMo() {
        return trainStationNameNewMo;
    }

    public void setTrainStationNameNewMo(String trainStationNameNewMo) {
        this.trainStationNameNewMo = trainStationNameNewMo;
    }

    public String getWaitingRoomSaoMo() {
        return waitingRoomSaoMo;
    }

    public void setWaitingRoomSaoMo(String waitingRoomSaoMo) {
        this.waitingRoomSaoMo = waitingRoomSaoMo;
    }

    public String getWaitingRoomSaoNewMo() {
        return waitingRoomSaoNewMo;
    }

    public void setWaitingRoomSaoNewMo(String waitingRoomSaoNewMo) {
        this.waitingRoomSaoNewMo = waitingRoomSaoNewMo;
    }
}
