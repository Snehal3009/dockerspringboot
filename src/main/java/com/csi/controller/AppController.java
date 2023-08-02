package com.csi.controller;

import com.csi.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String sayHello(){
        return "WELCOME TO FINTECH CSI PUNE";
    }

    @GetMapping("/getalldata")
    public List<Customer> getAllCustomerData(){
        return Stream.of(new Customer(121, "SWARA", 65000.45),
                new Customer(123, "AKSHAY", 50000.00),
                new Customer(126, "VIKI", 96000),
                new Customer(127, "BINU", 55000),
                new Customer(191, "LAKSHMI", 4500.22)).collect(Collectors.toList());
    }

    @GetMapping("/filterdatabyaccountbalance/{custAccountBalance}")
    public List<Customer> filterDataByAccBalance(@PathVariable double custAccountBalance){
        return getAllCustomerData().stream().filter(cust-> cust.getCustAccountBalance()>= custAccountBalance).collect(Collectors.toList());
    }

}
