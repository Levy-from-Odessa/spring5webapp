package guru.springframework.spring5webapp.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Beer;
import guru.springframework.spring5webapp.repositories.BeerRepository;
import guru.springframework.spring5webapp.web.model.BeerStyleEnu;

@Component
public class BeerLoader implements CommandLineRunner{
  private final BeerRepository beerRepository;

  BeerLoader(BeerRepository beerRepository){
    this.beerRepository = beerRepository;
  }

  
  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if(beerRepository.count() == 0){
      beerRepository.save(Beer.builder()
        .beerName("Mango Bobs")
        .beerStyle(BeerStyleEnu.GOSE)
        .upc(337010000001L)
        .quantityToBrew(300)
        .minOnHand(13)
        .price(new BigDecimal("56.66"))
        .build()
      );

      beerRepository.save(Beer.builder()
        .beerName("Galaxy Cat")
        .beerStyle(BeerStyleEnu.IPA)
        .upc(654661L)
        .quantityToBrew(300)
        .minOnHand(13)
        .price(new BigDecimal("100.30"))
        .build()
      );
    }

  }

}
