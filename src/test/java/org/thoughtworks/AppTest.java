package org.thoughtworks;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest 
{
    List<String> transactionsList;
    Map<String, BigDecimal> transactionsMap;

    @Before
    public void setUp() {
        transactionsList = new ArrayList<>();
        transactionsList.add("30/11/2019,-3200.5,FoodPanda");
        transactionsList.add("28/11/2019,-1740.6,Stationary");
        transactionsList.add("25/11/2019,-2800.3,Grocery");
        transactionsList.add("25/11/2019,-4000,LoanPayment");
        transactionsList.add("20/11/2019,1200,Royalty");
        transactionsList.add("17/11/2019,-200,Stationary");
        transactionsList.add("15/11/2019,-2600.60,Grocery");
        transactionsList.add("10/11/2019,-1500.99,Grocery");
        transactionsList.add("05/11/2019,20000,Salary");

        transactionsMap = new HashMap<>();
        transactionsMap.put("FoodPanda", BigDecimal.valueOf(-3200.5));
        transactionsMap.put("Stationary", BigDecimal.valueOf(-1940.6));
        transactionsMap.put("Grocery", BigDecimal.valueOf(-6901.89));
        transactionsMap.put("LoanPayment", BigDecimal.valueOf(-4000));
        transactionsMap.put("Royalty", BigDecimal.valueOf(1200));
        transactionsMap.put("Salary", BigDecimal.valueOf(20000));
    }

    @Test
    public void shouldGetMapFromListOfTransactions()
    {
        assertThat(App.getTransactionsMap(transactionsList), is(transactionsMap));
    }
}
