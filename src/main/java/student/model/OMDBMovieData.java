package student.model;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;

public final class OMDBMovieData {
    /**
     * Format required for the API request. There are many options, but keeping it simple for now.
     */
    private static final String API_URL_FORMAT_TITLE= "http://www.omdbapi.com/?t=%s&apikey=%s&";
    private static final String API_URL_FORMAT_YEAR= "http://www.omdbapi.com/?t=%s&y=%s&apikey=%s&";

    private static final String API_KEY = "";

   /**
     * Prevent instantiation.
     */
    private OMDBMovieData() {
        // Prevent instantiation
    }


     /**
     * Returns the URL for the API request.
     *
     * @param title The title of the movie to look up.
     * @return The URL for the API request.
     */
    public static String getApiUrl(String title) {
        return String.format(API_URL_FORMAT_TITLE, title, API_KEY);
    }

       /**
     * Gets the contents of a URL as an InputStream.
     *
     * @param urlStr the URL to get the contents of
     * @return the contents of the URL as an InputStream, or the null InputStream if the connection
     *         fails
     *
     */
    public static InputStream getUrlContents(String urlStr) {
        try {
            URI uri = URI.create(urlStr);
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // con.setRequestProperty("Content-Type", "application/xml");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                            + "(KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
            int status = con.getResponseCode();
            if (status == 200) {
                return con.getInputStream();
            } else {
                System.err.println("Failed to connect to " + urlStr);
            }

        } catch (Exception ex) {
            System.err.println("Failed to connect to " + urlStr);
        }
        return InputStream.nullInputStream();
    }
    /**
     * Gets movie details using the OMDB API.
     *
     * @param title the movie title to get the information about
     * @return the contents of the URL as an InputStream, or the null InputStream if the connection
     */
    public static InputStream getIpDetails(String title) {
        String urlStr = getApiUrl(title);
        return getUrlContents(urlStr);
    }
}
