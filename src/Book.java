import java.util.ArrayList;

/**
 * Created by Helson Taveras on 4/23/15.
 */
public class Book {

    public String title;
    public String url;
    public Trie trie;

    public Book(String title) {
        this.title = title;
        trie = new Trie();
    }

    public Book(String title, String url) {
        this(title);
        this.url = url;
    }

    public void createTrie(String[] input) {
        for (String i : input) {
            trie.addString(i);
        }
    }

    public String getFileName() {
        return title + ".txt";
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
