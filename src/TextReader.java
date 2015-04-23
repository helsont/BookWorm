
import java.io.*;

/**
 * Created by Helson Taveras on 4/2/15.
 */
public class TextReader {

    public static String[] getText(String filename) {
        String splitByAnyNumberOfSpaces = "\\s+";
        String text = getFileContents(filename);
        return text.split(splitByAnyNumberOfSpaces);
    }

    /**
     * @param fileName
     * @return
     */
    private static String[] contentSplitByNewline(String fileName) {
        String newLineRegex = "\\n";
        return contentSplitByRegex(fileName, newLineRegex);
    }

    /**
     * @param fileName
     * @param splitRegex
     * @return
     */
    private static String[] contentSplitByRegex(String fileName, String splitRegex) {
        String contents = getFileContents(fileName);
        return contents.split(splitRegex);
    }

    private static String getFileContents(String fileName) {
        InputStream stream = TextReader.class.getResourceAsStream(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        if (stream == null) {
            throw new IllegalArgumentException("Could not create InputStream" +
                    "from " + fileName + ".");
        } else {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(stream));
            try {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + " ");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}

