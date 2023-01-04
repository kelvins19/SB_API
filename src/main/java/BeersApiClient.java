import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class BeersApiClient {
    public static String getBeers(int numberOfData) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://api.punkapi.com/v2/beers?page=2&per_page=" + numberOfData);
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            String responseString = EntityUtils.toString(response.getEntity());
            return responseString;
        } finally {
            response.close();
            httpClient.close();
        }
    }

    public static String getAllBeers() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://api.punkapi.com/v2/beers");
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            String responseString = EntityUtils.toString(response.getEntity());
            return responseString;
        } finally {
            response.close();
            httpClient.close();
        }
    }
}
