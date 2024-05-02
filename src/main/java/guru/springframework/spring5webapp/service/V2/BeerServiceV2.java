package guru.springframework.spring5webapp.service.V2;

import java.util.UUID;

import guru.springframework.spring5webapp.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
  BeerDtoV2 getId(UUID beerId);
  BeerDtoV2 create(BeerDtoV2 beerDtoV2BeerDtoV2);
  BeerDtoV2 update(UUID id, BeerDtoV2 beerDtoV2BeerDtoV2);
  BeerDtoV2 delete(UUID id);


}
