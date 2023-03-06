
import java.util.Arrays;
import java.util.HashSet;

public class Cogent {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        //Q1 Search an Element in an Array
        findElement(arr,30);
        //Find the Largest Element in an Array
        findLargestElement(new int []{5, 3, 2, 9, 4,7,5,7,8,3,1});
        //Sort an Array
        sortArr(new int []{5, 3, 2, 9, 4,7,5,7,8,3,1},0,arr.length-1);
//        4WAP to Sort the Elements of an Array in Descending Order
        sortDecreasing(new int []{5, 3, 5,5, 4,7,5});
//        5WAP to Sort the Elements of an Array in Ascending Order
        sortIncreasing();
//        6WAP to Remove Duplicate Elements From an Array
        removeDuplicate(new int []{5, 3, 5,5, 4,7,5});
//        7WAP to Merge Two Arrays
        merger();
//        8WAP to Check if Two Arrays Are Equal or Not
        checkEqual();
//        9WAP to Remove All Occurrences of an Element in an Array
        removeElements(new int []{5, 3, 5,5, 4,7,5},5);
//        10WAP to Find Common Array Elements
        FindCommonElements(new int []{5, 3, 2, 9, 4,7,5},new int []{4,7,5,7,8,3,1});
//        11WAP to Copy All the Elements of One Array to Another Array
        copyArray();
//        12WAP For Array Rotation








    }




    public static int findElement(int [] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target) return i;
        }
        return -1;
    }

    public static int findLargestElement(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }


    public static void sortArr(int[] arr, int l, int r) {
        if (l>=r) return;
        int i=l-1;
        int j=r+1;

        int x=arr[l];
        while(i<j){
            i+=1;
            while (arr[i]<x) i+=1;
            j-=1;
            while (arr[j]>x) j-=1;
            if (i<j){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        sortArr(arr,l,j);
        sortArr(arr,j+1,r);
    }

    public static void sortDecreasing(int[] args) {
        int[] arr = {2, 6, 23, 98, 24, 35, 78};
        for (int i = 0; i < arr.length / 2; ++i) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println("Sorted array in descending order: " + Arrays.toString(arr));
    }

    public static void sortIncreasing() {
        int[] arr = {2, 6, 23, 98, 24, 35, 78};
        Arrays.sort(arr);
        System.out.println("Sorted array in descending order: " + Arrays.toString(arr));
    }

    public static void removeDuplicate(int[] args) {
        int[] arr = {2, 6, 23, 98, 24, 35, 78};

        HashSet<Integer> sets=new HashSet<>();

        for (int n:arr) {
            sets.add(n);
        }
        int[] ans=new int[sets.size()];
        int index=0;
        for (int i: sets) {
            ans[index++]=i;
        }
        System.out.println("Sorted array in descending order: " + Arrays.toString(ans));

    }

    public static void merger() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] mergedArr = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            mergedArr[index] = arr1[i];
            index++;
        }
        for (int j = 0; j < arr2.length; j++) {
            mergedArr[index] = arr2[j];
            index++;
        }
        System.out.println("Merged array: " + Arrays.toString(mergedArr));
    }

    public static void checkEqual() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        boolean areEqual = true;
        if (arr1.length != arr2.length) {
            areEqual = false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    areEqual = false;
                    break;
                }
            }
        }
        if (areEqual) {
            System.out.println("Arrays are equal.");
        } else {
            System.out.println("Arrays are not equal.");
        }
    }

    public static void copyArray() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println("Original array: " + Arrays.toString(arr1));
        System.out.println("Copied array: " + Arrays.toString(arr2));
    }


    public static void FindCommonElements(int[] arr1,
                                          int[] arr2)
    {
        // create hashsets
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Adding elements from array1
        for (int i : arr1) {
            set1.add(i);
        }

        // Adding elements from array2
        for (int i : arr2) {
            set2.add(i);
        }
        // use retainAll() method to
        // find common elements
        set1.retainAll(set2);
        System.out.println("Common elements- " + set1);
    }

    public static void removeElements(int[] arr, int key)
    {
        int index = 0;
        for (int i=0; i<arr.length; i++)
            if (arr[i] != key)
                arr[index++] = arr[i];
        System.out.println("Common elements- " + Arrays.copyOf(arr, index).toString());
        // Create a copy of arr[]
    }


}
