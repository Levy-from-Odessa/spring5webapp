package guru.springframework.spring5webapp.web.client;

import java.util.UUID;
import java.net.URI;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.spring5webapp.web.model.BeerDto;
import guru.springframework.spring5webapp.web.model.CustomerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
  private String apihost;

  private final String BEER_PATH_V1 = "/api/v1/beer/";
  private final String CUSTOMER_PATH_V1 = "/api/v1/beer/";

  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public void setApiHost(String apihost) {
    this.apihost = apihost;
  }
  


  public BeerDto getBeerById(UUID uuid) {
    return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
  }
  public URI createBeer(BeerDto beerDto) {
    return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
  }
  public void updateBeer(UUID uuid, BeerDto beerDto) {
    restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
  }
  public void deleteBeer(UUID uuid) {
    restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid.toString());
  }

  public CustomerDto getCustomer(UUID randomUUID) {
    return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + randomUUID.toString(), CustomerDto.class);
  }


  public URI createCustomer(CustomerDto customerDto) {
    return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
  }

  public void updateCustomer(UUID randomUUID, CustomerDto customerDto) {
    restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + randomUUID.toString(), customerDto);
  }

  public void deleteCustomer(UUID randomUUID) {
    restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + randomUUID.toString());
  }



}
