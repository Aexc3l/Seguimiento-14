package com.example.seguimiento_14.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistryList {

    ObservableList<Registry> registries = FXCollections.observableArrayList();

    private RegistryList(){}

    private static RegistryList instance = null;

    public static RegistryList getInstance() {
        if(instance == null){
            instance = new RegistryList();
        }
        return instance;
    }

    public boolean delete(String date, double quantity, String description) {
        Calendar date1 = convertStringtoCalendar(date);
        for (int i = 0; i < registries.size(); i++){
            if(date1.getTime().compareTo(registries.get(i).getDates().getTime()) == 0){
                if(quantity == registries.get(i).getAmount()){
                    if(description.equalsIgnoreCase(registries.get(i).getDescription())){
                        registries.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ObservableList<Registry> getRegistries() {
        return registries;
    }

    public ObservableList<Registry> getIncomes() {
        ObservableList<Registry> incomes = FXCollections.observableArrayList();
        for (int i = 0; i < registries.size(); i++){
            if (registries.get(i).getTypeC().equals(Type.INCOME)){
                incomes.add(registries.get(i));
            }
        }
        return incomes;
    }
    public ObservableList<Registry> getCost() {
        ObservableList<Registry> costs = FXCollections.observableArrayList();
        for (int i = 0; i < registries.size(); i++){
            if (registries.get(i).getTypeC().equals(Type.COST)){
                costs.add(registries.get(i));
            }
        }
        return costs;
    }

    public String getBalance(){
        double counter1 = 0;
        double counter2 = 0;
        for (int i = 0; i < registries.size(); i++){
            if (registries.get(i).getTypeC().equals(Type.INCOME)){
                counter1 += registries.get(i).getAmount();
            }else {
                counter2 += registries.get(i).getAmount();
            }
        }
        String balance = String.valueOf(counter1-counter2);
        return balance;
    }

    private Calendar convertStringtoCalendar(String date) {
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
}
