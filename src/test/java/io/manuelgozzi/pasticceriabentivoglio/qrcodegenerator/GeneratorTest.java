package io.manuelgozzi.pasticceriabentivoglio.qrcodegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

class GeneratorTest {

    @Test
    void main() {

        Path outputPath = null;
        try {

            Generator.main("https://google.com", "output.png");
            outputPath = Paths.get("output.png");

            Path expectedOutputPath = Paths.get("src/test/resources/sample.png");

            byte[] producedBytes = Files.readAllBytes(outputPath);

            byte[] expectedBytes = Files.readAllBytes(expectedOutputPath);

            Assertions.assertArrayEquals(expectedBytes, producedBytes);
        } catch (Exception e) {

            e.printStackTrace();
            Assertions.fail();
        } finally {

            try {

                Files.deleteIfExists(Objects.requireNonNull(outputPath));
            } catch (Exception ignore) {}
        }
    }
}