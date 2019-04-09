package com.company;

import com.company.AddToTarget.NoSolutionException;
import com.company.Solution.ElementOutOfRangeException;
import com.company.Solution.SizeOutOfRangeException;
import com.company.Solution.Solution;
import com.company.SortingRuntime.SortingRuntime;
import com.company.Substring.DifferentLettersException;
import com.company.Substring.Substring;

import java.util.List;
import java.util.Random;


public class Run {

    public Run(){
        runSolution();
        runSubstring();
        runAddToTarget();
        runSortingRuntime();
    }

    public static void runSolution(){
        // set sizeOfTheList, min and max values
        int min = -10;
        int max = 10;
        int sizeOfTheList = 10;
        try {
            List<Integer> list = new Solution().createRandomArrayList(min, max, sizeOfTheList);
            System.out.println("Solution: " + new Solution().solution(list));
        }
        catch (IllegalArgumentException | SizeOutOfRangeException | ElementOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runSubstring(){
        String a = "la", b = "lalalala";
        try {
            System.out.println("\nSubstring: " + new Substring().substring(a, b));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (DifferentLettersException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runAddToTarget(){
        float arr[] = {1.2f,4.5f,6.3f,5.5f,7.9f,9.0f,5.0f};
        float arr2[] = new float[0];
        float target = 10.0f;

        try {
            int[] res = new com.company.AddToTarget.Solution().solution(arr, target);
            System.out.println("\nAddToTarget: " + res[0] + ", " + res[1]);
        } catch (NoSolutionException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void runSortingRuntime(){
        int arr[] = new SortingRuntime().makeArr(20000,1000);

        System.out.println("\nRealistic sorting runtime:");
        System.out.println("bubble sort: " + new SortingRuntime().sortingRuntime(arr, "bubbleSort") + "s");
        System.out.println("selection sort: " + new SortingRuntime().sortingRuntime(arr, "selectionSort")+ "s");
        System.out.println("insertion sort: " + new SortingRuntime().sortingRuntime(arr, "insertionSort")+ "s");
        System.out.println("merge sort: " + new SortingRuntime().sortingRuntime(arr, "mergeSort")+ "s");
        System.out.println("heap sort: " + new SortingRuntime().sortingRuntime(arr, "heapSort")+ "s");


        int arrPesimistic[] = new int[20000];
        for (int i = 0; i < arrPesimistic.length; i++){
            arrPesimistic[i] = arrPesimistic.length - i;
        }

        System.out.println("\nPesimistic sorting runtime:");
        System.out.println("bubble sort: " + new SortingRuntime().sortingRuntime(arrPesimistic, "bubbleSort") + "s");
        System.out.println("selection sort: " + new SortingRuntime().sortingRuntime(arrPesimistic, "selectionSort")+ "s");
        System.out.println("insertion sort: " + new SortingRuntime().sortingRuntime(arrPesimistic, "insertionSort")+ "s");
        System.out.println("merge sort: " + new SortingRuntime().sortingRuntime(arrPesimistic, "mergeSort")+ "s");
        System.out.println("heap sort: " + new SortingRuntime().sortingRuntime(arrPesimistic, "heapSort")+ "s");


        int arrOptimistic[] = new int[20000];
        for (int i = 0; i < arrOptimistic.length; i++){
            arrOptimistic[i] = i;
        }

        System.out.println("\nPesimistic sorting runtime:");
        System.out.println("bubble sort: " + new SortingRuntime().sortingRuntime(arrOptimistic, "bubbleSort") + "s");
        System.out.println("selection sort: " + new SortingRuntime().sortingRuntime(arrOptimistic, "selectionSort")+ "s");
        System.out.println("insertion sort: " + new SortingRuntime().sortingRuntime(arrOptimistic, "insertionSort")+ "s");
        System.out.println("merge sort: " + new SortingRuntime().sortingRuntime(arrOptimistic, "mergeSort")+ "s");
        System.out.println("heap sort: " + new SortingRuntime().sortingRuntime(arrOptimistic, "heapSort")+ "s");
    }
}