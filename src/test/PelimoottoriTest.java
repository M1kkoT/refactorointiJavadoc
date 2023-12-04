package test;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Pelimoottori;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class PelimoottoriTest {

    private static Pelimoottori moottori;
    private static Pelaaja[] pelaajat;

    @BeforeClass
    public static void init(){
        moottori = new Pelimoottori(3);
        pelaajat = moottori.getPelaajat();
    }

    @Before
    public void clear(){
        moottori.clearStats();
        moottori.setVoittoMaara(3);
        pelaajat[0].setVoitot(0);
        pelaajat[1].setVoitot(0);
    }


    @Test
    public void checkWinnerTest(){
        assertEquals(-1, moottori.checkIfWinner());
        pelaajat[0].setVoitot(10);
        assertEquals(0, moottori.checkIfWinner());
        pelaajat[0].setVoitot(0);
        pelaajat[1].setVoitot(10);
        assertEquals(1, moottori.checkIfWinner());
    }

    @Test
    public void playGameTest(){
        moottori.playGame();
        if(pelaajat[0].getVoitot() < 3 && pelaajat[1].getVoitot() < 3){
            fail("ei tarpeeksi voittoja");
        }
        if(moottori.getPelatutKierrokset() < 3){
            fail("ei voi voittaa alle 3 kierroksella");
        }
    }


}
