package com.example.microservices.currencyexchangeservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="limits-service", url="localhost:8081")
@FeignClient(name="limits-service")//rebbon will get url from eureka
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/limits")
    public Configuration retrieveConfiguration(@PathVariable String from, @PathVariable String to);
}
