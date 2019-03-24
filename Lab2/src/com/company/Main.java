package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //I create a new store
        Item item1 = new Item("iphone", Item.ItemCondition.NEW, 0.1, 1);
        Item item2 = new Item("samsung", Item.ItemCondition.USED, 0.1, 4);
        Item item3 = new Item("iphone", Item.ItemCondition.USED, 0.1, 1);
        Item item4 = new Item("xiaomi", Item.ItemCondition.REFURBISHED, 0.1, 5);
        Item item5 = new Item("sony", Item.ItemCondition.NEW, 0.15, 9);
        Item item6 = new Item("nokia", Item.ItemCondition.NEW, 0.89, 3);
        List<Item> smartphones = new ArrayList<Item>();
        FulfillmentCenter store = new FulfillmentCenter("smartphones", smartphones, 100);
        store.addProduct(item1);
        store.addProduct(item2);
        store.addProduct(item3);
        store.addProduct(item4);
        store.addProduct(item5);
        store.addProduct(item6);

        //countByCondition():
        System.out.println("The number of the used smartphones in the store: " + store.countByCondition(Item.ItemCondition.USED));

        //search():
        System.out.println("\nsearch():");
        store.search("samsung").print();

        //searchPartial():
        String phrase = "iph";
        System.out.println("\nThe numer of items containing the phrase \"" + phrase + "\" in their name : " + store.searchPartial(phrase).size());

        //summary():
        store.summary();

        //sortByName()/sortByAmount():
        /*
        System.out.println("\nsortByName():");
        store.sortByName();
        */
        System.out.println("\nsortByAmount()");
        store.sortByAmount();
        store.summary();

        //max()
        System.out.println("\nmax():");
        store.max().print();

        /////////////////////////////////////
        //I create a new fulfillment center//
        FulfillmentCenterContainer center = new FulfillmentCenterContainer();

        center.summary();

        System.out.println("\nAfter addCenter():");
        center.addCenter("cars", 1000);
        center.summary();

        System.out.println("\nAfter removeCenter():");
        center.removeCenter("cars");
        center.summary();
    }
}