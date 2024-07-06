import com.google.gson.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int option;
        String cantidad;
        String[] monedas = {"MXN", "USD", "EUR", "KRW", "JPY"};


        do {
            // Mostrar el menú
            System.out.println("==== CONVERSOR DE MONEDAS ====");
            System.out.println("1. Mexican Peso ==>> United States Dollar");
            System.out.println("2. United States Dollar ==>> Mexican Peso");
            System.out.println("3. Mexican Peso ==>> Japanese Yen");
            System.out.println("4. Japanese Yen ==>> Mexican Peso");
            System.out.println("5. Mexican Peso ==>> South Korean Won");
            System.out.println("6. South Korean Won ==>> Mexican Peso");
            System.out.println("7. Mexican Peso ==>> Euro");
            System.out.println("8. Euro ==>> Mexican Peso");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            option = scanner.nextInt();

            // Realizar la acción correspondiente a la opción seleccionada
            switch (option) {
                case 1:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[0],monedas[1],cantidad);
                    option = otraConversion();
                    break;
                case 2:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[1],monedas[0],cantidad);
                    option = otraConversion();
                    break;
                case 3:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[0],monedas[4],cantidad);
                    option = otraConversion();
                    break;
                case 4:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[4],monedas[0],cantidad);
                    option = otraConversion();
                    break;
                case 5:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[0],monedas[3],cantidad);
                    option = otraConversion();
                    break;
                case 6:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[3],monedas[0],cantidad);
                    option = otraConversion();
                    break;
                case 7:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[0],monedas[2],cantidad);
                    option = otraConversion();
                    break;
                case 8:
                    System.out.println("Ingresa el valor que dedeas convertir");
                    cantidad = scanner.next();
                    getEquivalente(monedas[2],monedas[0],cantidad);
                    option = otraConversion();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 9.");
                    break;
            }
            System.out.println();

        } while (option != 9);
    }
    public static void getEquivalente (String origen, String destino, String cantidad) throws IOException {
        String url_str = "https://v6.exchangerate-api.com/v6/41a3fc65d752c10bd4b0145b/pair/"
                + origen +"/" + destino + "/" + cantidad;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String req_result = jsonobj.get("conversion_result").getAsString();
        System.out.println();
        System.out.println(cantidad + " " + origen + " = " + req_result + " \n");
    }

    public static int otraConversion(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Deseas realizar otra conversion");
        System.out.println("0. No");
        System.out.println("1. Si");
        int opc = teclado.nextInt();
        if (opc != 0)
            return 1;
        return 9;
    }
}


