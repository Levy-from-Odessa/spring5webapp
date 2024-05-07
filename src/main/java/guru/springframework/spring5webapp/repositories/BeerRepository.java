package guru.springframework.spring5webapp.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springframework.spring5webapp.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>{
  
  
  

}
