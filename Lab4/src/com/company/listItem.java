package com.company;

public class listItem {
    private String name;
    private String keyWord;
    boolean hasBraces;

    public listItem(String name, String keyWord, boolean hasBraces){
        this.name = name;
        this.keyWord = keyWord;
        this.hasBraces = hasBraces;
    }

    @Override
    public String toString() {return this.name;}

    public String getName() {return this.name;}

    public String getKeyWord() {return this.keyWord;}

    public boolean hasBraces(){return this.hasBraces;}
}
