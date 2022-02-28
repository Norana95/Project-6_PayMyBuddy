package com.Openclassrooms.PayMyBuddy.service;

import com.Openclassrooms.PayMyBuddy.constant.FareOfTransaction;
import org.springframework.stereotype.Service;

@Service
public class CalculTransaction {

    public double transactionCalculationWithPercentage(int amountOfTransaction){
        double result =amountOfTransaction - (amountOfTransaction * FareOfTransaction.fare);
        return result;
    }
}
