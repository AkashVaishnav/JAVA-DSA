import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arrays_01 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        // 1 -> Remove Duplicates - for sorted array
        // int newLength = removeDuplicate(arr);
        // for(int i=0; i<newLength; i++){
        //     System.out.print(arr[i] + " ");
        // }

        // 2 -> Remove Duplicates - for unsorted array
        // removeDuplicateFromUnsortedArray(arr);

        // 3 -> Check if Array is Palindrome
        // System.out.println("Palindrome status: " + isPalindrome(arr));

        // 4 -> Second smallest element
        // System.out.println("Second smallest element: " + secondSmallest(arr));

        // 5 -> Third smallest element
        // System.out.println("Third smallest element: " + thirdSmallest(arr));
        
        // 6 -> Third largest element
        // System.out.println("Third largest element: " + thirdLargest(arr));
        
        // 7 -> Reverse the array
        // reverseArray(arr);

        // 8 -> check if array is sorted
        // System.out.println(checkSortOrNot(arr));

        // 9 -> Move all zeros to the end
        // moveAllZerosToEnd(arr);

        // 10 -> Find missing number
        // System.out.println(missingNumber(arr));

        // 11 -> Find repeating element
        // repeatingElement(arr);

        // 12 -> Find all pairs with given sum (Brute force)
        // findPairs(arr, 6);

        // 13 -> Leaders in an Array
        // int[] pArr = {16, 17, 4, 3, 5, 2};
        // printLeaders(pArr);

        // 14 -> Find the maximum possible difference
        // System.out.println(maxDifference(arr));

        // 15 -> Longest Increasing Subarray (Continuous)
        // System.out.println(longestIncreasingSubarray(arr));

        // Equilibrium Index
        // System.out.println("Equilibrium Index: " + equilibriumIndex(arr));
        
        // Rearrange Array Alternately (Max, Min, Max, Min)
        // rearrangeAlternate(arr);
        
        // Find Majority Element (> n/2 times) (Moore’s Voting)
        // System.out.println("Majority element is: " + majorityElement(arr));

        // Product of Array Except Self
        // System.out.println("Product array is: " + Arrays.toString(productExceptSelf(arr)));
    }

    // Remove Duplicates - for sorted array
    public static int removeDuplicate(int arr[]){
        int n = arr.length;
        int j = 0;

        for(int i=1; i<n; i++){
            if(arr[i] != arr[j]){
                j++; // 1
                arr[j] = arr[i];
            }
        }
        return j+1;
    }

    // Remove Duplicates - for unsorted array
    public static void removeDuplicateFromUnsortedArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            boolean isDuplicate = false;

            for(int j=0; j<i; j++){
                if(arr[i] == arr[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                System.out.print(arr[i] + " ");
            }
        }
    }

    // Check if Array is Palindrome
    public static boolean isPalindrome(int arr[]) {
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Second smallest element
    public static int secondSmallest(int arr[]){
        if(arr == null || arr.length < 2){
            return -1;
        }
        int smallest = Integer.MAX_VALUE;       // 2147483647
        int secondSmallest = Integer.MAX_VALUE; // 2147483647
 
        // {1,2,3,4,5}
        for(int i=0; i<arr.length; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] > smallest && arr[i] <secondSmallest){
                secondSmallest = arr[i];
            }
        }
        if(secondSmallest == Integer.MAX_VALUE){
            return -1;
        }
        return secondSmallest;
    }

    // Third smallest element
    public static int thirdSmallest(int[] arr){
        if(arr == null || arr.length < 3){
            return -1;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            int num = arr[i];

            if(num < first){
                third = second;
                second = first;
                first = num;
            }
            else if(num > first && num < second){
                third = second;
                second = num;
            }
            else if(num > second && num < third){
                third = num;
            }
        }
        if(third == Integer.MAX_VALUE){
            return -1; // no third smallest found
        }
        return third;
    }

    // Third largest element
    public static int thirdLargest(int arr[]) {
        if(arr == null || arr.length < 3){
            return -1;
        }

        int first = Integer.MIN_VALUE;  // 2147483647
        int second = Integer.MIN_VALUE; // 2147483647
        int third = Integer.MIN_VALUE;  // 2147483647

        for(int i=0; i<arr.length; i++){
            int num = arr[i];

            if(num > first){
                third = second;
                second = first;
                first = num;
            } else if(num < first && num > second){
                third = second;
                second = num;
            } else if(num < second && num > third){
                third = num;
            }
        }
        if(third == Integer.MIN_VALUE){
            return -1; // No max value
        }

        return third;
    }

    // Reverse the array
    public static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(end > start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // check if array is sorted
    public static boolean checkSortOrNot(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    // Move all zeros to the end
    public static void moveAllZerosToEnd(int[] arr){
        int index=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[index] = arr[i];
                index++;
            }
        }

        // set remaining positions 0
        while(arr.length > index){
            arr[index] = 0;
            index++;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // Find missing number
    public static int missingNumber(int[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("Array is empty or null. No elements to check.");
            return -1;
        }

        int n = arr.length+1;
        int actualSum = n*(n+1)/2;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        int missingElement = actualSum - sum;
        if (missingElement == 0) {
            System.out.println("No missing number found or invalid input.");
            return -1;
        }

        return missingElement;
    }

    // Find first repeating element
    public static void repeatingElement(int[] arr){
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null. No elements to check.");
            return;
        }

        if (arr.length == 1) {
            System.out.println("Array has only one element. No duplicates possible.");
            return;
        }

        boolean found = false;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    System.out.println("Found repeated element: " + arr[i]);
                    found = true;
                    break;
                }
            }
            if(!found) break;
        }
        if(!found){
            System.out.println("No repeating element found");
        }
    }

    // Find all pairs with given sum (Brute force)
    public static void findPairs(int[] arr, int sum){
        Set<String> seenPairs = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);
                    String pair = first + ", " + second;

                    if(!seenPairs.contains(pair)){
                        System.out.println("(" + first + ", " + second + ")");
                        seenPairs.add(pair);
                    }
                }
            }
        }
    }

    // Leaders in an Array
    public static void printLeaders(int[] arr){
        int n = arr.length;

        int rightMaxElement = arr[n-1];
        System.out.print(rightMaxElement + " ");

        for(int i=n-2; i>=0; i--){
            if(rightMaxElement < arr[i]){
                rightMaxElement = arr[i];
                System.out.print(rightMaxElement + " ");
            }
        }
    }

    // Find the maximum possible difference
    public static int maxDifference(int[] arr){
        // {2, 3, 10, 6, 4, 8, 1}
        int min = arr[0];
        int max = 0;

        for(int i=1; i<arr.length; i++){
            max = Math.max(max, arr[i] - min); // 1, 8, 8, 8, 8
            min = Math.min(min, arr[i]);       // 2, 2, 2, 2, 2
        }
        return max;
    }

    // Longest Increasing Subarray (Continuous)
    public static int longestIncreasingSubarray(int[] arr){
        // {1, 2, 2, 3, 6, 1}
        if(arr == null || arr.length == 0){
            return -1;
        }

        int maxLen = 1;
        int currLen = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else{
                currLen=1;
            }
        }
        return maxLen;
    }

    // Equilibrium Index
    public static int equilibriumIndex(int[] arr) {
        // {1, 3, 5, 2, 2}
        if(arr == null || arr.length<1){
            System.out.println("No Equilibrium Index found");
            return -1;
        }

        int sum = 0;
        for(int num:arr){
            sum += num;
        }

        int leftSum = 0;
        for(int i=0; i<arr.length; i++){
            sum -= arr[i];
            if(leftSum == sum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    // Rearrange Array Alternately (Max, Min, Max, Min)
    public static void rearrangeAlternate(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];

        int start = 0;
        int end = n - 1;
        int index = 0;

        while(end >= start){
            if(start != end){
                temp[index++] = arr[end--];
                temp[index++] = arr[start++];
            } else{
                temp[index++] = arr[start++];
            }
        }
        for(int i=0; i<n; i++){
            arr[i] = temp[i];
            System.out.print(arr[i] + " ");
        }
    }

    // Find Majority Element (> n/2 times) (Moore’s Voting)
    public static int majorityElement(int[] arr) {
        // {2,2,1,1,2,2,2}
        int count = 0;
        int candidate = 0;

        for(int num:arr){
            if(count == 0){
                candidate = num; // 2
            }

            if(num == candidate){
                count++; // 1
            } else{
                count--;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > arr.length / 2) ? candidate : -1;
    }

    // Product of Array Except Self
    public static int[] productExceptSelf(int[] arr) {
        // {1, 2, 3, 4}
        int n = arr.length;
        int[] result = new int[n];

        result[0] = 1;
        for(int i=1; i<n; i++){
            result[i] = result[i-1] * arr[i-1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= arr[i];
        }

        return result;
    }

    // public static int trapRainWater(int[] arr) {
        
    // }
}