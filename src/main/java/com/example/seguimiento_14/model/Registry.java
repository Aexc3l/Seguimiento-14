package com.example.seguimiento_14.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Registry {

    public double amount;
    public String description;
    public Type typeC;
    public Calendar date;

    public Registry(double amount, String description, Type typeC, String date) {
        this.amount = amount;
        this.description = description;
        this.typeC = typeC;
        this.date = convertStringtoCalendar(date);
    }

    public Calendar convertStringtoCalendar(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(date));
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getTypeC() {
        return typeC;
    }

    public void setTypeC(Type typeC) {
        this.typeC = typeC;
    }

    public String getDate() {
        return String.valueOf(date.getTime());
    }

    public Calendar getDates(){
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", typeC=" + typeC +
                ", date=" + date.getTime() +
                '}';
    }
}
