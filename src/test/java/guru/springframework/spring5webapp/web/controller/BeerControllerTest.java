package guru.springframework.spring5webapp.web.controller;

import static org.mockito.ArgumentMatchers.any;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.spring5webapp.service.BeerService;
import guru.springframework.spring5webapp.web.model.BeerDto;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {
  @Autowired
  MockMvc mockMvc;
  @Autowired
  ObjectMapper objectMapper;
  @MockBean
  BeerService beerService;

  @Test
  void testGetBeerById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("api/v1/beer" + "/" + UUID.randomUUID().toString())
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void testHandleDelete() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.delete("api/v1/beer" + "/"+ UUID.randomUUID().toString())
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void testHandlePost() throws Exception {
    BeerDto mockReturn =BeerDto.builder().id(UUID.randomUUID()).build();

    Mockito.when(beerService.create(any(BeerDto.class)))
      .thenReturn(mockReturn);
    BeerDto beerDto = BeerDto.builder().build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer")
      .contentType(MediaType.APPLICATION_JSON)
      .content(beerDtoJson))
      .andExpect(MockMvcResultMatchers.status().isCreated());


  }

  @Test
  void testHandleUpdate() throws Exception {
    UUID id = UUID.randomUUID();

    BeerDto mockReturn = BeerDto.builder().id(id).build();

    Mockito.when(beerService.update(any(UUID.class), any(BeerDto.class)))
      .thenReturn(mockReturn);

    BeerDto beerDto = BeerDto.builder().build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer" + '/' + id.toString())
      .contentType(MediaType.APPLICATION_JSON)
      .content(beerDtoJson))
      .andExpect(MockMvcResultMatchers.status().isNoContent())
      .andExpect(MockMvcResultMatchers.content().string(id.toString()));
  }
}
