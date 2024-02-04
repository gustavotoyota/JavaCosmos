package com.javacosmos.lombok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import lombok.Cleanup;

public class CleanupAnnotation {
  public void demonstration() throws FileNotFoundException, IOException {
    @Cleanup
    InputStream in = new FileInputStream("in.txt");
    @Cleanup
    OutputStream out = new FileOutputStream("out.txt");

    byte[] b = new byte[10000];

    while (true) {
      int r = in.read(b);
      if (r == -1)
        break;
      out.write(b, 0, r);
    }
  }
}

/*
 * Compare with the following code:
 * 
 * 
 * public class CleanupExample {
 * public void demonstration() throws FileNotFoundException, IOException {
 * InputStream in = new FileInputStream("in.txt");
 * try {
 * OutputStream out = new FileOutputStream("out.txt");
 * try {
 * byte[] b = new byte[10000];
 * while (true) {
 * int r = in.read(b);
 * if (r == -1) break;
 * out.write(b, 0, r);
 * }
 * } finally {
 * if (out != null) {
 * out.close();
 * }
 * }
 * } finally {
 * if (in != null) {
 * in.close();
 * }
 * }
 * }
 */