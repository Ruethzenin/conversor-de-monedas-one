import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (true) {
            System.out.println("Monedas disponibles: USD, EUR, GBP, JPY, MXN");
            System.out.print("Ingresa la moneda de origen: ");
            String origen = scanner.next().toUpperCase();

            System.out.print("Ingresa la moneda de destino: ");
            String destino = scanner.next().toUpperCase();

            System.out.print("Ingresa la cantidad: ");
            String cantidad = scanner.next().toUpperCase();

            getEquivalente(limpiarEspacios(origen),destino,cantidad);

            System.out.print("¿Quieres realizar otra conversión? (si/no): ");
            String anotherConversion = scanner.next().toLowerCase();
            if (!anotherConversion.equals("si")) {
                break;
            }
        }

    }
    public static void getEquivalente (String origen, String destino, String cantidad) throws IOException {
        try{
            // Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/41a3fc65d752c10bd4b0145b/pair/"
                    + origen +"/" + destino + "/" + cantidad;

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            String req_result = jsonobj.get("conversion_result").getAsString();
            System.out.println(cantidad + " " + origen + " = " + req_result + " " + destino);

        } catch (FileNotFoundException e){
            System.out.println("Moneda invalida");
            System.out.println("Por favor ingresa el codigo de moneda correctamente y sin espacios");

        }

    }

    public static String limpiarEspacios(String palabra) {
        Scanner lineScanner = new Scanner(palabra);
        while (lineScanner.hasNext()) {
            String sinEspacios = lineScanner.next();
            if (!sinEspacios.trim().isEmpty()) {
                return sinEspacios;
            }
        }
        return palabra;
    }
}


