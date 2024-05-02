package guru.springframework.spring5webapp.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.spring5webapp.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService{

  @Override
  public CustomerDto getById(UUID customerId) {
    return CustomerDto.builder().id(UUID.randomUUID())
        .name("John Doe")
        .build();
  }
  
  
}
