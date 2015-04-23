/**
 * Created by Helson Taveras on 4/23/15.
 */
public class BookInput {

    public static String[] getBookFromURL(Book book) {
        return getBook(book, true, true);
    }

    public static String[] getBookFromLocalFile(Book book) {
        return getBook(book, false, true);
    }

    public static String[] getBookFromURL(Book book, boolean toLowercase) {
        return getBook(book, true, toLowercase);
    }

    public static String[] getBookFromLocalFile(Book book, boolean toLowercase) {
        return getBook(book, false, toLowercase);
    }

    private static String[] getBook(Book book, boolean URL, boolean toLowercase) {
        String[] wordsOfBook = null;
        String splitByAnyNumberOfSpaces = "\\s+";
        if (URL) {
            String pageContents = URLReader.getPageContents(book.url);
            wordsOfBook = pageContents.split(splitByAnyNumberOfSpaces);
        } else {
            wordsOfBook = TextReader.getText("texts/" + book.getFileName());
        }
        if (toLowercase) {
            for (int i = 0; i < wordsOfBook.length; i++) {
                wordsOfBook[i] = wordsOfBook[i].toLowerCase();
            }
        }

        return wordsOfBook;
    }
}
