package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FulfillmentCenterContainer {
    private Map<String, FulfillmentCenter> magazines;

    public FulfillmentCenterContainer(){
        this.magazines = new HashMap<>();
    }

    public FulfillmentCenterContainer(Map<String, FulfillmentCenter> magazines){
        this.magazines = magazines;
    }

    public void addCenter(String name, double capacity){
        List<Item> list = new ArrayList<Item>();
        this.magazines.put(name, new FulfillmentCenter(name, list, capacity));
    }

    public void removeCenter(String name){
        if (magazines.containsKey(name)){
            magazines.remove(name);
        }
        else
        {
            System.err.println("There's no such magazine");
        }
    }

    public List<FulfillmentCenter> findEmpty(){
        List<FulfillmentCenter> listOfTheEmptyMagazines = new ArrayList<>();
        for (int i = 0; i<magazines.size(); i++){
            if (magazines.get(i).getProducts().size() == 0){
                listOfTheEmptyMagazines.add(magazines.get(i));
            }
        }
        return listOfTheEmptyMagazines;
    }

    public void summary(){
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("This Fulfillment Center Container contains " + this.magazines.size() + " magazines: ");

        for (FulfillmentCenter center: magazines.values()){
            center.summary();
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}