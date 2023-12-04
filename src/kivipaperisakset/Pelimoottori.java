package kivipaperisakset;

/**
 * suorittaa kivi, paperi, sakset peliä
 * @Author Mikko Tanhola
 */
public class Pelimoottori {
    private Pelaaja[] pelaajat; //lista pelaajista
    private int voittoMaara; //määrittää tarvittavan voittojen määrän pelin voittamiseksi

    private int pelatutKierrokset = 0; //pelattujen kierrosten lukumäärä

    private int tasapelit = 0;
    private boolean endGame = false;

    /**
     * konstruktori
     * @param voittoMaara vaadittu määrä voittoja pelin voittamiseksi
     */
    public Pelimoottori(int voittoMaara){
        pelaajat = new Pelaaja[2];
        pelaajat[0] = new Pelaaja();
        pelaajat[1] = new Pelaaja();
        this.voittoMaara = voittoMaara;
    }

    /**
     * kutsu tätä metodia pelataksesi peliä
     * metodi pelaa kierros kerrallaan kivi, paperi, sakset peliä, kunnes toinen pelaaja saavuttaa vaaditun voittomäärän
     */
    public void playGame(){
        KiviPaperiSakset peli = new KiviPaperiSakset(pelaajat);

        while(!endGame){
            int isWinner = checkIfWinner();
            if(isWinner >= 0){
                endGame = true;
                System.out.println(voittoMaara + " VOITTOA - PELI PÄÄTTYY, voittaja on pelaaja " + (isWinner + 1));
                break;
            }

            System.out.println("Erä: " +(pelatutKierrokset + 1)+ " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            boolean tasuri = peli.PlaykiviPaperiSakset();
            if(tasuri){
                tasapelit++;
            }
            pelatutKierrokset++;
        }

    }

    /**
     * katsoo onko joku pelaajista saavuttanut vaaditun määrän voittoja
     * @return -1 jos ei ole, pelaajan indexi pelaajat listassa jos on
     */
    public int checkIfWinner(){
        for(int i = 0; i < pelaajat.length; i++){
            if(pelaajat[i].getVoitot() >= voittoMaara){
                return i;
            }
        }
        return -1;
    }

    /**
     * sets the amount of wins needed for a game win
     * @param i amount of wins
     */
    public void setVoittoMaara(int i){
        this.voittoMaara = i;
    }

    /**
     * method for clearing game's stats
     */
    public void clearStats(){
        this.pelatutKierrokset = 0;
        this.endGame = false;
        this.tasapelit = 0;
    }

    public Pelaaja[] getPelaajat(){
        return pelaajat;
    }

    public int getPelatutKierrokset() {
        return pelatutKierrokset;
    }

    public int getTasapelit() {
        return tasapelit;
    }

}
