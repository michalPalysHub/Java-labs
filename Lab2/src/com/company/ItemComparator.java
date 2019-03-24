package com.company;
import java.util.Comparator;

public class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item i1, Item i2){
        int l1 = i1.getName().length();
        int l2 = i2.getName().length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++){
            int str1_ch = (int)i1.getName().charAt(i);
            int str2_ch = (int)i2.getName().charAt(i);

            if (str1_ch != str2_ch){
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2){
            return l1-l2;
        }
        else
        {
            return 0;
        }
    }
}