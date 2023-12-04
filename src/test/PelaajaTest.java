package test;

import kivipaperisakset.Pelaaja;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PelaajaTest {
    static Pelaaja pelaaja;



    @BeforeClass
    public static void init(){
        pelaaja = new Pelaaja();
    }

    @Before
    public void clear(){
        pelaaja.setVoitot(0);
    }

    @Test
    public void testGetVoitto(){
        assertEquals(0, pelaaja.getVoitot());
    }

    @Test
    public void testAddVoitto(){
        pelaaja.addVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    @Test
    public void testAddManyVoitto(){
        for(int i = 0; i < 10; i++){
            pelaaja.addVoitto();
        }
        assertEquals(10, pelaaja.getVoitot());
    }

    @Test
    public void testSetVoitot(){
        pelaaja.setVoitot(100);
        assertEquals(100, pelaaja.getVoitot());
    }

    @Test
    public void testPelaajanValinta(){
        String[] test = new String[100];
        for(int i = 0; i < 100; i++){
            String s = pelaaja.pelaajanValinta();
            assertThat(s, anyOf(is("kivi"), is("paperi"), is("sakset")));
            test[i] = s;
        }
        String[] values = {"kivi", "paperi", "sakset"};
        boolean contains = false;
        int count = 0;
        int[] index = {0, 0, 0};
        while(!contains){
            if(count > 100){
                fail("fail");
            }
            for(int i = 0; i < values.length; i++){
                if(test[count].equals(values[i])){
                    index[i]++;
                }
            }
            if(index[0] > 0 && index[1] > 0 && index[2] >0){
                contains = true;
            }
            count++;
        }

    }




}
