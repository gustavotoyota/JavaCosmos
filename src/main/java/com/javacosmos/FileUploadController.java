package com.javacosmos;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/files")
public class FileUploadController {
  private static final String UPLOAD_DIR = "src/main/resources/uploads";

  // List uploaded files
  @GetMapping("")
  public String listUploadedFiles(Model model) throws IOException {
    List<String> fileNames = Files.walk(Paths.get(UPLOAD_DIR))
        .filter(Files::isRegularFile)
        .map(path -> MvcUriComponentsBuilder
            .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString()).build()
            .toString())
        .collect(Collectors.toList());

    model.addAttribute("fileNames", fileNames);
    model.addAttribute("message", "Welcome to the File Upload and Download Demo!");

    return "uploadForm";
  }

  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    if (file.isEmpty()) {
      redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
      return "redirect:/files";
    }

    try {
      // Get the file and save it
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
      Files.write(path, bytes);

      redirectAttributes.addFlashAttribute("message", "File upload successful: " + file.getOriginalFilename());
    } catch (FileAlreadyExistsException e) {
      redirectAttributes.addFlashAttribute("message", "File already exists: " + file.getOriginalFilename());
    } catch (IOException e) {
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("message", "File upload failed: " + file.getOriginalFilename());
    }

    return "redirect:/files";
  }

  // Download file
  @GetMapping("/download/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws IOException {
    Path filePath = Paths.get(UPLOAD_DIR).resolve(filename);
    Resource file = new UrlResource(filePath.toUri());

    if (file.exists()) {
      return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
          .contentType(MediaType.APPLICATION_OCTET_STREAM != null ? MediaType.APPLICATION_OCTET_STREAM
              : MediaType.APPLICATION_OCTET_STREAM)
          .body(file);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
