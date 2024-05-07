package guru.springframework.spring5webapp.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

  private final Integer maxtotalconnections;
  private final Integer defaultmaxtotalconnections;
  private final Integer connectionrequesttimeout;
  private final Integer sockettimeout;

  BlockingRestTemplateCustomizer(
    @Value("${sfg.maxtotalconnections}") Integer maxtotalconnections,
    @Value("${sfg.defaultmaxtotalconnections}") Integer defaultmaxtotalconnections,
    @Value("${sfg.connectiontimeout}") Integer connectionrequesttimeout,
    @Value("${sfg.sockettimeout}") Integer sockettimeout
  ) {
    this.maxtotalconnections = maxtotalconnections;
    this.defaultmaxtotalconnections = defaultmaxtotalconnections;
    this.connectionrequesttimeout = connectionrequesttimeout;
    this.sockettimeout = sockettimeout;
  }

  public ClientHttpRequestFactory clientHttpRequestFactory() {
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager()
    connectionManager.setMaxTotal(maxtotalconnections);
    connectionManager.setDefaultMaxPerRoute(defaultmaxtotalconnections);

    RequestConfig requestConfig = RequestConfig.custom()
      .setConnectionRequestTimeout(connectionrequesttimeout)
      .setSocketTimeout(sockettimeout)
      .build();

    CloseableHttpClient httpClient = HttpClients.custom()
      .setConnectionManager(connectionManager)
      .setDefaultRequestConfig(requestConfig)
      .build();

    return new HttpComponentsClientHttpRequestFactory(httpClient);

  }


  public void customize(RestTemplate restTemplate) {
    restTemplate.setRequestFactory(this.clientHttpRequestFactory());
  }
  
}
