import java.util.*;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine().toLowerCase();

        String[] words = input.trim().split("\\s+");
        String noSpace = input.replace(" ", "");
        
        // Word Count
        int wordCount = words.length;

        // Character Count
        int charCount = noSpace.length();

        // Vowel Count
        int vowelCount = 0;
        for (char ch : noSpace.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                vowelCount++;
            }
        }

        // Frequency Count
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : noSpace.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Most Frequent Character
        char mostFreq = ' ';
        int maxFreq = 0;
        for (char ch : freq.keySet()) {
            if (freq.get(ch) > maxFreq) {
                maxFreq = freq.get(ch);
                mostFreq = ch;
            }
        }

        // Palindrome Check
        List<String> palindromes = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }

        // Output
        System.out.println("\n--- Text Analysis ---");
        System.out.println("Words: " + wordCount);
        System.out.println("Characters (excluding spaces): " + charCount);
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Most frequent character: '" + mostFreq + "'");
        System.out.println("Palindromes found: " + (palindromes.isEmpty() ? "None" : String.join(", ", palindromes)));
    }

    // Helper method to check if a word is palindrome
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }

    
}
