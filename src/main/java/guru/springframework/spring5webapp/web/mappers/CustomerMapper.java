package guru.springframework.spring5webapp.web.mappers;

import guru.springframework.spring5webapp.domain.Customer;
import guru.springframework.spring5webapp.web.model.CustomerDto;

public interface CustomerMapper {
  Customer customerDtoToCustomer(CustomerDto customerDto);
  CustomerDto customerToCustomerDto(Customer customer);
  
}
