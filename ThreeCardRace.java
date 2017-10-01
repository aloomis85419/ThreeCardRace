package cardgames;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Driver for the Three-Card Race game.
 *
 * <P>The three-card race game is a two-player contest (players A and B).
 * The game is played with a standard 52-card deck.
 * Only the color of the cards, red or black, is significant;
 *     ranks do not matter.</P>
 *
 * Play of the game:
 * <OL>
 * <LI>Player A designates a length-three sequence indicating the colors
 *     of three sequential cards (sequence A).</LI>
 * <LI>Player B designates a length-three sequence indicating the colors
 *     of three sequential cards (sequence B).</LI>
 * <LI>The deck is suffled.</LI>
 * <LI>Cards are dealt face up one at a time from the deck
 *     until three sequential cards are revealed whose colors
 *     exactly match a designated sequence (A or B).
 *     The player whose sequence was matched earns a point
 *     ("takes the trick") and all dealt cards are discarded.</LI>
 * <LI>The game continues by repeating the previous step
 *     until the deck is exhausted.</LI>
 * <LI>The player with the highest point total (greatest number of
 *     tricks taken) wins the game.</LI>
 * </OL>
 *
 * @author Dr. Jody Paul
 * @version 1.1 $Id: ThreeCardRace.java 296 2017-03-24 21:30:35Z jody $
 */

public class ThreeCardRace extends GameRunner {
    /** Color constants for this game. */
    public static final Set<String> COLORS = new HashSet<>();
    /** Number of suit colors required for three card race game. */
    public static final int NUM_COLORS = 2;
    /** Length of color sequence. */
    public static final int SEQUENCE_LENGTH = 3;
    /** Number of players in this game. */
    public static final int NUM_PLAYERS = 2;
    static Scanner keyboard;
    static boolean isHuman;
    static ThreeCardRacePlayer player1;
    static ThreeCardRacePlayer player2;



    static {
        for (Suit s : Suit.values()) {
            COLORS.add(s.color());
        }
    }

    /**
     * Construct Three Card Game Runner.
     * Creates one interactive player and one non-interactive player.
     * Uses colors from Suit.
     */
    public ThreeCardRace() {
        this(new ThreeCardRacePlayer("Human", true),
                new ThreeCardRacePlayer("Automaton", false));
    }

    /**
     * Construct Three Card Game Runner.
     * Uses colors from Suit; exits if invalid number of suit colors.
     * @param playerA the first player
     * @param playerB the second player
     */
    public ThreeCardRace(final ThreeCardRacePlayer playerA,
                         final ThreeCardRacePlayer playerB) {
        ThreeCardRace.player1 = playerA;
        ThreeCardRace.player2 = playerB;
    }

    /**
     * Play one game and report results.
     *
     * @param showTrace if true, then the method displays each card dealt
     *                  and identifies tricks as they are taken
     * @return map that associates each player with the number
     *         of tricks taken by that player
     */
    public Map<ThreeCardRacePlayer, Integer> playGame(final boolean showTrace) {
        HashMap<ThreeCardRacePlayer,Integer>playerScore = new HashMap<>(2);
        playerScore.put(player1,0);
        playerScore.put(player2,0);
        Deck deck = new Deck();
        int deckSize = deck.size();

        if(showTrace == true) {
            deck.shuffle();
            deck.deal();

        }

        else {


        }

        //  Verify players.
        //  Create a standard deck.
        //  Get sequences from players.
        //  Shuffle the deck.
        //  Deal entire deck, marking tricks as they are taken,
        //    and displaying trace if specified by parameter.
        // Report results.
        return new HashMap<ThreeCardRacePlayer, Integer>();
    }

    /**
     * Sample driver for Three-Card Race game.
     * Replace as desired.
     * @param args currently ignored
     */
    /**Guillermo hasn't added code above this line.
     *Please remember this is all pre-refactoring*/

    public static void main(final String[] args) {
        //Game Setup
        System.out.println("Three-Card Race [Version: " + version("$Revision: 370 $") + "]");
        List<String> seq1 = new ArrayList<String>(3);
        List<String> seq2 = new ArrayList<String>(3);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to simulate the game or play the game?");
        isHuman = checkPlayerHuman(keyboard.nextLine());
        String player1Name = setName(NUM_PLAYERS-1);
        String player2Name = setName(NUM_PLAYERS);
        if (isHuman == true) {
            player1 = new ThreeCardRacePlayer(player1Name, isHuman);
            player2 = new ThreeCardRacePlayer(player2Name, isHuman);
            System.out.println("Player 1 : " + player1 + " /// " + "Player 2 : " + player2);
            seq1 = playerChooseSeq(player1);
            seq2 = playerChooseSeq(player2);
            boolean checkSeq = ensureDifferentSequences(seq1, seq2);
            if(checkSeq==false) {
                System.out.println("Pick a sequence that is different from the other player's sequence this time");
                seq1 = playerChooseSeq(player1);
                seq2 = playerChooseSeq(player2);
            }
        }
            System.out.println(player1+" chose: "+seq1);
            System.out.println(player2+" chose: "+seq2);
            //Below this line will be code related to actually playing the game
        }

        ThreeCardRace tcrGame = new ThreeCardRace(new ThreeCardRacePlayer(player1Name,isHuman),new ThreeCardRacePlayer(player2Name,isHuman));

        //tcrGame.playGame(true);
    }

    public static String setName(int n){
        String name;
        System.out.println("Player "+n+": Enter Your Name:");
        keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        return name;
    }

    public static boolean checkPlayerHuman(String answer){
        if (answer.equalsIgnoreCase("simulate") ){
            return false;
        }
        else
            isHuman = true;
        return true;
    }

    public static List<String> playerChooseSeq(ThreeCardRacePlayer player){
        List<String> cardSeq = new ArrayList<String>(SEQUENCE_LENGTH);
        System.out.println(player+" please select your desired 3 card sequence from"+
                " either RED or BLACK, ensuring to press enter between selections");
        cardSeq.add(keyboard.nextLine());
        cardSeq.add(keyboard.nextLine());
        cardSeq.add(keyboard.nextLine());
        System.out.println(player+", you chose "+cardSeq+", is this correct?");
        String answer = keyboard.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes") ){
            return cardSeq;
        }else {
            System.out.println("Sorry! Let’s try again, ");
            playerChooseSeq(player);
            return cardSeq;
        }
    }

    public static boolean ensureDifferentSequences(List<String> seq1, List<String> seq2){
        if (seq1.equals(seq2)){
            System.out.println("!!Players cannot choose the same sequence!!");
            return false;
        }
        else{
            return true;
        }
    }
    public void wait(int milliseconds) {
        try {
            wait(milliseconds);
        } catch (Exception e) {
            e.getCause();
        }
    }
}
