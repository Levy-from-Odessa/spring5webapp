package guru.springframework.spring5webapp.service;

import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import guru.springframework.spring5webapp.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

  @Override
  public CustomerDto getById(UUID customerId) {
    return CustomerDto.builder().id(UUID.randomUUID())
        .name("John Doeasdsasdas")
        .build();
  }
  
  @Override
  public CustomerDto create(CustomerDto customerDto) {
    return CustomerDto.builder().id(UUID.randomUUID())
      .build();
  }

  @Override
  public CustomerDto update(UUID id, CustomerDto customerDto) {
    log.info("Updating a customer...");
    return CustomerDto.builder().id(UUID.randomUUID())
      .build();
  }

  @Override
  public CustomerDto delete(UUID id) {
    log.info("Deleting a customer...");
    return CustomerDto.builder().id(UUID.randomUUID())
      .build();
  }
  
}
