import org.json.JSONArray;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Helson Taveras on 4/23/15.
 */
public class BookWorm {

    public BookWorm() throws IOException {
        String[][] queries = new String[][]{
                animalQuery, bloodQuery
        };
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            String[] words = BookInput.getBookFromLocalFile(b);
            b.createTrie(words);
            SearchText st = new SearchText(b);
            for (int x = 0; x < queries.length; x++) {
                st.search(queries[x]);
            }
            st.printSummary();
        }
    }

    private final Book[] books = new Book[]{
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
        new BookWorm();
    }
}
