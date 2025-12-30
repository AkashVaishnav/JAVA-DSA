public class Strings {
    public static void main(String[] args) {
        String str = "akash";

        // 1 -> Reverse a String 
        // System.out.println(reverseString(str));

        // 2 -> Check if String is Palindrome
        // System.out.println(checkPalindrome(str));
        // System.out.println(isPalindrome(str));

        // Count vowels & consonants
        // countVowAndConsonants(str);

        //Remove spaces from a string
        // System.out.println(removeSpacrs(str));

        // Find length of string WITHOUT using .length()
        // System.out.println(findLength(str));

        // Find first non-repeating character
        // System.out.println(firstNonRepeatingChar(str));

        // Check string is anagram or not
        // System.out.println(checkAnagram("race", "care"));

        // Count frequency of each character
        // countFrequency(str);

        System.out.println(longestWord("Akash is learning Java"));
    }   

    // Reverse a String 
    public static String reverseString(String str){
        char[] chars = str.toCharArray();

        int start = 0, end = chars.length-1;

        while(end > start){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    // Check if String is Palindrome
    public static boolean checkPalindrome(String str){
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static boolean isPalindrome(String str){
        str = str.toLowerCase();
        int start=0, end = str.length()-1;

        while(end > start){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Count vowels & consonants
    public static void countVowAndConsonants(String str){
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowels++;
                } else{
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // Remove spaces from a string
    public static String removeSpacrs(String str){
        return str.replace(" ", "");
    }

    // Find length of string WITHOUT using .length()
    public static int findLength(String str){
        int count = 0;

        for(char c : str.toCharArray()){
            count++;
        }
        return count;
    }

    // Find first non-repeating character
    public static char firstNonRepeatingChar(String str){
        int[] freq = new int[256];

        for(int i=0; i<str.length(); i++){
            freq[str.charAt(i)]++;
        }

        for(int i=0; i<str.length(); i++){
            if(freq[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '\0';
    }

    // Check string is anagram or not
    public static boolean checkAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int[] freq = new int[256];

        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)]++;
        }
        
        for(int i=0; i<s2.length(); i++){
            freq[s2.charAt(i)]--;
            if(freq[s2.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }

    // Count frequency of each character
    public static void countFrequency(String str){
        int[] freq = new int[256];

        for(int i=0; i<str.length(); i++){
            freq[str.charAt(i)]++;
        }

        for(int i=0; i<256; i++){
            if(freq[i] > 0){
                System.out.println((char)i + " = " + freq[i]);
            }
        }
    }

    // Longest word in a sentence
    public static String longestWord(String sentence){
        String[] words = sentence.split(" ");
        String longest = "";

        for(String word: words){
            if(word.length() > longest.length()){
                longest = word;
            }
        }
        return longest;
    }

    // Remove duplicate characters
    public static String removeDuplicate(String str){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(sb.indexOf(String.valueOf(c)) == -1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
