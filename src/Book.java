/**
 * Created by Helson Taveras on 4/23/15.
 */
public class Book {

    public String title;
    public String url;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String url) {
        this(title);
        this.url = url;
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
