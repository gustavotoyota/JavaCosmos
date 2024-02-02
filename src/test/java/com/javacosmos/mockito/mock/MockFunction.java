package com.javacosmos.mockito.mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockFunction {
  @SuppressWarnings("unchecked")
  @Test
  public void mockFunctionTest() {
    List<String> mockList = mock(List.class);

    when(mockList.size()).thenReturn(5);

    assertTrue(mockList.size() == 5);
  }
}
