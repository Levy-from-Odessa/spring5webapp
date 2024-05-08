package guru.springframework.spring5webapp.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
  @NotNull
  private UUID id;
  private Integer version;

  private OffsetDateTime createdDate;
  private OffsetDateTime lastModifiedDate;

  @NotBlank
  private String beerName;
  private BeerStyleEnu beerStyle;

  @Positive
  private Long upc;
  private BigDecimal price;
  private Integer quantityOnHand;

}
