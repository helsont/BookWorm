import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Helson Taveras on 4/23/15.
 */
public class URLReader {

    public static String getPageContents(String pageUrl) {
        URL url;

        try {
            // get URL content
            url = new URL(pageUrl);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuilder builder = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                builder.append(inputLine);
            }

            br.close();

            return builder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new Error("Could not read the URL.");
    }
}
