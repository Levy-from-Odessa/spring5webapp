package guru.springframework.spring5webapp.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;
import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.spring5webapp.web.model.BeerDto;
import guru.springframework.spring5webapp.web.model.CustomerDto;

@SpringBootTest
public class BreweryClientTest {
  @Autowired
  BreweryClient breweryClient;


  @Test
  void testGetBeerById() {
    BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
    assertNotNull(beerDto);
  }
  @Test
  void testCreateBeer() {
    URI uri = breweryClient.createBeer(BeerDto.builder().beerName("New Beer").build());
    assertNotNull(uri);
  }
  @Test
  void testUpdateBeer() {
    breweryClient.updateBeer(UUID.randomUUID(), BeerDto.builder().beerName("New Beer").build());
  }
  @Test
  void testDeleteBeer() {
    breweryClient.deleteBeer(UUID.randomUUID());
  }


  @Test
  void testGetCustomer() {
    CustomerDto customerDto = breweryClient.getCustomer(UUID.randomUUID());
    assertNotNull(customerDto);
  }
  @Test
  void testCreateCustomer() {
    URI uri = breweryClient.createCustomer(CustomerDto.builder().name("New Customer").build());
    assertNotNull(uri);
  }
  @Test
  void testUpdateCustomer() {
    breweryClient.updateCustomer(UUID.randomUUID(), CustomerDto.builder().name("New Customer").build());
  }
  @Test
  void testDeleteCustomer() {
    breweryClient.deleteCustomer(UUID.randomUUID());
  }

}
