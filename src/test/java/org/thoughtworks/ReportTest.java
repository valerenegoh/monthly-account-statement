package org.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class ReportTest {
    ParseTransactions parser;

    @Before
    public void setUp() {
        parser = new ParseTransactions();

        Map<String, BigDecimal> transactions = new HashMap<>();
        transactions.put("FoodPanda", BigDecimal.valueOf(-3200.5));
        transactions.put("Stationary", BigDecimal.valueOf(-1940.6));
        transactions.put("Grocery", BigDecimal.valueOf(-6901.89));
        transactions.put("LoanPayment", BigDecimal.valueOf(-4000));
        transactions.put("Royalty", BigDecimal.valueOf(1200));
        transactions.put("Salary", BigDecimal.valueOf(20000));
        parser.setTransactions(transactions);
    }

    @Test
    public void shouldPrintReport() {
        Report report = new Report(parser);
        String reportString = report.generate();
        assertThat(reportString, containsString("Total Income: 21200"));
        assertThat(reportString, containsString("Total Expenses: 16042.99"));
        assertThat(reportString, containsString("Total Savings: 5157.01"));
        assertThat(reportString, containsString("Top Expense Category: 6901.89 @Grocery"));
    }
}
