package kivipaperisakset;

/**
 * Luokka pelaamaan yhden kierroksen kivi, sakset paperia
 */
public class KiviPaperiSakset {

    private Pelaaja[] pelaajat;


    public KiviPaperiSakset(Pelaaja[] pelaajat){
        this.pelaajat = pelaajat;
    }

    /**
     * hoitaa yhden kierroksen tulostukset ja pelaajien pelaamisen
     * @Return boolean true jos tasapeli, false jos ei
     */
    public boolean PlaykiviPaperiSakset(){
        System.out.println("Pelaaja 1:llä koossa " + pelaajat[0].getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2:lla koossa " + pelaajat[1].getVoitot() + " voittoa.");


        String p1 = pelaajat[0].pelaajanValinta();
        String p2 = pelaajat[1].pelaajanValinta();

        System.out.println("Pelaaja 1: " + p1);
        System.out.println("Pelaaja 2: " + p2);

        return kumpiVoittaa(p1, p2);
    }

    /**
     * katsoo kumpi pelaajista voittaa kierroksen
     * @param pelaaja1 pelaajan 1 pelaama käsi
     * @param pelaaja2 pejaajan 2 pelaama käsi
     */
    public boolean kumpiVoittaa(String pelaaja1, String pelaaja2){
        boolean tasuri = false;
        if(pelaaja1.equals(pelaaja2)){
            tasuri = true;
            System.out.println("\nTasapeli \n");
        }
        if(pelaaja1.equals("kivi")){
            if(pelaaja2.equals("sakset")){
                addVoitto(0);
            }
            if(pelaaja2.equals("paperi")){
                addVoitto(1);
            }
        }
        if(pelaaja1.equals("paperi")){
            if(pelaaja2.equals("kivi")){
                addVoitto(0);
            }
            if(pelaaja2.equals("sakset")){
                addVoitto(1);
            }
        }
        if(pelaaja1.equals("sakset")){
            if(pelaaja2.equals("paperi")){
                addVoitto(0);
            }
            if(pelaaja2.equals("kivi")){
                addVoitto(1);
            }
        }
        return tasuri;
    }

    /**
     * lisää voiton pelaajalle ja tulostaa voittajan
     * @param pelaaja pelaaja joka voitti kierroksen
     */
    public void addVoitto(int pelaaja){
        System.out.println("\npelaaja " + (pelaaja + 1) + " voittaa\n");
        pelaajat[pelaaja].addVoitto();
    }
}
