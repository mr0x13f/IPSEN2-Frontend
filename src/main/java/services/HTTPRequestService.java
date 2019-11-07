package services;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * HTTPRequestService for all HTTP requests.
 *
 * @author TimvHal
 * @version 06-11-2019
 */
public class HTTPRequestService {

    private static HttpURLConnection apiConnection;
    private static URL apiUrl;
    private static BufferedReader reader;
    private static String line;
    private static StringBuffer responseContent;

    public static String setupRequest(String url, String type, String userCredentials) {
        responseContent = new StringBuffer();
        try {
            type.toUpperCase();
            apiUrl = new URL(url);
            apiConnection = (HttpURLConnection) apiUrl.openConnection();

            //request setup
            apiConnection.setRequestMethod(type);
            apiConnection.setConnectTimeout(5000); //Timeout timer
            apiConnection.setReadTimeout(5000);

            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            apiConnection.setRequestProperty ("Authorization", basicAuth);
            apiConnection.setDoOutput(true);

            reader = new BufferedReader(new InputStreamReader(apiConnection.getInputStream()));
            while((line = reader.readLine()) != null ) {
                responseContent.append(line);
            }
            reader.close();
        }
        catch (Exception e) { e.printStackTrace(); }
        //closes the connection
        finally {
            apiConnection.disconnect();
        }
        return responseContent.toString();
    }

    public static String getJourneys(String userCredentials) {
        return setupRequest("http://localhost:8080/journey", "GET", userCredentials);
    }

}
