package kivipaperisakset;

/**
 * Pelaa kivi, paperi ja sakset peliä kahdella pelaajalla
 * Peli arpoo, mitä pelaajat pelaavat ja tulostaa tietoja konsoliin
 * @author Ira Dook, Mikko Tanhola
 */
public class Peli {

    public static void main(String args[]) {
        Pelimoottori moottori = new Pelimoottori(3);
        moottori.playGame();

    }
}
