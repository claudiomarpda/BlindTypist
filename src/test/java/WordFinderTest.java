import com.blind.typist.WordFinder;
import org.junit.Test;

import java.io.IOException;

import static com.blind.typist.WordClassification.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordFinderTest {

    @Test
    public void go() throws IOException {
        String s = WordFinder.findClass("nome");
        assertEquals(s, SUBS_MASC.toString());

        s = WordFinder.findClass("casa");
        assertEquals(s, SUBS_FEM.toString());

        s = WordFinder.findClass("lar");
        assertEquals(s, SUBS_MASC.toString());

        s = WordFinder.findClass("carro");
        assertEquals(s, SUBS_MASC.toString());

        s = WordFinder.findClass("andar");
        assertTrue(s.startsWith(VERB.toString()));

        s = WordFinder.findClass("bela");
        assertEquals(s, SUBS_FEM.toString());

        s = WordFinder.findClass("os");
        assertEquals(s, ART_D.toString());

        s = WordFinder.findClass("forte");
        assertEquals(s, ADJ.toString());

        s = WordFinder.findClass("entre");
        assertEquals(s, PREP.toString());
    }
}
