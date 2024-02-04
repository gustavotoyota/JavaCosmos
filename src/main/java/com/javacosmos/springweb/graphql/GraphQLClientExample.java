package com.javacosmos.springweb.graphql;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GraphQLClientExample implements ApplicationListener<ApplicationReadyEvent>, Ordered {
  private WebClient webClient;
  private HttpGraphQlClient graphQlClient;

  public GraphQLClientExample(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("http://localhost:8080/graphql").build();
    this.graphQlClient = HttpGraphQlClient.create(webClient);
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    graphQlClient.document("query { carById(id: \"car-1\") { id model year manufacturer { id name country } } }")
        .execute()
        .subscribe(System.out::println);
  }

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
