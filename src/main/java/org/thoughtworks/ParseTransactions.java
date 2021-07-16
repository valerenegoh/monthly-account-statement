package org.thoughtworks;

import java.math.BigDecimal;
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
        BigDecimal totalIncome = BigDecimal.ZERO;
        for (BigDecimal value: transactions.values()) {
            if (value.signum() == 1) {
                totalIncome = totalIncome.add(value);
            }
        }
        setTotalIncome(totalIncome);
        return totalIncome;
    }

    public BigDecimal getTotalExpense() {
        BigDecimal totalExpense = BigDecimal.ZERO;
        for (BigDecimal value: transactions.values()) {
            if (value.signum() == -1) {
                totalExpense = totalExpense.add(value);
            }
        }
        setTotalExpense(totalExpense.abs());
        return totalExpense.abs();
    }

    public Map<String, BigDecimal> getTransactions() {
        return transactions;
    }

    public void setTransactions(Map<String, BigDecimal> transactions) {
        this.transactions = transactions;
    }

    public void getTopExpense() {
        BigDecimal maximumExpenseValue = BigDecimal.ZERO;
        String maximumExpenseCategory = "";
        for (String category: transactions.keySet()) {
            BigDecimal value = transactions.get(category);
            if (value.signum() == -1 && value.compareTo(maximumExpenseValue) == -1) {
                maximumExpenseValue = value;
                maximumExpenseCategory = category;
            }
        }
        setTopExpenseCategory(maximumExpenseCategory);
        setTopExpenseValue(maximumExpenseValue.abs());
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
