package philosophy.Wiki;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Component
public class PageFetcher {

    public String getPage(String page) throws IOException {
        URL url = null;
        try {
            url = new URL("https://en.wikipedia.org/wiki/" + page);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        if (conn.getResponseCode() != 200) {
            return  "";
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String str;
        StringBuilder doc = new StringBuilder();
        while((str = br.readLine()) != null) {
            doc.append(str);
        }
        br.close();

        conn.disconnect();

        return doc.toString();
    }

}
