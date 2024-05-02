package guru.springframework.spring5webapp.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.spring5webapp.service.V2.BeerServiceV2;
import guru.springframework.spring5webapp.web.model.v2.BeerDtoV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

  private final BeerServiceV2 beerService;

  public BeerControllerV2(BeerServiceV2 beerService) {
    this.beerService = beerService;
  }
  
  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDtoV2> getBeerById(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getId(beerId), HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<BeerDtoV2> handlePost(@RequestBody BeerDtoV2 beerDtoV2) {
    BeerDtoV2 created = beerService.create(beerDtoV2);

    HttpHeaders headers = new HttpHeaders();
    // todo: add hostname to url
    headers.add("Location", "/api/v1/beer/" + created.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDtoV2) {
    beerService.update(beerId, beerDtoV2);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable("beerId") UUID beerId) {
    beerService.delete(beerId);
  }
  
}
