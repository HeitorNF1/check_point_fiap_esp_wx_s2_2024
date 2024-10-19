package br.com.fiap.twoespwx.libunclepresser;

public class RLE {
    public String Encode(String data) {
        StringBuilder palavra = new StringBuilder();
        int times = 1;
        char previous = data.charAt(0);

        for (int i = 1; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c != previous) {
                palavra.append(previous);
                if (times > 1) {
                    palavra.append(times);
                }
                previous = c;
                times = 1;
            } else {
                times++;
            }
        }

        palavra.append(previous);
        if (times > 1) {
            palavra.append(times);
        }

        return palavra.toString();
    }
}