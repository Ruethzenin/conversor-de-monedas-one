public class Moneda {
    private String currencyCode;
    private double valorARS;
    private double valorUSD;
    private double valorEUR;
    private double valorMXN;
    private double valorCLP;


    public double getValorConversion(double equivalenciaOtraMoneda, double cantidad){
        return cantidad * equivalenciaOtraMoneda;
    }

    @Override
    public String toString() {
        return
                "Moneda='" + currencyCode +
                ", Valor en ARS=" + valorARS +
                ", Valor en USD=" + valorUSD +
                ", Valor en EUR=" + valorEUR +
                ", Valor e MXN=" + valorMXN +
                ", Valor en CLP=" + valorCLP;
    }
}
