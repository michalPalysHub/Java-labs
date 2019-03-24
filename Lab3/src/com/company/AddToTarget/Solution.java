package com.company.AddToTarget;

import java.util.Arrays;

public class Solution {
    public int[] solution(float[] arr, float target) throws NoSolutionException{
        if (arr.length == 0) throw new IllegalArgumentException("Array cannot be empty!");
        int[] res = new int[2];

        Arrays.sort(arr);

        int leftIndex = 0, rightIndex = arr.length - 1;
        while (leftIndex < rightIndex){
            if (arr[leftIndex] + arr[rightIndex] == target) {
                res[0] = leftIndex;
                res[1] = rightIndex;
                return res;
            }
            else if (arr[leftIndex] + arr[rightIndex] < target){
                leftIndex++;
            }
            else {
                rightIndex--;
            }
        }
        throw new NoSolutionException("There's no solution");
    }
}

