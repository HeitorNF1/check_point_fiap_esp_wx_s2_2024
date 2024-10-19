package br.com.fiap.twoespwx.libunclepresser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RLETest {

    private final RLE rle = new RLE();

    @Test
    public void testEncode() {
        assertEquals("A4C3T2G1", rle.Encode("AAAACCCTTG"));
        assertEquals("G2A2C2T2C2", rle.Encode("GGAACCTTCC"));
        assertEquals("G10", rle.Encode("GGGGGGGGGG"));
        assertEquals("T1G8C1", rle.Encode("TGGGGGGGGC"));
        assertEquals("G8C2", rle.Encode("GGGGGGGGCC"));
        assertEquals("G7C3", rle.Encode("GGGGGGGCCC"));
    }

    @Test
    public void testEncodeWithSingleCharacters() {
        assertEquals("A1T1C1G", rle.Encode("ATCG"));
    }

    @Test
    public void testEncodeWithEmptyString() {
        assertEquals("", rle.Encode(""));
    }
}