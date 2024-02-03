package com.javacosmos.springweb.webflux;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webflux")
public class WebFluxController {
  @GetMapping("/mono")
  public Mono<String> monoExample() {
    return Mono.just("Hello JavaCosmos! This is a mono endpoint.");
  }

  @GetMapping("/flux")
  public Flux<String> fluxExample() {
    return Flux.just("Hello JavaCosmos!", " This is a", " flux endpoint.");
  }

  @GetMapping("/finite-stream")
  public Flux<String> finiteStreamExample() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(i -> "Update " + (i + 1) + "<br/>")
        .take(3);
  }

  @GetMapping(path = "/infinite-stream")
  public Flux<String> infiniteStreamExample() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(i -> "Update " + (i + 1) + "<br/>");
  }

  @GetMapping(path = "/finite-sse-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> finiteSSEExample() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(i -> "Update " + (i + 1))
        .take(5);
  }

  @GetMapping(path = "/infinite-sse-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> infiniteSSEExample() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(i -> "Update " + (i + 1));
  }
}
