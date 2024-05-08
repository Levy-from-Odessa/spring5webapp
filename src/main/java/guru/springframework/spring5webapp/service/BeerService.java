package guru.springframework.spring5webapp.service;

import java.util.UUID;
import java.util.List;

import guru.springframework.spring5webapp.web.model.BeerDto;

public interface BeerService {
  List<BeerDto> getAll();
  BeerDto getId(UUID beerId);
  BeerDto create(BeerDto beerDto);
  BeerDto update(UUID id, BeerDto beerDto);
  BeerDto delete(UUID id);

} 
