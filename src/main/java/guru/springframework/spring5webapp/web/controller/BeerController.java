package guru.springframework.spring5webapp.web.controller;

import java.util.UUID;

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



@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }
  
  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getId(beerId), HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {
    BeerDto created = beerService.create(beerDto);

    HttpHeaders headers = new HttpHeaders();
    // todo: add hostname to url
    headers.add("Location", "/api/v1/beer/" + created.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<String> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
    BeerDto updatedBeer = beerService.update(beerId, beerDto);

    return new ResponseEntity<String>(updatedBeer.getId().toString(), HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable("beerId") UUID beerId) {
    // beerService.delete(beerId);
  }
  
}
