package com.imudges.web.railwaystationservice.controller;

import com.imudges.web.railwaystationservice.bean.PageBean;
import com.imudges.web.railwaystationservice.entity.Msg;
import com.imudges.web.railwaystationservice.entity.Question;
import com.imudges.web.railwaystationservice.entity.TrainInfo;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CheckSession;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yangy on 2018/2/11.
 */
@IocBean
@Filters(@By(type=CheckSession.class, args={"user", "/admin/login.html"}))
public class AdminTrainInfoModule {
    @Inject
    Dao dao;

    @At("admin/trainInfoQuery")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object TrainInfoQuery(HttpServletRequest request, @Param("keyword") String keyword, @Param("pc") int pc) {
        if (pc == 0)
            pc = 1;
        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "";
        }

        PageBean<TrainInfo> pageBean = getTrainInfoList(keyword, pc, 10);
        request.setAttribute("pb", pageBean);
        request.setAttribute("keyword", keyword);
        return "jsp:admin/trainInfo";
    }

    @At("admin/trainInfoDelete")
    @Ok("re")
    @Fail("http:500")
    @GET
    public Object trainInfoDelete(HttpServletRequest request, @Param("id") Integer id) {
        Msg msg = new Msg();
        request.setAttribute("msg", msg);
        if (id == null) {
            return msg;
        }
        try {
            dao.delete(Question.class, id);
            msg.setMsg("删除成功！");
            msg.setState(1);
            msg.setUrl("trainInfoQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("删除失败！");
        return "jsp:admin/msg";

    }

    @At("admin/trainInfoUpdate")
    @Ok("re")
    @Fail("http:500")
    @POST
    public Object trainInfoUpdate(HttpServletRequest request, @Param("id") Integer id,
                                  @Param("trainNumber") String trainNumber,
                                  @Param("startStation") String startStation,
                                  @Param("startStationMo") String startStationMo,
                                  @Param("startStationNewMo") String startStationNewMo,
                                  @Param("startStationEn") String startStationEn,
                                  @Param("terminus") String terminus,
                                  @Param("terminusMo") String terminusMo,
                                  @Param("terminusNewMo") String terminusNewMo,
                                  @Param("terminusEn") String terminusEn,
                                  @Param("daoDian") String daoDian,
                                  @Param("kaiDian") String kaiDian,
                                  @Param("station") String station,
                                  @Param("jianPiaoKou") String jianPiaoKou,
                                  @Param("trainStationName") String trainStationName,
                                  @Param("trainStationNameMo") String trainStationNameMo,
                                  @Param("trainStationNameEn") String trainStationNameEn,
                                  @Param("trainStationNameNewMo") String trainStationNameNewMo,
                                  @Param("trainType") String trainType,
                                  @Param("waitingRoom") String waitingRoom,
                                  @Param("waitingRoomSaoMo") String waitingRoomSaoMo,
                                  @Param("waitingRoomSaoNewMo") String waitingRoomSaoNewMo,
                                  @Param("waitingRoomMo") String waitingRoomMo,
                                  @Param("waitingRoomNewMo") String waitingRoomNewMo,
                                  @Param("waitingRoomEn") String waitingRoomEn
    ) {
        Msg msg = new Msg();
        request.setAttribute("msg", msg);
        if (id == null || trainNumber == null || "".equals(trainNumber)
                || startStation == null || "".equals(startStation)
                || startStationMo == null || "".equals(startStationMo)
                || startStationNewMo == null || "".equals(startStationNewMo)
                || startStationEn == null || "".equals(startStationEn)
                || terminus == null || "".equals(terminus)
                || terminusMo == null || "".equals(terminusMo)
                || terminusNewMo == null || "".equals(terminusNewMo)
                || terminusEn == null || "".equals(terminusEn)
                || daoDian == null || "".equals(daoDian)
                || kaiDian == null || "".equals(kaiDian)
                || station == null || "".equals(station)
                || jianPiaoKou == null || "".equals(jianPiaoKou)
                || trainStationName == null || "".equals(trainStationName)
                || trainStationNameMo == null || "".equals(trainStationNameMo)
                || trainStationNameEn == null || "".equals(trainStationNameEn)
                || trainStationNameNewMo == null || "".equals(trainStationNameNewMo)
                || trainType == null || "".equals(trainType)
                || waitingRoom == null || "".equals(waitingRoom)
                || waitingRoomSaoMo == null || "".equals(waitingRoomSaoMo)
                || waitingRoomSaoNewMo == null || "".equals(waitingRoomSaoNewMo)
                || waitingRoomMo == null || "".equals(waitingRoomMo)
                || waitingRoomNewMo == null || "".equals(waitingRoomNewMo)
                || waitingRoomEn == null || "".equals(waitingRoomEn)
                ) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        TrainInfo trainInfo = dao.fetch(TrainInfo.class, id);
        if (trainInfo == null) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        TrainInfo trainInfo1 = new TrainInfo(id, trainNumber, startStation, startStationMo, startStationNewMo, startStationEn, terminus, terminusMo, terminusNewMo, terminusEn, daoDian, kaiDian,
                station, jianPiaoKou, trainStationName, trainStationNameMo, trainStationNameEn, trainStationNameNewMo, trainType, waitingRoom, waitingRoomSaoMo, waitingRoomSaoNewMo,
                waitingRoomMo, waitingRoomNewMo, waitingRoomEn);
        try {
            dao.update(trainInfo1);
            msg.setMsg("更新成功！");
            msg.setState(1);
            msg.setUrl("trainInfoQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("更新失败！");
        return "jsp:admin/msg";

    }

    @At("admin/trainInfoAdd")
    @Ok("re")
    @Fail("http:500")
    @POST
    public Object trainInfoAdd(HttpServletRequest request,
                                  @Param("trainNumber") String trainNumber,
                                  @Param("startStation") String startStation,
                                  @Param("startStationMo") String startStationMo,
                                  @Param("startStationNewMo") String startStationNewMo,
                                  @Param("startStationEn") String startStationEn,
                                  @Param("terminus") String terminus,
                                  @Param("terminusMo") String terminusMo,
                                  @Param("terminusNewMo") String terminusNewMo,
                                  @Param("terminusEn") String terminusEn,
                                  @Param("daoDian") String daoDian,
                                  @Param("kaiDian") String kaiDian,
                                  @Param("station") String station,
                                  @Param("jianPiaoKou") String jianPiaoKou,
                                  @Param("trainStationName") String trainStationName,
                                  @Param("trainStationNameMo") String trainStationNameMo,
                                  @Param("trainStationNameEn") String trainStationNameEn,
                                  @Param("trainStationNameNewMo") String trainStationNameNewMo,
                                  @Param("trainType") String trainType,
                                  @Param("waitingRoom") String waitingRoom,
                                  @Param("waitingRoomSaoMo") String waitingRoomSaoMo,
                                  @Param("waitingRoomSaoNewMo") String waitingRoomSaoNewMo,
                                  @Param("waitingRoomMo") String waitingRoomMo,
                                  @Param("waitingRoomNewMo") String waitingRoomNewMo,
                                  @Param("waitingRoomEn") String waitingRoomEn
    ) {
        Msg msg = new Msg();
        request.setAttribute("msg", msg);
        if ( trainNumber == null || "".equals(trainNumber)
                || startStation == null || "".equals(startStation)
                || startStationMo == null || "".equals(startStationMo)
                || startStationNewMo == null || "".equals(startStationNewMo)
                || startStationEn == null || "".equals(startStationEn)
                || terminus == null || "".equals(terminus)
                || terminusMo == null || "".equals(terminusMo)
                || terminusNewMo == null || "".equals(terminusNewMo)
                || terminusEn == null || "".equals(terminusEn)
                || daoDian == null || "".equals(daoDian)
                || kaiDian == null || "".equals(kaiDian)
                || station == null || "".equals(station)
                || jianPiaoKou == null || "".equals(jianPiaoKou)
                || trainStationName == null || "".equals(trainStationName)
                || trainStationNameMo == null || "".equals(trainStationNameMo)
                || trainStationNameEn == null || "".equals(trainStationNameEn)
                || trainStationNameNewMo == null || "".equals(trainStationNameNewMo)
                || trainType == null || "".equals(trainType)
                || waitingRoom == null || "".equals(waitingRoom)
                || waitingRoomSaoMo == null || "".equals(waitingRoomSaoMo)
                || waitingRoomSaoNewMo == null || "".equals(waitingRoomSaoNewMo)
                || waitingRoomMo == null || "".equals(waitingRoomMo)
                || waitingRoomNewMo == null || "".equals(waitingRoomNewMo)
                || waitingRoomEn == null || "".equals(waitingRoomEn)
                ) {
            msg.setMsg("参数错误！");
            return "jsp:admin/msg";
        }
        TrainInfo trainInfo1 = new TrainInfo(trainNumber, startStation, startStationMo, startStationNewMo, startStationEn, terminus, terminusMo, terminusNewMo, terminusEn, daoDian, kaiDian,
                station, jianPiaoKou, trainStationName, trainStationNameMo, trainStationNameEn, trainStationNameNewMo, trainType, waitingRoom, waitingRoomSaoMo, waitingRoomSaoNewMo,
                waitingRoomMo, waitingRoomNewMo, waitingRoomEn);

        try {
            dao.insert(trainInfo1);
            msg.setMsg("添加成功！");
            msg.setState(1);
            msg.setUrl("trainInfoQuery.php");
            return "jsp:admin/msg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setMsg("添加失败！");
        return "jsp:admin/msg";

    }

    public PageBean<TrainInfo> getTrainInfoList(String keyword, int pc, int pageSize) {
        Pager pager = dao.createPager(pc, pageSize);
        List<TrainInfo> list = dao.query(TrainInfo.class, Cnd.where("trainNumber", "like", "%" + keyword + "%")
                .or("startStation", "like", "%" + keyword + "%").or("terminus", "like", "%" + keyword + "%"), pager);
        PageBean<TrainInfo> pageBean = new PageBean<>();
        pageBean.setBeanList(list);
        pageBean.setPc(pc);
        pageBean.setPs(pageSize);
        pageBean.setTr(dao.count(TrainInfo.class, Cnd.where("trainNumber", "like", "%" + keyword + "%")
                .or("startStation", "like", "%" + keyword + "%").or("terminus", "like", "%" + keyword + "%")));
        return pageBean;
    }
}
