package com.springmicroservices.breweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "beer.project", ignoreUnknownFields = false)
public class BreweryClient {

    private String apiHost;
    public final String BEER_PATH_V1 = "/api/v1/beer";

    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }

}
