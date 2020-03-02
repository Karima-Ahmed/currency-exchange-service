package com.example.microservices.currencyexchangeservice;

import com.example.microservices.currencyexchangeservice.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

//        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(2));
//        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));


        //call service-limits microservice
       // ResponseEntity<Configuration> resposeEntity = new RestTemplate().getForEntity("http://localhost:8081/limits", Configuration.class);
      //  Configuration conf = resposeEntity.getBody();
     //   ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(2), Integer.parseInt(environment.getProperty("local.server.port")), conf);

        //call service-limits microservice using todo: Feign Client
        Configuration conf = proxy.retrieveConfiguration(from, to);
        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(2), Integer.parseInt(environment.getProperty("local.server.port")), conf);

        return exchangeValue;
    }
}
