# Spring WebFlux

Spring WebFlux is a reactive programming framework in the Spring ecosystem designed to handle asynchronous and non-blocking communication. It provides an alternative to the traditional Spring MVC framework.

## Comparing Spring WebFlux with traditional Spring MVC

The traditional Servlet approach:

- One thread is responsible for each request (the thread can't be used for anything else until request is finished)
- Many threads waiting to process requests
- Higher memory usage (since each thread needs memory)
- Blocking only freezes one thread
- No mechanisms for handling back pressure

The Spring WebFlux approach:

- Each request can be partially processed by different threads
- Small number of threads
- Lower memory usage due to less threads
- Blocking is more impactful due to less threads
- Back pressure is managed through a cooperative protocol between the producer and the consumer

The main problem with the traditional approach is the tight coupling between threads and requests. In Spring MVC, each thread is exclusively devoted to handling their respective request until its processing is complete. This is not a problem in Spring WebFlux, as while a request waits for a resource, the thread can be used to process other requests.
