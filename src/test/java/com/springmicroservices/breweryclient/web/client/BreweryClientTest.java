package com.springmicroservices.breweryclient.web.client;

import com.springmicroservices.breweryclient.web.model.BeerDto;
import com.springmicroservices.breweryclient.web.model.CustomerDto;
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

    @Test
    void getCustomerByIdTest() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertThat(customerDto).isNotNull();
    }

    @Test
    void addNewCustomerTest(){
        //given
        CustomerDto customerDto = CustomerDto.builder().name("new customer").build();

        URI uri = client.addNewCustomer(customerDto);
        assertThat(uri).isNotNull();
        System.out.println(uri);
    }

    @Test
    void updateCustomerTest(){
        //given
        CustomerDto customerDto = CustomerDto.builder().name("new customer").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }


    @Test
    void deleteCustomerTest(){
        client.deleteCustomer(UUID.randomUUID());
    }
}