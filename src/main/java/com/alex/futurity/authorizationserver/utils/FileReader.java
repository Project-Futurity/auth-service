package com.alex.futurity.authorizationserver.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@UtilityClass
public class FileReader {
    public static String readClasspathFile(String path) {
        try {
            byte[] bytes = new ClassPathResource(path).getInputStream().readAllBytes();
            return new String(bytes);
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("Error loading \"%s\" file from classpath: " + e.getMessage(), path)
            );
        }
    }

    public static String readAbsoluteFile(String path) {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(path));
            return new String(bytes);
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("Error loading \"%s\" file: " + e.getMessage(), path)
            );
        }
    }
}
