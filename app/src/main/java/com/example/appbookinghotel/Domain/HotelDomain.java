package com.example.appbookinghotel.Domain;

import java.io.Serializable;

public class HotelDomain implements Serializable {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberincart() {
        return numberincart;
    }

    public void setNumberincart(int numberincart) {
        this.numberincart = numberincart;
    }

    private String description;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    private String picUrl;
    private double price;
    private int time;
    private int energy;
    private double score;
    private int numberincart;

    public HotelDomain(String title, String description, String picUrl, double price, int time, int energy, double score, int numberincart) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.price = price;
        this.time = time;
        this.energy = energy;
        this.score = score;
        this.numberincart = numberincart;
    }


}
