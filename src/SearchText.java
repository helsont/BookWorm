import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Helson Taveras on 4/23/15.
 */
public class SearchText {
    public Book book;
    public ArrayList<Query> overall;

    private final String API = "http://semantic-link.com/related.php?word=";

    public SearchText(Book b) {
        this.book = b;
        overall = new ArrayList<Query>();
    }

    private Query createEntry(String query) {
        Query currentTheme = new Query(query);
        overall.add(currentTheme);
        return currentTheme;
    }

    private Query[] getRelatedWords(String query) throws IOException {
        JSONArray array = JsonReader.readJsonArrayFromUrl(API + query);
        return getWordQueries(array, query);
    }

    public void search(String[] relatedQueries) throws IOException {
        Query currentTheme = createEntry(relatedQueries[0]);
        Trie trie = book.trie;

        for (int i = 0; i < relatedQueries.length; i++) {
            Query[] relatedWords = getRelatedWords(relatedQueries[i]);

            // Each word in the query
            for (int w = 0; w < relatedWords.length; w++) {
                if (trie.isWord(relatedWords[w].query)) {
                    currentTheme.count++;
                    relatedWords[w].count++;
                }
            }
        }
    }

    public String[] concat(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c = new String[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    public void search(String query) throws IOException {
        Query currentTheme = createEntry(query);
        Query[] relatedWords = getRelatedWords(query);
        Trie trie = book.trie;

        // Each word in the query
        for (int w = 0; w < relatedWords.length; w++) {
            if (trie.isWord(relatedWords[w].query)) {
                currentTheme.count++;
                relatedWords[w].count++;
            }
        }
    }

    public void printSummary() {
        System.out.println("Summary for " + book.title);
        for (int i = 0; i < overall.size(); i++) {
            System.out.println(overall.get(i));
        }
    }

    private static Query[] getWordQueries(JSONArray array, String word) {
        Query[] queries = new Query[array.length() + 1];
        for (int i = 0; i < array.length(); i++) {
            String query = array.getJSONObject(i).getString("v").toLowerCase();
            queries[i] = new Query(query);
        }
        // Append the search word to the end
        queries[queries.length - 1] = new Query(word.toLowerCase());
        return queries;
    }
}
