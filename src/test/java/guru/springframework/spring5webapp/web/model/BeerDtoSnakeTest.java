package guru.springframework.spring5webapp.web.model;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jdk.javadoc.internal.doclint.Env;

@JsonTest()
public class BeerDtoSnakeTest extends BaseTest{
  ObjectMapper objectMapper;

  BeerDtoSnakeTest(){
    this.objectMapper = new ObjectMapper();
    this.objectMapper.setPropertyNamingStrategy(
      PropertyNamingStrategy.SNAKE_CASE
    );
  }

  @Test
  void testSnake() throws JsonProcessingException{
    BeerDto beerDto = getDto();

    String jsonString = objectMapper.writeValueAsString(beerDto);

    System.out.println(jsonString);
    System.out.println(123);
  }

   
  
}
