package cardgames;

import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/*
 ACE("Ace", 1),
    DEUCE("Deuce", 2),
    TREY("Trey", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13);
 */

/**
 * Tests for Card class.
 *
 * @author  Dr. Jody Paul
 * @version 1.2 $Revision: 295 $
 */
public class CardTest {
    /** The Clubs suit. */
    private static final Suit CLUBS = Suit.valueOf("CLUBS");
    /** The Diamonds suit. */
    private static final Suit DIAMONDS = Suit.valueOf("DIAMONDS");
    /** The Hearts suit. */
    private static final Suit HEARTS = Suit.valueOf("HEARTS");
    /** The Spades suit. */
    private static final Suit SPADES = Suit.valueOf("SPADES");
    /** The Seven rank. */
    private static final Rank SEVEN = Rank.valueOf("SEVEN");
    /** The Jack rank. */
    private static final Rank JACK = Rank.valueOf("JACK");
    /** The Queen rank. */
    private static final Rank QUEEN = Rank.valueOf("QUEEN");

    /** Queen of Hearts cardID. */
    private static final int QH_ID
                = (HEARTS.ordinal() * Rank.values().length) + QUEEN.ordinal();

    /** Seven of Clubs cardID. */
    private static final int SC_ID
                = (CLUBS.ordinal() * Rank.values().length) + SEVEN.ordinal();

    /**
     * Verify default card construction and access.
     * Exercises equals and hashCode methods.
     */
    @Test
    public final void defaultCardTest() {
        Card cardDefault = new Card();
        assertNotNull(cardDefault.rank());
        assertNotNull(cardDefault.suit());
        assertEquals(cardDefault, (new Card()));
        assertEquals(cardDefault.hashCode(), (new Card()).hashCode());
    }

    /**
     * Verify Queen of Hearts construction and access.
     * Exercises equals and hashCode methods.
     */
    @Test
    public final void queenOfHeartsTest() {
        Card cardQH = new Card(QUEEN, Card.retrieveSuit(12));
        assertEquals(QUEEN, cardQH.rank());
        assertEquals(HEARTS, cardQH.suit());
        assertEquals(QH_ID, cardQH.cardID());
        assertEquals("Queen of Hearts", cardQH.toString());
        assertEquals(cardQH, (new Card(QH_ID)));
        assertEquals(cardQH.hashCode(), (new Card(QH_ID)).hashCode());
    }

    /**
     * Verify 7 of Clubs construction and access.
     * Exercises equals and hashCode methods.
     */
    @Test
    public final void sevenOfClubsTest() {
        Card card7C = new Card(SEVEN, Card.retrieveSuit(7));
        assertEquals(SEVEN, card7C.rank());
        assertEquals(SC_ID, card7C.cardID());
        assertEquals(CLUBS, card7C.suit());
        assertEquals("Seven of Clubs", card7C.toString());
        assertEquals(card7C, (new Card(SC_ID)));
        assertEquals(card7C.hashCode(), (new Card(SC_ID)).hashCode());
    }

    /**
     * Verify copy construction.
     * Exercises equals and hashCode methods.
     */
    @Test
    public final void copyTest() {
        Card cardDefault = new Card();
        Card copyD = new Card(cardDefault);
        assertEquals(cardDefault, copyD);
        assertEquals(cardDefault.hashCode(), copyD.hashCode());
        Card cardJD = new Card(JACK, Card.retrieveSuit(11));
        Card copyJD = new Card(cardJD);
        assertEquals(cardJD, copyJD);
        assertEquals(cardJD.hashCode(), copyJD.hashCode());
        assertEquals(DIAMONDS, copyJD.suit());
        assertEquals(JACK, copyJD.rank());
    }

    /** Verify behavior of equals in presence of null. */
    @Test
    public final void equalsNullTest() {
        Card card7C = new Card(SEVEN, Card.retrieveSuit(7));
        assertFalse(card7C.equals(null));
    }

    /** Verify behavior of equals with object of different class. */
    @Test
    public final void equalsOtherClassTest() {
        Card card7C = new Card(SEVEN, Card.retrieveSuit(7));
        assertFalse(card7C.equals("Seven of Clubs"));
    }

    /**
     * Enumeration class for the suits of cards.
     * Supports a color() method that retrieves the
     * color string associated with a suit:
     * Clubs = "BLACK", Diamonds = "RED",
     * Hearts = "RED", Spades = "BLACK".
     * @author Dr. Jody Paul
     * @version 1.2 $Id: Suit.java 295 2017-03-24 21:26:19Z jody $
     */
    public static enum Suit {
        CLUBS("Clubs", "BLACK"),
        DIAMONDS("Diamonds", "RED"),
        HEARTS("Hearts", "RED"),
        SPADES("Spades", "BLACK");

        /** The display name of this suit. */
        private String name;

        /** The color of this suit. */
        private String suitColor;

        /** The color red. */
        public static final String RED = "RED";

        /** The color black. */
        public static final String BLACK = "BLACK";

        /**
         * Construct Suit.
         * @param displayName the display name of this suit
         * @param color the color of this suit
         */
        Suit(final String displayName, final String color) {
            this.name = displayName;
            if (color.compareToIgnoreCase(RED) == 0) {
                this.suitColor = RED;
            } else if (color.compareToIgnoreCase(BLACK) == 0) {
                this.suitColor = BLACK;
            } else {
                throw (new IllegalArgumentException("Color must be "
                                                     + BLACK + " or "
                                                     + RED + "(found "
                                                     + color + ")"));
            }
        }

        /**
         * Access the color of this suit.
         * @return the color of this suit
         */
        public String color() {
            return this.suitColor;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
