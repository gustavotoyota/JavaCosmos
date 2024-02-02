package com.javacosmos.mockito.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockAnnotation {
  @Mock
  List<String> mockList;

  @Test
  public void test() {
    when(mockList.get(0)).thenReturn("JournalDev");

    assertEquals("JournalDev", mockList.get(0));
  }
}
