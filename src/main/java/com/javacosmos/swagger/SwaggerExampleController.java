package com.javacosmos.swagger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/swagger")
public class SwaggerExampleController {
  @PostMapping("/example")
  @Operation(description = "Swagger @Operation example")
  @Tag(name = "Swagger @Tag 1 example", description = "Swagger @Tag 1 description")
  @Tag(name = "Swagger @Tag 2 example", description = "Swagger @Tag 2 description")
  @ApiResponse(responseCode = "200", description = "Swagger @ApiResponse 200 example")
  @ApiResponse(responseCode = "404", description = "Swagger @ApiResponse 404 example")
  public String example(
      @Parameter(description = "Swagger @Parameter example") String param,
      @RequestBody(description = "Swagger @RequestBody example") String body) {
    return "Swagger example";
  }
}
