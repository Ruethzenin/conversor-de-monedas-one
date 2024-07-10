import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {
    private final String API_KEY = "Your_Api_Key";
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    public void getEquivalente (String origen, String destino, String cantidad) throws IOException {
        String url_str = URL_BASE+API_KEY+"/pair/"
                + origen +"/" + destino + "/" + cantidad;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String req_result = jsonobj.get("conversion_result").getAsString();
        System.out.println();
        System.out.println(cantidad + " " + origen + " = " + req_result +" " +destino +" \n");
    }
}
