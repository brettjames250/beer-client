package com.springmicroservices.breweryclient.web.client;

import com.springmicroservices.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.net.URI;
import java.util.UUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerByIdTest() {
      BeerDto beerDto = client.getBeerById(UUID.randomUUID());
      assertThat(beerDto).isNotNull();
    }

    @Test
    void addNewBeerTest(){
        // given
        BeerDto newBeer = BeerDto.builder()
                .beerName("My new beer")
                .beerStyle("Stout")
                .build();

        URI uri = client.addNewBeer(newBeer);
        assertThat(uri).isNotNull();
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerTest(){
        // given
        BeerDto updatedBeer = BeerDto.builder()
                .beerName("My new beer")
                .beerStyle("Stout")
                .build();

        client.updateBeer(UUID.randomUUID(), updatedBeer);
    }

    @Test
    void deleteBeerTest(){
        client.deleteBeer(UUID.randomUUID());
    }
}