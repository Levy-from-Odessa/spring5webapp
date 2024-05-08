package guru.springframework.spring5webapp.service;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import guru.springframework.spring5webapp.web.model.BeerDto;
import guru.springframework.spring5webapp.web.model.BeerStyleEnu;

@Service
public class BeerServiceImpl implements BeerService{

  @Override
  public List<BeerDto> getAll() {
    return new ArrayList<>(Arrays.asList(BeerDto.builder().id(UUID.randomUUID())
        .beerName("Galaxy Cat")
        .beerStyle(BeerStyleEnu.ALE)
        .upc(337010000000L)
        .build()));
  }

  @Override
  public BeerDto getId(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID())
        .beerName("Galaxy Cat")
        .beerStyle(BeerStyleEnu.ALE)
        .upc(337010000000L)
        .build();
  }

  @Override
  public BeerDto create(BeerDto beerDto) {
    return BeerDto.builder().id(UUID.randomUUID())
      .build();
  }

  @Override
  public BeerDto update(UUID id, BeerDto beerDto) {
    return BeerDto.builder().id(UUID.randomUUID())
      .build();
  }

  @Override
  public BeerDto delete(UUID id) {
    return BeerDto.builder().id(UUID.randomUUID())
      .build();
  }

  
}
