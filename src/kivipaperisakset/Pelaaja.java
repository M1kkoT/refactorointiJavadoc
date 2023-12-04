
package kivipaperisakset;


/**
 * Luokka KiviPaperiSakset pelin pelaajalle
 * Luokka valitsee pelaajalle kivi , paperi tai sakset ja pitää kirjaa pelaajan voitoista
 *
 * @author Ira Dook, Mikko Tanhola
 */
public class Pelaaja {

    private int voitot = 0;      // Voittojen lukumäärä

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public String pelaajanValinta() {
        String[] valinnat = {"kivi", "paperi", "sakset"};
        int c = (int) (Math.random() * 3);
        return valinnat[c];
    }

    /**
     * lisää voittoihin 1
     */
    public void addVoitto() {
        voitot++;
    }

    /**
     * Asettaa voitot arvoon n
     * @param n int
     */
    public void setVoitot(int n){
        voitot = n;
    }

    /**
     * palauttaa voitot
     * @return voittojen määrä
     */
    public int getVoitot() {
        return (voitot);
    }
}
