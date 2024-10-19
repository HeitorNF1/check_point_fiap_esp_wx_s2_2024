package br.com.fiap.twoespwx.libunclepresser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testMainMethod(@TempDir Path tempDir) throws IOException {
        // Prepare input and output files
        Path inputFile = tempDir.resolve("input.txt");
        Path outputFile = tempDir.resolve("output.txt");
        Files.write(inputFile, "AAAACCCTTG".getBytes());

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run main method
        App.main(new String[]{inputFile.toString(), outputFile.toString()});

        // Check if output file was created and contains correct content
        assertTrue(Files.exists(outputFile));
        String outputContent = Files.readString(outputFile);
        assertEquals("A4C3T2G", outputContent);

        // Check console output
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("LIB UNCLE PRESSER - GRUPO BATATA-DOCE"));
        assertTrue(consoleOutput.contains("ARQUIVO DE ENTRADA: " + inputFile));
        assertTrue(consoleOutput.contains("ARQUIVO DE SAÍDA: " + outputFile));
    }
}