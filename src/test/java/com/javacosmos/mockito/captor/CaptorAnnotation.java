package com.javacosmos.mockito.captor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CaptorAnnotation {
  @Mock
  List<String> mockedList;

  @Captor
  ArgumentCaptor<String> argCaptor;

  @Test
  public void whenUseCaptorAnnotation_thenTheSame() {
    mockedList.add(0, "one");

    // Skip the first argument and capture the second
    Mockito.verify(mockedList).add(anyInt(), argCaptor.capture());

    assertEquals("one", argCaptor.getValue());
  }
}
