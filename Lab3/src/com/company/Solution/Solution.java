package com.company.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public int solution(List<Integer> list) throws SizeOutOfRangeException, ElementOutOfRangeException{
        if (list.isEmpty()) throw new IllegalArgumentException("The list cannot be empty!");
        if (list.size() > 100000) throw new SizeOutOfRangeException("The list's size must be lesser than 100000");
        list.sort(Integer::compareTo);
        int solution = 0;

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) < -1000000 || list.get(i) > 1000000) throw new ElementOutOfRangeException("Element out of range!");
            if (list.get(i) == solution + 1){
                solution++;
            }
        }
        return solution + 1;
    }

    public List<Integer> createRandomArrayList(int minValue, int maxValue, int sizeOfTheList){
        if (sizeOfTheList <= 0) throw new IllegalArgumentException("Size of the list must be positive!");
        List<Integer> list = new ArrayList<>();

        System.out.println("The new ArrayList: ");
        for (int i = 0; i <= sizeOfTheList; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
            System.out.print(randomNum + " ");
            list.add(randomNum);
        }
        System.out.println();
        return list;
    }
}
