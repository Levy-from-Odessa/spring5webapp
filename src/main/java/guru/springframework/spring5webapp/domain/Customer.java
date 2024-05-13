package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

  private UUID id;
  private String name;
  
}
