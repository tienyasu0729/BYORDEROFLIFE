package csd.kmp;

public class BruteForceSearch {
    public static void main(String[] args) {
        String text = "This is a sample text for searching.";
        String pattern = "sample";

        int position = search(text, pattern);

        if (position != -1) {
            System.out.println("Pattern found at position: " + position);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;

            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i; // Pattern found at position i
            }
        }

        return -1; // Pattern not found in the text
    }
}

