package guru.springframework.spring5webapp.web.model;

import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@JsonTest
class BeerDtoTest extends BaseTest{
  ObjectMapper objectMapper;
  BeerDtoTest(){
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testSerializeDto() throws JsonProcessingException{
    BeerDto beerDto = getDto();

    String jsonString = objectMapper.writeValueAsString(beerDto);

    System.out.println(jsonString);
  }

  @Test
  void testDeserialize() throws IOException{
    String json = "{\"beerId\":\"6b9b0a01-5689-4562-8fb9-35fdcdb544aa\",\"version\":null,\"createdDate\":null,\"lastModifiedDate\":null,\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":123456789012,\"price\":12.99,\"quantityOnHand\":null,\"minOnHand\":null,\"quantityToBrew\":null, \"myLocalDate\":20240513}";
    objectMapper.registerModule(new JavaTimeModule());

    BeerDto dto = objectMapper.readValue(json, BeerDto.class);

    System.out.println(dto);
  }



}
