package cardgames;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import org.junit.jupiter.api.Test;

/**
 * Sample basic tests for ThreeCardRacePlayer.
 *
 * @author  Dr. Jody Paul
 * @version 1.0 $Id: ThreeCardRacePlayerTest.java 295 2017-03-24 21:26:19Z jody $
 */
public class ThreeCardRacePlayerTest {
    /** Verify name accessor. */
    @Test
    public void nameAccessorTest() {
        ThreeCardRacePlayer player
            = new ThreeCardRacePlayer("Ima", true);
        assertEquals("Ima", player.name());
        player = new ThreeCardRacePlayer("Computer", false);
        assertEquals("Computer", player.name());
    }

    /** Verify interactivity accessor. */
    @Test
    public void interactivityAccessorTest() {
        ThreeCardRacePlayer player
            = new ThreeCardRacePlayer("Ima", true);
        assertEquals(true, player.isInteractive());
        player = new ThreeCardRacePlayer("Computer", false);
        assertEquals(false, player.isInteractive());
    }

    /** Verify behavior of non-interactive player sequence generator. */
    @Test
    public void getSequenceNonInteractiveTest() {
        ThreeCardRacePlayer player
            = new ThreeCardRacePlayer("Computer", false);
        assertEquals(ThreeCardRace.SEQUENCE_LENGTH,
                     player.getSequence(null).size());
        List<String> seq = new ArrayList<String>();
        seq.add("RED");
        seq.add("BLACK");
        seq.add("RED");
        List<String> choice = player.getSequence(seq);
        assertEquals(ThreeCardRace.SEQUENCE_LENGTH, choice.size());
        assertFalse("Invalid choice; identical to opponent",
                    seq.equals(choice));
    }

    /**
     * Verify behavior of interactive player sequence accessor.
     * Requires interactive input.
     */
    @Test
    public void getSequenceInteractiveTest() {
        ThreeCardRacePlayer player
                = new ThreeCardRacePlayer("Human", true);
        assertEquals(ThreeCardRace.SEQUENCE_LENGTH,
                     player.getSequence(null).size());
        List<String> seq = new ArrayList<String>();
        seq.add("RED");
        seq.add("BLACK");
        seq.add("RED");
        List<String> choice = player.getSequence(seq);
        assertEquals(ThreeCardRace.SEQUENCE_LENGTH, choice.size());
        assertFalse("User picked invalid choice; identical to opponent",
                    seq.equals(choice));
    }
}
