package com.example.orderservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Timer;

@Data
@Document("Order")
public class Order {
    @Id
    private String _id;
    //Car
//    private String type;
//    private String brand;
//    private String model;
//    private int numOfSeat;
//    private int price;
//    private int quantity;
    private String carId;

    private String timeStart;
    private String timeEnd;
    private String dateStart;
    private String dateEnd;
    private String location;
//    private Integer amountDay;
    private Integer totalPrice;
    private String status_check;
    private String user_name;
    private String user_mail;
//    private String user_tel;

    public Order(String _id, String carId) {
        this._id = _id;
        this.carId = carId;
    }


    public Order(String _id, String carId, String timeStart, String timeEnd, String dateStart, String dateEnd, String location, Integer totalPrice, String status_check, String user_name, String user_mail) {
        this._id = _id;
        this.carId = carId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.location = location;
//        this.amountDay = amountDay;
        this.totalPrice = totalPrice;
        this.status_check = status_check;
        this.user_name = user_name;
        this.user_mail = user_mail;
//        this.user_tel = user_tel;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String isStatus() {
        return status_check;
    }

    public void setStatus(String status) {
        this.status_check = status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

//    public String getUser_tel() {
//        return user_tel;
//    }
//
//    public void setUser_tel(String user_tel) {
//        this.user_tel = user_tel;
//    }
}
