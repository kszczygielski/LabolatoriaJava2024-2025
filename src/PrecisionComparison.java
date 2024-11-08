import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecisionComparison {
    public static void main(String[] args) {

        // Dane wyjściowe
        double priceNetto = 9.99;
        double vatRate = 0.23;
        int quantity = 10000;

        // Kalkulacja przy użyciu doub
        double priceBruttoDouble = priceNetto * (1 + vatRate); // Wartość brutto
        double totalBruttoDouble = priceBruttoDouble * quantity; // Całkowita wartość brutto dla 10000 szt.
        double totalNettoDouble = totalBruttoDouble / (1 + vatRate); // Wartość netto po odjęciu VAT

        System.out.println("Obliczenia z użyciem double:");
        System.out.println("Cena brutto za sztukę (double): " + priceBruttoDouble);
        System.out.println("Wartość brutto dla 10000 sztuk (double): " + totalBruttoDouble);
        System.out.println("Wartość netto po odjęciu VAT (double): " + totalNettoDouble);

        // Kalkulacja przy użyciu BigDecimal
        BigDecimal priceNettoBD = BigDecimal.valueOf(priceNetto);
        BigDecimal vatRateBD = BigDecimal.valueOf(vatRate);
        BigDecimal quantityBD = BigDecimal.valueOf(quantity);

        BigDecimal priceBruttoBD = priceNettoBD.multiply(BigDecimal.ONE.add(vatRateBD)); // Wartość brutto
        BigDecimal totalBruttoBD = priceBruttoBD.multiply(quantityBD); // Całkowita wartość brutto dla 10000 szt.
        BigDecimal totalNettoBD = totalBruttoBD.divide(BigDecimal.ONE.add(vatRateBD), 2, RoundingMode.HALF_UP); // Wartość netto po odjęciu VAT

        System.out.println("\nObliczenia z użyciem BigDecimal:");
        System.out.println("Cena brutto za sztukę (BigDecimal): " + priceBruttoBD);
        System.out.println("Wartość brutto dla 10000 sztuk (BigDecimal): " + totalBruttoBD);
        System.out.println("Wartość netto po odjęciu VAT (BigDecimal): " + totalNettoBD);

        // Wnioski
        System.out.println("\nPorównanie wartości:");
        System.out.println("Cena brutto za sztukę różnica: " + Math.abs(priceBruttoDouble - priceBruttoBD.doubleValue()));
        System.out.println("Wartość brutto dla 10000 sztuk różnica: " + Math.abs(totalBruttoDouble - totalBruttoBD.doubleValue()));
        System.out.println("Wartość netto po odjęciu VAT różnica: " + Math.abs(totalNettoDouble - totalNettoBD.doubleValue()));
    }
}
