public class Advotics2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abbba"));
        System.out.println(isPalindrome("cabbbac"));
        System.out.println(isPalindrome("cabbc"));
    }

    private static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }
}