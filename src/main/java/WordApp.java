import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WordApp {

    protected List<String> readFile(String path) {
        try {
            return Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    protected Boolean isConcatenatedWord(String word, int length, List<String> words) {
        int wordLength = word.length();
        if (wordLength == 0) {
            return true;
        }
        for (int i = 1; i <= wordLength; i++) {
            if (i == length) {
                return false;
            }
            String substring = word.substring(0, i);
            if (words.contains(substring)) {
                if (isConcatenatedWord(word.substring(i), length, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected WordsData getSolution(List<String> words) {
        String longestWord = "";
        String secondLongestWord = "";
        long totalCount = 0;
        for (String word : words) {
            if (isConcatenatedWord(word, word.length(), words)) {
                if (word.length() > longestWord.length()) {
                    secondLongestWord = longestWord;
                    longestWord = word;
                }
                totalCount += 1;
            }
        }
        return new WordsData(longestWord, secondLongestWord, totalCount);
    }

    static class WordsData {

        private String longestConcatenatedWord;
        private String secondLongestConcatenatedWord;
        private long totalCount;

        public WordsData(String longestWord, String secondLongestWord, long totalCount) {
            this.longestConcatenatedWord = longestWord;
            this.secondLongestConcatenatedWord = secondLongestWord;
            this.totalCount = totalCount;
        }

        public String getLongestConcatenatedWord() {
            return longestConcatenatedWord;
        }

        public String getSecondLongestConcatenatedWord() {
            return secondLongestConcatenatedWord;
        }

        public long getTotalCount() {
            return totalCount;
        }
    }
}
