package br.com.fiap.twoespwx.libunclepresser;

import br.com.fiap.twoespwx.libunclepresser.utils.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.text.DecimalFormat;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
        String inputPath = args.length > 0 ? args[0] : "inputs\\input.txt";
        String outputPath = args.length > 1 ? args[1] : "outputs\\output.txt";

        FileReader fileReader = new FileReader();
        RLE rle = new RLE();

        String inputData = fileReader.readFile(inputPath);
        String compressedData = rle.Encode(inputData);

        Files.write(Paths.get(outputPath), compressedData.getBytes());

        long inputSize = inputData.length();
        long outputSize = compressedData.length();
        Map<Character, Integer> frequencies = contarFrequencias(inputData);

        exibirInterface(inputPath, outputPath, inputSize, outputSize, frequencies);
    }

    private static Map<Character, Integer> contarFrequencias(String dados) {
        Map<Character, Integer> frequencias = new LinkedHashMap<>();
        for (char nucleotideo : Arrays.asList('A', 'C', 'T', 'G')) {
            frequencias.put(nucleotideo, 0);
        }
        for (char c : dados.toCharArray()) {
            if (frequencias.containsKey(c)) {
                frequencias.put(c, frequencias.get(c) + 1);
            }
        }
        return frequencias;
    }

    private static void exibirInterface(String arquivoEntrada, String arquivoSaida, long tamanhoEntrada, long tamanhoSaida, Map<Character, Integer> frequencias) {
        DecimalFormat df = new DecimalFormat("#,###");
        DecimalFormat pf = new DecimalFormat("0.00%");

        System.out.println(" -----------------------------------------------------------");
        System.out.println("|           LIB UNCLE PRESSER - GRUPO BATATA-DOCE           |");
        System.out.println("|-----------------------------------------------------------|");
        System.out.println("|                                                           |");
        System.out.println("| ARQUIVO DE ENTRADA: " + arquivoEntrada);
        System.out.println("| ARQUIVO DE SAÍDA: " + arquivoSaida);
        System.out.println("|                                                           |");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("|                                                           |");
        System.out.println("| TAMANHO DO ARQUIVO DE ENTRADA: " + df.format(tamanhoEntrada / 1024) + "KB");
        System.out.println("|                                                           |");
        System.out.println("| TOTAL DE CARACTERES DE ENTRADA: " + df.format(tamanhoEntrada));
        System.out.println("|                                                           |");
        System.out.println("| FREQUÊNCIAS:                                              |");
        for (Map.Entry<Character, Integer> entry : frequencias.entrySet()) {
            double porcentagem = (double) entry.getValue() / tamanhoEntrada;
            System.out.printf("| %c: %s (%s)                                     |\n", 
                              entry.getKey(), 
                              df.format(entry.getValue()), 
                              pf.format(porcentagem));
        }
        System.out.println("|                                                           |");
        System.out.println("| OPÇÕES:                                                   |");
        System.out.println("|                                                           |");
        System.out.println("| ALGORITMO: Codificação Run-Length (RLE)                   |");
        System.out.println("| CODIFICAÇÃO DE TEXTO: UTF-8                               |");
        double taxaCompressao = ((double) tamanhoSaida / tamanhoEntrada) * 100;
        System.out.printf("| TAXA DE COMPRESSÃO: =~ %.2f%%                              |\n", taxaCompressao);
        System.out.println("|                                                           |");
        System.out.println("| TAMANHO DO ARQUIVO DE SAÍDA: " + df.format(tamanhoSaida) + " BYTES");
        System.out.println("|                                                           |");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("|                                                           |");
        System.out.println("| PONTUAÇÃO: SABE MUITO PAIZAO                              |");
        System.out.println("|                                                           |");
        System.out.println(" -----------------------------------------------------------");
    }
}