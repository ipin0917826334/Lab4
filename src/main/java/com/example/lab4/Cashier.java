package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{money}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") int money){
//        double out = num1+num2;
            Change change = new Change();
            change.setB1000((money/1000));
            change.setB500((money%1000/500));
        change.setB100((money%1000%500/100));
        change.setB20((money%1000%500%100/20));
        change.setB10((money%1000%500%100%20/10));
        change.setB5((money%1000%500%100%20%10/5));
        change.setB1((money%1000%500%100%20%10%5/1));
        return change;
    }
    }
