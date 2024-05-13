package guru.springframework.spring5webapp.web.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.tomcat.jni.Local;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserialize extends StdDeserializer<LocalDate> {
  public LocalDateDeserialize() {
    super(LocalDate.class);
  }

  @Override
  public LocalDate deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException{
    return LocalDate.parse(p.readValueAs(String.class), DateTimeFormatter.BASIC_ISO_DATE);
  }


  
}
