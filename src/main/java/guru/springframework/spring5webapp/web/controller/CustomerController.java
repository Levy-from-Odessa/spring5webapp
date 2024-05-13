package guru.springframework.spring5webapp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.spring5webapp.service.CustomerService;
import guru.springframework.spring5webapp.web.model.CustomerDto;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
  private final CustomerService customerService;

  CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
    return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerDto> handlePost(@Valid @RequestBody CustomerDto CustomerDto) {
    CustomerDto created = customerService.create(CustomerDto);

    HttpHeaders headers = new HttpHeaders();
    // todo: add hostname to url
    headers.add("Location", "/api/v1/Customer/" + created.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{CustomerId}")
  public ResponseEntity<CustomerDto> handleUpdate(@PathVariable("CustomerId") UUID CustomerId, @Valid @RequestBody CustomerDto CustomerDto) {
    customerService.update(CustomerId, CustomerDto);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{CustomerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void handleDelete(@PathVariable("CustomerId") UUID CustomerId) {
    customerService.delete(CustomerId);
  }
  


}
