package org.thoughtworks;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class ParseTransactions {
    private Map<String, BigDecimal> transactions;
    private BigDecimal topExpenseValue;
    private String topExpenseCategory;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    public BigDecimal getTotalSavings() {
        return totalIncome.subtract(totalExpense);
    }

    public BigDecimal getTotalIncome() {
        BigDecimal totalIncome = transactions.values().stream().
                filter(x -> x.signum() == 1).reduce(BigDecimal.ZERO, BigDecimal::add);
        setTotalIncome(totalIncome);
        return totalIncome;
    }

    public BigDecimal getTotalExpense() {
        BigDecimal totalExpense = transactions.values().stream().
                filter(x -> x.signum() == -1).reduce(BigDecimal.ZERO, BigDecimal::add);
        setTotalExpense(totalExpense.abs());
        return totalExpense.abs();
    }

    public void setTransactions(Map<String, BigDecimal> transactions) {
        this.transactions = transactions;
    }

    public void getTopExpense() {
        String maximumExpenseCategory = Collections.min(transactions.entrySet(), Map.Entry.comparingByValue()).getKey();

        setTopExpenseCategory(maximumExpenseCategory);
        setTopExpenseValue(transactions.get(maximumExpenseCategory).abs());
    }

    public String getTopExpenseCategory() {
        return topExpenseCategory;
    }

    public void setTopExpenseCategory(String topExpenseCategory) {
        this.topExpenseCategory = topExpenseCategory;
    }

    public BigDecimal getTopExpenseValue() {
        return topExpenseValue;
    }

    public void setTopExpenseValue(BigDecimal topExpenseValue) {
        this.topExpenseValue = topExpenseValue;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }
}
