package guru.springframework.spring5webapp.service.V2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.spring5webapp.web.model.v2.BeerDtoV2;
import guru.springframework.spring5webapp.web.model.v2.BeerStyleEnu;

@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
  @Override
  public BeerDtoV2 getId(UUID beerId) {
    return BeerDtoV2.builder().id(UUID.randomUUID())
        .beerName("Galaxy Cat")
        .beerStyle(BeerStyleEnu.LAGER)
        .upc(337010000000L)
        .build();
  }

  @Override
  public BeerDtoV2 create(BeerDtoV2 BeerDtoV2) {
    return BeerDtoV2.builder().id(UUID.randomUUID())
      .build();
  }

  @Override
  public BeerDtoV2 update(UUID id, BeerDtoV2 BeerDtoV2) {
    return BeerDtoV2.builder().id(UUID.randomUUID())
      .build();
  }

  @Override
  public BeerDtoV2 delete(UUID id) {
    return BeerDtoV2.builder().id(UUID.randomUUID())
      .build();
  }

  

}
