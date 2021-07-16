package org.thoughtworks;

public class Report {
    private ParseTransactions parser;

    public Report(ParseTransactions parser) {
        this.parser = parser;
    }


    public String generate() {
        StringBuilder builder = new StringBuilder();
        builder.append("Total Income: ").append(parser.getTotalIncome()).append("\n");
        builder.append("Total Expenses: ").append(parser.getTotalExpense()).append("\n");
        builder.append("Total Savings: ").append(parser.getTotalSavings()).append("\n");
        parser.getTopExpense();
        builder.append("Top Expense Category: ").append(parser.getTopExpenseValue());
        builder.append(" @").append(parser.getTopExpenseCategory());
        System.out.println(builder.toString());
        return builder.toString();
    }
}
