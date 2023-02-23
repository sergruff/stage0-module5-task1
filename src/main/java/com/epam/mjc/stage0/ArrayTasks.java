package com.epam.mjc.stage0;



/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter","spring","summer","autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i+1;
        }
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum=0;
        for (int i: arr) {
            sum+=i;
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==number){
                result=i;
                break;
            }
        }
        return result;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] array = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[arr.length-i-1] = arr[i];
        }
        return array;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int count = 0;
        for (int i: arr
             ) {
            if (i>0) {
                count++;
            }
        }
        int[] array = new int[count];
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0) {
                array[count++] = arr[i];
            }
        }
           return array;
        }


    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */

    // It is not clear what to do this one one-dimensional arrays that have equal length
    public int[][] sortRaggedArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("[%d]",arr[i][j]);
            }
            System.out.println(" length = " + arr[i].length);
        }
        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            int[] minLength = arr[i];
            int[] temp=arr[i];
            int minLengthIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].length<minLength.length) {
                    if (arr[j].length==minLength.length) {
                        int firstMin = arr[j][0];
                        for (int n:arr[j]) {
                            if(n<firstMin){
                                firstMin=n;
                            }
                        }
                        int secondMin = arr[minLengthIndex][0];
                        for (int n:arr[minLengthIndex]) {
                            if(n<secondMin){
                                secondMin=n;
                            }
                        }
                        if (firstMin>secondMin){
                            minLength = arr[j];
                            minLengthIndex = j;
                        }
                        System.out.printf("firstMin=%d, secondMin = %d\n",firstMin,secondMin);
                        continue;
                    }
                    minLength = arr[j];
                    minLengthIndex = j;
                }
            }
            arr[i] = minLength;
            arr[minLengthIndex] = temp;
        }
        int[][] resultArray = arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int maxElement = arr[i][j];
                int temp = arr[i][j];
                int tempElement = j;
                for (int k = j; k < arr[i].length; k++) {
                    if (arr[i][k]>maxElement){
                        maxElement=arr[i][k];
                    }
                }
                arr[i][j]=maxElement;
                arr[i][tempElement] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("[%d]",arr[i][j]);
            }
            System.out.println(" length = " + arr[i].length);
        }
        System.out.println("");
        return arr;
    }
}
