package guru.springframework.spring5webapp.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
  
  BeerDto getDto (){
    return BeerDto.builder()
      .id(UUID.randomUUID())
      .beerName("BeerName")
      .beerStyle(BeerStyleEnu.ALE)
      .upc(123456789012L)
      .price(new BigDecimal("12.99"))
      .myLocalDate(LocalDate.now())
      .build();
  } 
}
