package com.example.gui2;
import java.util.*;

public class CurrencyModel {
    private final Map<String, Double> exchangeRates;
    public CurrencyModel() {
        this.exchangeRates = new HashMap<>();
        initializeRates();
    }
    private void initializeRates() {
        // EUR‑Based
        exchangeRates.put("EUR-USD", 1.17);
        exchangeRates.put("EUR-TL", 50.15);
        exchangeRates.put("EUR-GBP", 0.88);
        exchangeRates.put("EUR-CHF", 0.93);
        exchangeRates.put("EUR-JPY", 182.1);
        exchangeRates.put("EUR-CNY", 8.18);

        // USD‑Basis
        exchangeRates.put("USD-EUR", 0.85);
        exchangeRates.put("USD-TL", 42.9);
        exchangeRates.put("USD-GBP", 0.75);
        exchangeRates.put("USD-CHF", 0.80);
        exchangeRates.put("USD-JPY", 155.2);
        exchangeRates.put("USD-CNY", 7.04);

        // TL‑Basis
        exchangeRates.put("TL-EUR", 0.02);
        exchangeRates.put("TL-USD", 0.0233);
        exchangeRates.put("TL-GBP", 0.0175); // ≈ TL→USD×USD→GBP
        exchangeRates.put("TL-CHF", 0.0160);
        exchangeRates.put("TL-JPY", 3.10);   // ≈ TL→USD×USD→JPY
        exchangeRates.put("TL-CNY", 0.14);   // ≈ TL→USD×USD→CNY

        // GBP‑Basis
        exchangeRates.put("GBP-EUR", 1.14);   // 1/0.88 ≈ 1.136
        exchangeRates.put("GBP-TL", 57.0);    // ≈ GBP→EUR×EUR→TL
        exchangeRates.put("GBP-USD", 1.34);
        exchangeRates.put("GBP-CHF", 1.07);
        exchangeRates.put("GBP-JPY", 208.3);
        exchangeRates.put("GBP-CNY", 11.57);

        // CHF‑Basis
        exchangeRates.put("CHF-EUR", 1.08);
        exchangeRates.put("CHF-USD", 1.25);
        exchangeRates.put("CHF-TL", 62.7);
        exchangeRates.put("CHF-GBP", 0.93);
        exchangeRates.put("CHF-JPY", 195.7);
        exchangeRates.put("CHF-CNY", 8.80);

        // JPY‑Basis
        exchangeRates.put("JPY-EUR", 0.00549);
        exchangeRates.put("JPY-TL", 0.0276);
        exchangeRates.put("JPY-USD", 0.00644);
        exchangeRates.put("JPY-CHF", 0.00511);
        exchangeRates.put("JPY-GBP", 0.00480);
        exchangeRates.put("JPY-CNY", 0.045);

        // CNY‑Basis
        exchangeRates.put("CNY-EUR", 0.122);
        exchangeRates.put("CNY-TL", 6.12);
        exchangeRates.put("CNY-USD", 0.142);
        exchangeRates.put("CNY-GBP", 0.086);
        exchangeRates.put("CNY-CHF", 0.114);
        exchangeRates.put("CNY-JPY", 22.6);

    }
    public Set<String> getAvailableCurrencies() {
        Set<String> currencies = new HashSet<>();
        currencies.add("EUR");
        currencies.add("USD");
        currencies.add("TL");
        currencies.add("GBP");
        currencies.add("CHF");
        currencies.add("CNY");
        currencies.add("JPY");

        return currencies;
    }
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }
        String key = fromCurrency + "-" + toCurrency;
        Double rate = exchangeRates.get(key);

        if (rate == null) {
            throw new IllegalArgumentException(
                    "No exchange rate information for" + key
            );}
        return amount * rate;
    }

}
