package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class FulfillmentCenter {
    private String name;
    private List<Item> products;
    private double itemsWeight;
    private final double maxItemsWeight;

    public FulfillmentCenter() {
        this.name = "---";
        this.products = new ArrayList<Item>();
        this.maxItemsWeight = 100;
        this.itemsWeight = 0;
    }

    public FulfillmentCenter(String name, List<Item> items, double maxItemsWeight) {
        this.name = name;
        this.products = items;
        this.itemsWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            itemsWeight += items.get(i).getWeight() * items.get(i).getQuantity();
        }
        this.maxItemsWeight = maxItemsWeight;
        if (this.itemsWeight > this.maxItemsWeight) {
            System.err.println("The maximum items capacity in: " + this.name + " has been exceeded!");
        }
    }

    public void addProduct(Item item) {
        if (this.itemsWeight + item.getQuantity() * item.getWeight() <= this.maxItemsWeight) {
            boolean productsListContainsItem = false;
            for (Item i : products) {
                if (i.compareTo(item) == 0) {
                    productsListContainsItem = true;
                    i.increaseQuantity(item.getQuantity());
                    this.itemsWeight += item.getQuantity() * item.getWeight();
                }
            }
            if (!productsListContainsItem) {
                products.add(item);
                this.itemsWeight += item.getQuantity() * item.getWeight();
            }
        } else {
            System.err.println("The maximum items capacity in: " + this.name + " has been exceeded!");
        }
    }

    public void getProduct(Item item) {
        boolean productsListContainsItem = false;
        int position = -1;
        for (int i = 0; i < this.products.size(); i++) {
            if (products.get(i).compareTo(item) == 0) {
                productsListContainsItem = true;
                if (products.get(i).getQuantity() > 1) {
                    this.itemsWeight -= products.get(i).getWeight();
                    products.get(i).decreaseQuantity();
                } else {
                    position = i;
                }
            }
        }
        if (productsListContainsItem && position != -1){
            this.itemsWeight -= products.get(position).getWeight();
            products.remove(position);
        }
        if (!productsListContainsItem)
        {
            System.err.println("There's no such item on stock!");
        }
    }

    public void removeProduct(Item item){
        int position = -1;
        for (int i = 0; i < this.products.size(); i++) {
            if (products.get(i).compareTo(item) == 0) {
                position = i;
            }
        }
        if (position != -1){
            this.itemsWeight -= products.get(position).getWeight()*products.get(position).getQuantity();
            products.remove(position);
        }
        else
        {
            System.err.println("There's no such item on stock!");
        }
    }

    public Item search(String str){
        for (Item i : products){
            if (i.getName().equals(str)){
                return i;
            }
        }
        System.err.println("There's no such item!");
        return null;
    }

    public List<Item> searchPartial(String str){
        List<Item> returnList = new ArrayList<Item>();
        for (Item i : products){
            if (i.getName().contains(str)){
                returnList.add(i);
            }
        }
        if (returnList.size() == 0){
            System.err.println("There are no items containing " + str + "!");
            return null;
        }
        else return returnList;
    }

    public int countByCondition(Item.ItemCondition cond){
        int counter = 0;
        for (int i = 0; i < this.products.size(); i++){
            if (products.get(i).getCondition().equals(cond)){
                counter += products.get(i).getQuantity();
            }
        }
        return counter;
    }

    public void summary(){
        System.out.println("\n############################################");
        System.out.println("Magazine's name: " + this.name);
        System.out.println("This store contains " + this.products.size() + " items: ");

        for (Item i:products){
            i.print();
        }

        System.out.println("\nCurrent weight of all the products in the store: " + this.itemsWeight);
        System.out.println("The amount of the weight remaining: " + (this.maxItemsWeight - this.itemsWeight));
        System.out.println("############################################");
    }

    public void sortByName(){
        //using my implemented version of compare() from ItemComparator class
        Collections.sort(products, new ItemComparator());
    }

    public void sortByAmount(){
        //using anonymous class
        Collections.sort(products, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2){
                return -Integer.compare(i1.getQuantity(), i2.getQuantity());
            }
        });
    }

    public Item max(){
        //using lambda expression
        Item maxItem = Collections.max(products, (i1, i2)-> {
            return Integer.compare(i1.getQuantity(), i2.getQuantity());
        });
        return maxItem;
    }

    public List<Item> getProducts(){
        return this.products;
    }
}
