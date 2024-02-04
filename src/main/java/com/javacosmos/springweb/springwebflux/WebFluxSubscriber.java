package com.javacosmos.springweb.springwebflux;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebFluxSubscriber implements ApplicationListener<ApplicationReadyEvent>, Ordered {
  private WebClient webClient;

  public WebFluxSubscriber(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    ParameterizedTypeReference<ServerSentEvent<String>> type = new ParameterizedTypeReference<ServerSentEvent<String>>() {
    };

    webClient.get().uri("/webflux/finite-sse-stream")
        .retrieve()
        .bodyToFlux(type)
        .subscribe(sse -> System.out.println("Received WebFlux SSE: " + sse.data()));
  }

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
