package test;

import kivipaperisakset.KiviPaperiSakset;
import kivipaperisakset.Pelaaja;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

public class KiviPaperiSaksetTest {
    static Pelaaja[] pelaajat = new Pelaaja[2];
    static KiviPaperiSakset peli;



    @BeforeClass
    public static void init(){
        pelaajat[0] = new Pelaaja();
        pelaajat[1] = new Pelaaja();
        peli = new KiviPaperiSakset(pelaajat);
    }

    @Before
    public void clear(){
        for(Pelaaja p: pelaajat){
            p.setVoitot(0);
        }
    }

    @Test
    public void addVoittoTest() {
        peli.addVoitto(0);
        assertEquals(1, pelaajat[0].getVoitot());
        peli.addVoitto(1);
        peli.addVoitto(1);
        assertEquals(2, pelaajat[1].getVoitot());
    }

    @Test
    public void kumpiVoittaaTest(){
        boolean tasuri = peli.kumpiVoittaa("sakset", "sakset");
        assertTrue(tasuri);
        assertEquals(0, pelaajat[0].getVoitot());
        assertEquals(0, pelaajat[1].getVoitot());
        boolean eiTasuri = peli.kumpiVoittaa("sakset", "kivi");
        assertFalse(eiTasuri);
        assertEquals(0, pelaajat[0].getVoitot());
        assertEquals(1, pelaajat[1].getVoitot());
    }

    @Test
    public void kumpiVoittaaManyVoittoTest(){
        for(int i = 0; i < 20; i++){
            peli.kumpiVoittaa("paperi", "kivi");
        }
        assertEquals(20, pelaajat[0].getVoitot());
        assertEquals(0, pelaajat[1].getVoitot());
    }

    @Test
    public void playKiviPaperiSaksetTest(){
        int tasuriCounter = 0;
        for(int i = 0; i < 100; i++){
            boolean test = peli.PlaykiviPaperiSakset();
            if(test){
                tasuriCounter++;
            }
        }

       if(tasuriCounter == 0){
           fail("ei tasapelejä 100 yrityksellä");
       }
    }
}
