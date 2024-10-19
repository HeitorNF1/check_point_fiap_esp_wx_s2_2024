package br.com.fiap.twoespwx.libunclepresser.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    private FileReader fileReader = new FileReader();

    @Test
    public void testReadFile(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.txt");
        Files.write(file, "AAAACCCTTG".getBytes());

        String result = fileReader.readFile(file.toString());
        assertEquals("AAAACCCTTG", result);
    }

    @Test
    public void testReadFileWithSpaces(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.txt");
        Files.write(file, "AAA ACC CTT G".getBytes());

        String result = fileReader.readFile(file.toString());
        assertEquals("AAAACCCTTG", result);
    }

    @Test
    public void testReadFileWithLowerCase(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.txt");
        Files.write(file, "aaaacccttg".getBytes());

        String result = fileReader.readFile(file.toString());
        assertEquals("AAAACCCTTG", result);
    }

    @Test
    public void testReadNonExistentFile() {
        assertThrows(RuntimeException.class, () -> {
            fileReader.readFile("non_existent_file.txt");
        });
    }
}