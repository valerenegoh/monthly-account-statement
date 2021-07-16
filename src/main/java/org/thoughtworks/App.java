package org.thoughtworks;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        File file = new File("bank-transactions.txt");
        Scanner scanner = new Scanner(file);
        List<String> transactionsList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            transactionsList.add(scanner.nextLine());
        }

        ParseTransactions parser = new ParseTransactions();
        parser.setTransactions(getTransactionsMap(transactionsList));

        Report report = new Report(parser);
        report.generate();
    }

    public static Map<String, BigDecimal> getTransactionsMap(List<String> transactionsList) {
        Map<String, BigDecimal> transactionsMap = new HashMap<>();
        for (String statement: transactionsList) {
            String[] statementArray = statement.split(",");
            String category = statementArray[2];
            BigDecimal value = new BigDecimal(statementArray[1]);
            BigDecimal computedValue = transactionsMap.getOrDefault(category, BigDecimal.ZERO).add(value);
            transactionsMap.put(category, computedValue);
        }
        return transactionsMap;
    }

}
