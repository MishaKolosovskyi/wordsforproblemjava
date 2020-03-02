import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordAppTest {

    private static final String PATH = "src/main/resources/words.txt";
    private static final WordApp WORD_APP = new WordApp();
    private static final List<String> WORDS = WORD_APP.readFile(PATH);

    @Test
    protected void readFile() {
        int actualSize = WORDS.size();
        int expectedSize = 8;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    protected void isConcatenatedWord() {
        Boolean isConcatenated  = WORD_APP.isConcatenatedWord("ratcatdogcat", "ratcatdogcat".length(), WORDS);
        assertTrue(isConcatenated);
    }

    @Test
    protected void getSolution() {
        WordApp.WordsData solution = WORD_APP.getSolution(WORDS);
        String longestConcatenatedWordActual  = solution.getLongestConcatenatedWord();
        String secondLongestConcatenatedWordActual = solution.getSecondLongestConcatenatedWord();
        long totalCountActual = solution.getTotalCount();
        assertEquals("ratcatdogcat", longestConcatenatedWordActual);
        assertEquals("catsdogcats", secondLongestConcatenatedWordActual);
        assertEquals(3L, totalCountActual);
    }
}
