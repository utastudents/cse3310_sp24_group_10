package uta.cse3310;

public class ScoreCalc {
    public static int calculateWordscore(String word) {
        int length = word.length();
        int result = length * 5;
        return result;
    }

    public static boolean isWordInBank(String word, String[] words) {
        for (String w : words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void Calc() {

        if (isWordInBank(word, words)) {
            int result = calculateWordscore(word);
            Player.score += result;
        } else {
            System.out.println("Word not in word bank, try again.");
        }

    }
}
