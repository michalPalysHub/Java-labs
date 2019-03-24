package com.company;

public class Item implements Comparable<Item>{

    public enum ItemCondition {
        NEW,
        USED,
        REFURBISHED
    }

    private String name;
    private ItemCondition condition;
    private double weight;
    private int quantity;

    public Item(String n, ItemCondition c, double w, int q) {
        this.name = n;
        this.condition = c;
        if (w <= 0) throw new IllegalArgumentException("Weight cannot be negative or equal 0!");
        this.weight = w;
        if (q <=0) throw new IllegalArgumentException("Quantity must be bigger than 0!");
        this.quantity = q;
    }

    public void print(){
        System.out.println("\nA name of the item: " + this.name);
        System.out.println("Item's condition: " + this.condition);
        System.out.println("Item's weight: " + this.weight);
        System.out.println("Item's quantity: " + this.quantity);
    }

    @Override
    public int compareTo(Item o){
        int nameComparison = this.name.compareTo(o.name);
        return nameComparison;
    }

    public String getName(){
        return this.name;
    }

    public ItemCondition getCondition(){
        return this.condition;
    }

    public double getWeight(){
        return this.weight;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void increaseQuantity(int quantity){
        this.quantity += quantity;
    }

    public void decreaseQuantity(){
        this.quantity--;
    }
}