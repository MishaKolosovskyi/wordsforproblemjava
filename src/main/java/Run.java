import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Enter a file path : ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        WordApp wordApp = new WordApp();
        List<String> words = wordApp.readFile(path);
        WordApp.WordsData solution = wordApp.getSolution(words);
        System.out.println("The longest concatenated word is " + solution.getLongestConcatenatedWord());
        System.out.println("The second longest concatenated words is " + solution.getSecondLongestConcatenatedWord());
        System.out.println("The total count of concatenated words is " + solution.getTotalCount());
    }
}
