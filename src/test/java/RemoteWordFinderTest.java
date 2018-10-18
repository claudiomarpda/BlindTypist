import com.blind.typist.dictionary.RemoteWordFinder;
import org.junit.Test;

import java.io.IOException;

import static com.blind.typist.dictionary.WordClassification.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoteWordFinderTest {

    private RemoteWordFinder finder = new RemoteWordFinder();

    @Test
    public void go() throws IOException {
        String s = finder.findClass("nome");
        assertEquals(s, SUBS_MASC.toString());

        s = finder.findClass("casa");
        assertEquals(s, SUBS_FEM.toString());

        s = finder.findClass("lar");
        assertEquals(s, SUBS_MASC.toString());

        s = finder.findClass("carro");
        assertEquals(s, SUBS_MASC.toString());

        s = finder.findClass("andar");
        assertTrue(s.startsWith(VERB.toString()));

        s = finder.findClass("bela");
        assertEquals(s, SUBS_FEM.toString());

        s = finder.findClass("os");
        assertEquals(s, ART_D.toString());

        s = finder.findClass("forte");
        assertEquals(s, ADJ.toString());

        s = finder.findClass("entre");
        assertEquals(s, PREP.toString());
    }
}
