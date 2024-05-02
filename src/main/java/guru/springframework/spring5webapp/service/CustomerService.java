package guru.springframework.spring5webapp.service;

import java.util.UUID;

import guru.springframework.spring5webapp.web.model.CustomerDto;

public interface CustomerService {
  CustomerDto getById(UUID customerId);
  CustomerDto create(CustomerDto customerDto);
  CustomerDto update(UUID id, CustomerDto customerDto);
  CustomerDto delete(UUID id);
  
} 
