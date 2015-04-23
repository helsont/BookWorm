import org.json.JSONArray;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Helson Taveras on 4/23/15.
 */
public class Reader {

    private final static String API = "http://semantic-link.com/related.php?word=";

    private final static Book[] books = new Book[]{
            new Book("Don Quixote", "http://www.gutenberg.org/cache/epub/996/pg996.txt"),
            new Book("Pride and Prejudice", "http://www.gutenberg.org/cache/epub/1342/pg1342.txt"),
            new Book("Crime and Punishment", "http://www.gutenberg.org/cache/epub/2554/pg2554.txt"),
            new Book("To the Lighthouse", "http://gutenberg.net.au/ebooks01/0100101.txt"),
//            new Book("Test", "null")
    };


    private final static String[] animalQuery = new String[]{
            "animal", "bird", "dog", "fish", "insect", "worm", "horse"
    };

    private final static String[] bloodQuery = new String[]{
            "blood", "guts", "red",
    };

    public static void main(String[] args) throws IOException {
        String[][] queries = new String[][]{
                animalQuery, bloodQuery
        };

//        int[] matches = new int[books.length];
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book:" + books[i]);
            matches(books[i], queries);
            System.out.println("=====================================");
        }
    }

    private static void matches(Book book, String[][] queries) throws IOException {
        Trie trie = new Trie();

        String[] theBook = TextReader.getText("texts/" + book.getFileName());
        for (int i = 0; i < theBook.length; i++) {
            theBook[i] = theBook[i].toLowerCase();
        }
        // Print out the books
        // System.out.println(Arrays.toString(theBook));

        for (int i = 0; i < theBook.length; i++) {
            trie.addString(theBook[i]);
        }

        // Parse through each query
        for (int q = 0; q < queries.length; q++) {
            // Each word in the query
            for (int w = 0; w < queries[q].length; w++) {
                String word = queries[q][w];
                JSONArray array = JsonReader.readJsonArrayFromUrl(API + word);
                String[] getRelatedWords = getWordQueries(array, word);

                System.out.println(Arrays.toString(getRelatedWords));

                System.out.println("Searching for word:" + word);
                int count = 0;
                for (int i = 0; i < getRelatedWords.length; i++) {
                    if (trie.isWord(getRelatedWords[i])) {
                        count++;
                    }
                }
                System.out.println("Number of related words:" + count);
            }
            System.out.println("\n\n\n");
        }
    }

    private static String[] getWordQueries(JSONArray array, String word) {
        String[] results = new String[array.length() + 1];
        for (int i = 0; i < array.length(); i++) {
            results[i] = array.getJSONObject(i).getString("v").toLowerCase();
        }
        // Append the search word to the end
        results[results.length - 1] = word.toLowerCase();
        return results;
    }
}
