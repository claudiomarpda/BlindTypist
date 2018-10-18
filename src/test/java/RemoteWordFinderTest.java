import com.blind.typist.dictionary.RemoteWordFinder;
import org.junit.Test;

import java.io.IOException;

import static com.blind.typist.dictionary.WordClassification.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordFinderTest {

    @Test
    public void go() throws IOException {
        String s = RemoteWordFinder.findClass("nome");
        assertEquals(s, SUBS_MASC.toString());

        s = RemoteWordFinder.findClass("casa");
        assertEquals(s, SUBS_FEM.toString());

        s = RemoteWordFinder.findClass("lar");
        assertEquals(s, SUBS_MASC.toString());

        s = RemoteWordFinder.findClass("carro");
        assertEquals(s, SUBS_MASC.toString());

        s = RemoteWordFinder.findClass("andar");
        assertTrue(s.startsWith(VERB.toString()));

        s = RemoteWordFinder.findClass("bela");
        assertEquals(s, SUBS_FEM.toString());

        s = RemoteWordFinder.findClass("os");
        assertEquals(s, ART_D.toString());

        s = RemoteWordFinder.findClass("forte");
        assertEquals(s, ADJ.toString());

        s = RemoteWordFinder.findClass("entre");
        assertEquals(s, PREP.toString());
    }
}
