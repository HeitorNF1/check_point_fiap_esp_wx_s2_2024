# **COMPILADOR DE DADOS - Relatório de Compilação de Dados Gênicos**

**Grupo:** Gabriel Doms - RM 98630 // Gabriel Toledo - RM 551654 // HEITOR NOBRE - RM 551539 // YURI MONTEIRO - RM 550952 
**Data:** 15/10/2024  
**Disciplina:** DOMAIN DRIVER DESING - JAVA - FIAP

---

## **1. Introdução**

Este projeto tem como objetivo desenvolver um software para **compressão de dados gênicos** utilizando o algoritmo **Run-Length Encoding (RLE)**. O sistema deve ler um arquivo de entrada contendo cadeias de nucleotídeos (A, C, T, G) e gerar um arquivo comprimido, reduzindo o espaço ocupado sem perda de informações. A compressão é essencial em bioinformática para armazenar e transmitir dados de forma eficiente.

---

## **2. Estrutura do Projeto**

O projeto foi organizado de forma modular, garantindo **separação de responsabilidades** e **facilidade de manutenção**.

### **2.1 App.java**

**Função:**  
É o **ponto de entrada** do programa e controla todo o fluxo de execução. Ele recebe os caminhos dos arquivos de entrada e saída como parâmetros e chama as classes auxiliares.

**Responsabilidades:**

- Verificar **erros nos argumentos** da linha de comando.
- Chamar o **algoritmo de compressão RLE**.
- Exibir um **relatório com estatísticas**, como:
  - Frequências dos nucleotídeos.
  - Tamanho dos arquivos.
  - Taxa de compressão.

---

### **2.2 RLE.java**

**Função:**  
Contém a **lógica de compressão** utilizando o algoritmo **RLE**. Esse algoritmo substitui sequências repetidas por uma única letra e o número de repetições.

**Responsabilidades:**

- **Receber a sequência** de nucleotídeos e realizar a compressão.
- Retornar a **sequência comprimida**.

**Exemplo de funcionamento:**

- Entrada: `AAAACCCGGG`
- Saída: `A4C3G3`

---

### **2.3 FileReader.java**

**Função:**  
É responsável por **ler e gravar arquivos**. Essa classe lida com a entrada e saída de dados, tratando erros que possam ocorrer.

**Responsabilidades:**

- **Ler o arquivo de entrada** como string.
- **Gravar a saída comprimida** em um novo arquivo.
- **Tratar erros de I/O**.

---

## **3. Fluxo de Execução**

1. O programa é executado via linha de comando:
   ```bash
   java -jar libunclepresser.jar inputs/INPUT1.TXT outputs/OUTPUT1.TXT
   ```
2. O arquivo **INPUT1.TXT** é lido e convertido para uma string.
3. A sequência é comprimida usando o algoritmo **RLE**.
4. O resultado é gravado em **OUTPUT1.TXT**.
5. As **estatísticas e a taxa de compressão** são exibidas.

---

## **4. Tratamento de Erros e Testes**

### **Tratamento de Erros**

O programa verifica:

- **Ausência de argumentos** na linha de comando.
- **Erros na leitura e gravação** dos arquivos.
- Exibe mensagens de erro amigáveis e orientações para o usuário.

### **Testes Automatizados**

Foram implementados **testes unitários** para validar o algoritmo RLE em diferentes cenários.

Exemplo de teste:

```java
@Test
public void testCompressRLE() {
    assertEquals("A4C3T2G1", App.compressRLE("AAAACCCTTG"));
    assertEquals("G2A2C2T2C2", App.compressRLE("GGAACCTTCC"));
    assertEquals("G10", App.compressRLE("GGGGGGGGGG"));
}
```

---

## **5. Relatório de Execução**

O programa exibe um relatório com as estatísticas da compressão, conforme exemplo abaixo:

```
 -----------------------------------------------------------
|           LIB UNCLE PRESSER - GRUPO BATATA-DOCE           |
 -----------------------------------------------------------
| INPUT  FILENAME: INPUT1.TXT                               |
| OUTPUT FILENAME: OUTPUT1.TXT                              |
 -----------------------------------------------------------
| INPUT FILE SIZE: 1024 BYTES                               |
| TOTAL INPUT CHARACTERS: 1024                              |
| FREQUENCIES:                                              |
| A: 25.00%, C: 50.00%, T: 12.50%, G: 12.50%                |
 -----------------------------------------------------------
| ALGORITHM: Run-Length Encoding (RLE)                      |
| TEXT-CODIFICATION: UTF-8                                  |
| COMPRESSION RATE: 70%                                     |
| OUTPUT FILE SIZE: 314 BYTES                               |
 -----------------------------------------------------------
| SCORE: WELL-DONE                                          |
 -----------------------------------------------------------
```

---

## **6. Conclusão**

O projeto foi implementado com sucesso, atendendo a todos os requisitos propostos. A compressão realizada pelo algoritmo **RLE** demonstrou ser eficiente na redução do tamanho dos arquivos, preservando os dados originais. Além disso, os **testes automatizados** garantem a confiabilidade do sistema.

---

## **7. Dificuldades e Aprendizados**

Durante o desenvolvimento, enfrentamos desafios como:

- **Leitura eficiente de arquivos grandes**.
- **Tratamento adequado de erros** para evitar falhas durante a execução.
- **Criação de uma interface textual clara**.

O projeto reforçou a importância de **trabalhar modularmente** e de seguir boas práticas de desenvolvimento.

---

## **8. Pontualidade**

Este projeto foi entregue **dentro do prazo** estabelecido (18/10/2024), atendendo a todos os critérios propostos.

---

## **9. Referências**

https://www.dio.me/articles/lendo-conteudo-de-arquivo-txt-com-java <br>
https://www.devmedia.com.br/a-classe-stringbuilder-em-java/25609 <br>
https://pt.stackoverflow.com/questions/203452/como-excluir-espaços-em-branco <br>
https://www.guj.com.br/t/como-ver-se-um-char-esta-null/89634) <br>
https://www.dio.me/articles/lendo-conteudo-de-arquivo-txt-com-java <br>
https://www.devmedia.com.br/a-classe-stringbuilder-em-java/25609 <br>
https://pt.stackoverflow.com/questions/203452/como-excluir-espaços-em-branco <br>
https://www.guj.com.br/t/como-ver-se-um-char-esta-null/89634 <br>
https://www.devmedia.com.br/criando-e-gravando-dados-em-txt-com-java/23060 <br>
https://www.youtube.com/watch?v=xkbmxZSWmWs <br>
https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html <br>
https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#readAllBytes-java.nio.file.Path- <br>
https://www.geeksforgeeks.org/run-length-encoding/ <br>
