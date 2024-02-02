package com.javacosmos.mockito.captor;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CaptorFunction {
  @SuppressWarnings("unchecked")
  @Test
  public void test() {
    List<String> mockList = mock(List.class);

    ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

    mockList.add(0, "one");

    // Skip the first argument and capture the second
    verify(mockList).add(anyInt(), arg.capture());

    // prints "one"
    System.out.println(arg.getValue());
  }
}
