package com.redfoxsoft.entrevista.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MoneyCalculatorService {
    public static HashMap<Integer, Integer> moneyCalculate (Integer salary){
        int[] values = {100, 50, 10, 5, 2, 1};
        HashMap<Integer, Integer> amountMoney = new HashMap<>();
        for(int moneyValue : values) {
            int amount = salary / moneyValue;
            if(amount > 0) {
                amountMoney.put(moneyValue, amount);
                salary = salary - (amount * moneyValue);
            }
        }
        return amountMoney;
    };
}
