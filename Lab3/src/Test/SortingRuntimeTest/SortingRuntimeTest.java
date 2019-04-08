package Test.SortingRuntimeTest;

import com.company.SortingRuntime.SortingRuntime;
import org.junit.Assert;
import org.junit.Test;

public class SortingRuntimeTest {
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_If_WrongAlgorithmsNamePassed(){
        SortingRuntime sr = new SortingRuntime();
        int[] arr = sr.makeArr(20000, 1000);

        sr.sortingRuntime(arr, "wrong name");
    }


    // Testing whether given sorting algorithm actually works ////////////

    @Test
    public void Test_If_ArrIsSorted_BubbleSort(){
        boolean isSorted = true;
        int[] arr = new SortingRuntime().makeArr(101,100);

        new SortingRuntime().sortingRuntime(arr, "bubbleSort");

        for (int i = 0; i < 100; i++){
            if (arr[i] > arr[i+1]) isSorted = false;
        }

        Assert.assertEquals(true, isSorted);
    }

    @Test
    public void Test_If_ArrIsSorted_SelectionSort(){
        boolean isSorted = true;
        int[] arr = new SortingRuntime().makeArr(101,100);

        new SortingRuntime().sortingRuntime(arr, "selectionSort");

        for (int i = 0; i < 100; i++){
            if (arr[i] > arr[i+1]) isSorted = false;
        }

        Assert.assertEquals(true, isSorted);
    }

    @Test
    public void Test_If_ArrIsSorted_InsertionSort(){
        boolean isSorted = true;
        int[] arr = new SortingRuntime().makeArr(101,100);

        new SortingRuntime().sortingRuntime(arr, "insertionSort");

        for (int i = 0; i < 100; i++){
            if (arr[i] > arr[i+1]) isSorted = false;
        }

        Assert.assertEquals(true, isSorted);
    }

    @Test
    public void Test_If_ArrIsSorted_MergeSort(){
        boolean isSorted = true;
        int[] arr = new SortingRuntime().makeArr(101,100);

        new SortingRuntime().sortingRuntime(arr, "mergeSort");

        for (int i = 0; i < 100; i++){
            if (arr[i] > arr[i+1]) isSorted = false;
        }

        Assert.assertEquals(true, isSorted);
    }

    @Test
    public void Test_If_ArrIsSorted_HeapSort() {
        boolean isSorted = true;
        int[] arr = new SortingRuntime().makeArr(101,100);

        new SortingRuntime().sortingRuntime(arr, "heapSort");

        for (int i = 0; i < 100; i++){
            if (arr[i] > arr[i+1]) isSorted = false;
        }

        Assert.assertEquals(true, isSorted);
    }

    // Testing sorting timeout ///////////////////////////////////

    @Test(timeout = 100)
    public void testBubbleSortTimeout(){
        int[] arr = new SortingRuntime().makeArr(10000,100);
        new SortingRuntime().sortingRuntime(arr, "bubbleSort");
    }

    @Test(timeout = 100)
    public void testSelectionSortTimeout(){
        int[] arr = new SortingRuntime().makeArr(10000,100);
        new SortingRuntime().sortingRuntime(arr, "selectionSort");
    }

    @Test(timeout = 100)
    public void testInsertionSortTimeout(){
        int[] arr = new SortingRuntime().makeArr(10000,100);
        new SortingRuntime().sortingRuntime(arr, "insertionSort");
    }

    @Test(timeout = 100)
    public void testMergeSortTimeout(){
        int[] arr = new SortingRuntime().makeArr(10000,100);
        new SortingRuntime().sortingRuntime(arr, "mergeSort");
    }

    @Test(timeout = 100)
    public void testHeapSortTimeout(){
        int[] arr = new SortingRuntime().makeArr(10000,100);
        new SortingRuntime().sortingRuntime(arr, "heapSort");
    }
}
