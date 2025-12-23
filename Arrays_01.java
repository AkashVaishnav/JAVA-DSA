public class Arrays_01 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,8};

        // 1 -> Remove Duplicates - for sorted array
        // int newLength = removeDuplicate(arr);
        // for(int i=0; i<newLength; i++){
        //     System.out.print(arr[i] + " ");
        // }

        // 2 -> Remove Duplicates - for unsorted array
        // removeDuplicateFromUnsortedArray(arr);

        // 3 -> Check if Array is Palindrome
        // System.out.println("Palindrome status: " + isPalindrome(arr));

        // 4 -> second smallest element
        // System.out.println("Second smallest element: " + secondSmallest(arr));

        // 5 -> third smallest element
        // System.out.println("Third smallest element: " + thirdSmallest(arr));
        
        // 6 -> 
        System.out.println("Third largest element: " + thirdLargest(arr));
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
}