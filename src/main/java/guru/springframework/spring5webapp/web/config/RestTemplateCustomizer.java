package guru.springframework.spring5webapp.web.config;

import org.springframework.web.client.RestTemplate;

@FunctionalInterface
public interface RestTemplateCustomizer {
  void customize(RestTemplate restTemplate);
  
}
