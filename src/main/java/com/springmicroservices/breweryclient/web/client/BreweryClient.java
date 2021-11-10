package com.springmicroservices.breweryclient.web.client;

import com.springmicroservices.breweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "beer.project", ignoreUnknownFields = false)
public class BreweryClient {

    private String apiHost;
    public final String BEER_PATH_V1 = "/api/v1/beer/";
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

    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }

}
