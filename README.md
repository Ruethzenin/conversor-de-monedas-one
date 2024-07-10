# CONVERSOR DE MONEDAS 
## Descripcion del proyecto
En este proyecto puedes hacer conversiones entre diferentes divisas como "MXN", "USD", "EUR", "KRW" y "JPY", las tazas de cambio son obtenidas de la API de ExchangeRate-API y usa la bibloteca GSON para manejar los datos obtenidos.
## Caracteristicas
- Cuenta con un menu que muestra las siguientes opciones de conversion:
1. Mexican Peso ==>> United States Dollar
2. United States Dollar ==>> Mexican Peso
3. Mexican Peso ==>> Japanese Yen
4. Japanese Yen ==>> Mexican Peso
5. Mexican Peso ==>> South Korean Won
6. South Korean Won ==>> Mexican Peso
7. Mexican Peso ==>> Euro
8. Euro ==>> Mexican Peso
9. Salir
- El programa no hace cálculos para obtener el resultado de la conversión, la API de ExchangeRate ofrece una "Pair Conversion Requests" la cual calcula el equivalente entre la cantidad de una moneda a otra que desees y eso fue lo que utilice. Mas informacion de "Pair Conversion Requests": https://www.exchangerate-api.com/docs/pair-conversion-requests
- Despues de realizar una conversion el usuario puede decidir si hacer otra o salir del programa
## Ejemplo de uso 
## Menu
![Captura](https://github.com/Ruethzenin/conversor-de-monedas-one/assets/146894039/f4ce7d7e-325b-4603-bb39-50c1f7ed7e17)
## Conversion de MXN a USD
![Captura2](https://github.com/Ruethzenin/conversor-de-monedas-one/assets/146894039/377f304c-d462-47a5-a6f5-ecf890beb4af)
## Conversion de MXN a JPY
![Captura3](https://github.com/Ruethzenin/conversor-de-monedas-one/assets/146894039/74f7eab5-a2e1-49c0-90da-2d8bbea9bfd7)
## Requisitos 
- Java 11 o superior
- IntelliJ IDEA (o cualquier otro IDE compatible con Java)
- Conexión a internet para acceder a la API de Exchange Rate
- Clave de API válida para la API de tipo de cambio (reemplazar YOUR-API-KEY en el código)
