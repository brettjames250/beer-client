package com.springmicroservices.breweryclient.web.client;

import com.springmicroservices.breweryclient.web.model.BeerDto;
import com.springmicroservices.breweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "beer.project", ignoreUnknownFields = false)
public class BreweryClient {

    private String apiHost;
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public URI addNewBeer(BeerDto newBeer){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, newBeer);
    }

    public void updateBeer(UUID beerId, BeerDto updatedBeer){
        restTemplate.put(apiHost + BEER_PATH_V1 + beerId.toString(), updatedBeer);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apiHost + BEER_PATH_V1 + beerId.toString());
    }

    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI addNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
    }

}
