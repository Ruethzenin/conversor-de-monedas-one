import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 7) {
            System.out.println("========= Menú =========");
            System.out.println("1. MXN");
            System.out.println("2. USD");
            System.out.println("3. EUR");
            System.out.println("4. CLP");
            System.out.println("6. ARS");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    getJson("MXN");
                    scanner.nextInt();
                    break;
                case 2:
                    getJson("USD");
                    scanner.nextInt();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Este es un mensaje de ejemplo.");
                    break;
                case 5:
                    System.out.println("¡Adiós!");
                    break;
                case 6:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
    public static void getJson(String moneda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/41a3fc65d752c10bd4b0145b/latest/" + moneda))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        MonedaA miMoneda = gson.fromJson(json,MonedaA.class);
        System.out.println(miMoneda);

    }

    }


