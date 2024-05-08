package guru.springframework.spring5webapp.web.controller;

import java.util.UUID;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.spring5webapp.service.BeerService;
import guru.springframework.spring5webapp.web.model.BeerDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class BeerController {

  public static final String BEER_PATH = "api/v1/beer";
  public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }
  @GetMapping(BEER_PATH)
  public ResponseEntity<List<BeerDto>> getBeer() {
    return new ResponseEntity<>(beerService.getAll(), HttpStatus.OK);
  }
  
  @GetMapping(BEER_PATH_ID)
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getId(beerId), HttpStatus.OK);
  }


  @PostMapping(BEER_PATH)
  public ResponseEntity<BeerDto> handlePost(@Valid @RequestBody BeerDto beerDto) {
    BeerDto savedBeer = beerService.create(beerDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

    return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
  }

  @PutMapping(BEER_PATH_ID)
  public ResponseEntity<String> handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
    BeerDto updatedBeer = beerService.update(beerId, beerDto);

    return new ResponseEntity<String>(updatedBeer.getId().toString(), HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(BEER_PATH_ID)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable("beerId") UUID beerId) {
    // beerService.delete(beerId);
  }
  
}
