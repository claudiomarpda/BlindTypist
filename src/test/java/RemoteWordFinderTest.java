import com.blind.typist.dictionary.RemoteWordFinder;
import com.blind.typist.dictionary.Word;
import org.junit.Test;

import java.io.IOException;

import static com.blind.typist.dictionary.Classification.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoteWordFinderTest {

    private RemoteWordFinder finder = new RemoteWordFinder();

    @Test
    public void go() throws IOException {
        Word w = finder.findWord("nome");
        assertEquals(w.getClassification(), SUBS_MASC.toString());

        w = finder.findWord("casa");
        assertEquals(w.getClassification(), SUBS_FEM.toString());

        w = finder.findWord("lar");
        assertEquals(w.getClassification(), SUBS_MASC.toString());

        w = finder.findWord("carro");
        assertEquals(w.getClassification(), SUBS_MASC.toString());

        w = finder.findWord("andar");
        assertTrue(w.getClassification().startsWith(VERB.toString()));

        w = finder.findWord("bela");
        assertEquals(w.getClassification(), SUBS_FEM.toString());

        w = finder.findWord("os");
        assertEquals(w.getClassification(), ART_D.toString());

        w = finder.findWord("forte");
        assertEquals(w.getClassification(), ADJ.toString());

        w = finder.findWord("entre");
        assertEquals(w.getClassification(), PREP.toString());
    }
}
