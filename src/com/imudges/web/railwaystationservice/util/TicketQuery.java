package com.imudges.web.railwaystationservice.util;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Random;

/**
 * Created by yangy on 2018/1/14.
 */
public class TicketQuery {
    private static String BASE_URL = "https://secure.tlbl.winsion.net/mobile-api/q/ticketCodeAPI/decodeCode?code=";
    private static String [] appKeys={
            "XXX",
            "XXX",
            "XXX"};
    private static Gson gson=new Gson();
    private static Random random=new Random();
    private  OkHttpClient client=(new OkHttpClient.Builder()).build();
    public  TicketData doAction(String code){
        if(code!=null&&!code.trim().equals("")){
            Request request=(new Request.Builder()).url(BASE_URL+code+"&appKey="+appKeys[random.nextInt(3)]).build();
            Call call=this.client.newCall(request);
            Response response;
            try {
                response=call.execute();
                String body=response.body().string();
                TicketQueryInfo ticketQueryInfo=gson.fromJson(body,TicketQueryInfo.class);
                if(ticketQueryInfo.isSuccess()){
                    return ticketQueryInfo.getData();
                }
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
        return null;
    }
    public static class TicketData {
        private String trainNumber;
        private String departStation;
        private String arriveStation;
        private String dateString;
        private String carriage;
        private String price;
        private String seatType;
        private String ticketType;
        private String ticketNumber;

        public String getTrainNumber() {
            return trainNumber;
        }

        public void setTrainNumber(String trainNumber) {
            this.trainNumber = trainNumber;
        }

        public String getDepartStation() {
            return departStation;
        }

        public void setDepartStation(String departStation) {
            this.departStation = departStation;
        }

        public String getArriveStation() {
            return arriveStation;
        }

        public void setArriveStation(String arriveStation) {
            this.arriveStation = arriveStation;
        }

        public String getDateString() {
            return dateString;
        }

        public void setDateString(String dateString) {
            this.dateString = dateString;
        }

        public String getCarriage() {
            return carriage;
        }

        public void setCarriage(String carriage) {
            this.carriage = carriage;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSeatType() {
            return seatType;
        }

        public void setSeatType(String seatType) {
            this.seatType = seatType;
        }

        public String getTicketType() {
            return ticketType;
        }

        public void setTicketType(String ticketType) {
            this.ticketType = ticketType;
        }

        public String getTicketNumber() {
            return ticketNumber;
        }

        public void setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
        }
    }

    public static class TicketQueryInfo {
        private boolean success;
        private TicketData data;
        private Integer code;
        private String message;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public TicketData getData() {
            return data;
        }

        public void setData(TicketData data) {
            this.data = data;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static void main(String[] args) {
        TicketData ticketData=new TicketQuery().doAction("250691600433186614567835322770039577990676937913978267171060222151891436308247469943608587852425073467332048323133284530777339065135525585508801");
        System.out.println(ticketData.getArriveStation());
    }
}
