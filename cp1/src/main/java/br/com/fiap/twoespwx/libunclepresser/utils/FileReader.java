package br.com.fiap.twoespwx.libunclepresser.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public String readFile(String path) {
        File file = new File(path);
        StringBuilder texto = new StringBuilder();

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String linha = scan.nextLine();
                linha = linha.trim().replaceAll("\\s", "");
                texto.append(linha);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado: " + path, e);
        }

        return texto.toString().toUpperCase();
    }

    public FileReader() {
    }
}