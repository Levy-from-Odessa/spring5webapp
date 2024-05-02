package guru.springframework.spring5webapp.service;

import java.util.UUID;


import guru.springframework.spring5webapp.web.model.BeerDto;

public interface BeerService {
  BeerDto getId(UUID beerId);
  BeerDto create(BeerDto beerDto);

} 
