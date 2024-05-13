package guru.springframework.spring5webapp.web.mappers;

import org.mapstruct.Mapper;

import guru.springframework.spring5webapp.web.model.Beer;
import guru.springframework.spring5webapp.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
  BeerDto beerToBeerDto(Beer beer);
  Beer beerDtoToBeer(BeerDto beerDto);
  
}
