package org.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParseTransactionsTest {
    ParseTransactions parser;

    @Before
    public void setUp() {
        parser = new ParseTransactions();
    }

    @Test
    public void shouldGetTotalSavings() {
        parser.setTotalIncome(BigDecimal.valueOf(21200));
        parser.setTotalExpense(BigDecimal.valueOf(16042.99));

        BigDecimal totalSavings = parser.getTotalSavings();

        assertThat(totalSavings, is(BigDecimal.valueOf(5157.01)));
    }

    @Test
    public void shouldGetTotalIncome() {
        Map<String, BigDecimal> transactions = new HashMap<>();
        transactions.put("FoodPanda", BigDecimal.valueOf(-3200.5));
        transactions.put("Royalty", BigDecimal.valueOf(1200));
        transactions.put("Salary", BigDecimal.valueOf(20000));

        parser.setTransactions(transactions);
        assertThat(parser.getTotalIncome(), is(BigDecimal.valueOf(21200)));
    }

    @Test
    public void shouldGetTotalExpense() {
        Map<String, BigDecimal> transactions = new HashMap<>();
        transactions.put("FoodPanda", BigDecimal.valueOf(-3200.5));
        transactions.put("Grocery", BigDecimal.valueOf(-2800.3));
        transactions.put("Royalty", BigDecimal.valueOf(1200));
        transactions.put("Salary", BigDecimal.valueOf(20000));

        parser.setTransactions(transactions);
        assertThat(parser.getTotalExpense(), is(BigDecimal.valueOf(6000.8)));
    }

    @Test
    public void shouldGetTopExpense() {
        Map<String, BigDecimal> transactions = new HashMap<>();
        transactions.put("FoodPanda", BigDecimal.valueOf(-3200.5));
        transactions.put("Grocery", BigDecimal.valueOf(-2800.3));
        transactions.put("Royalty", BigDecimal.valueOf(1200));
        transactions.put("Salary", BigDecimal.valueOf(20000));

        parser.setTransactions(transactions);
        parser.getTopExpense();
        assertThat(parser.getTopExpenseCategory(), is("FoodPanda"));
        assertThat(parser.getTopExpenseValue(), is(BigDecimal.valueOf(3200.5)));
    }
}
