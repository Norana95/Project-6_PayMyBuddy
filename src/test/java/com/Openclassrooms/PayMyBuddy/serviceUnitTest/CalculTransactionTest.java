package com.Openclassrooms.PayMyBuddy.serviceUnitTest;

import com.Openclassrooms.PayMyBuddy.constant.FareOfTransaction;
import com.Openclassrooms.PayMyBuddy.service.CalculTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculTransactionTest {

    @Autowired
    CalculTransaction calculTransaction;

    @Test
    void transactionCalculationWithPercentageTest() {
        int amountOfTransaction = 20;
        double result = amountOfTransaction - (amountOfTransaction * FareOfTransaction.fare);
        Assertions.assertEquals(19.9,result);
    }
}
