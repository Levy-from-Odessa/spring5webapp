package guru.springframework.spring5webapp.web.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
  private UUID id;


  @Version
  private Long version;

  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp createdDate;
  @UpdateTimestamp
  private Timestamp lastModifiedDate;
  private String beerName;
  private BeerStyleEnu beerStyle;

  @Column(unique = true)
  private Long upc;
  private BigDecimal price;

  private Integer quantityOnHand;
  private Integer minOnHand;
  private Integer quantityToBrew; 


  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate myLocalDate;
}
