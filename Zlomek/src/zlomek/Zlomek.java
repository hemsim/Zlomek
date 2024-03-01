package zlomek;

/**
 * Třída pro práci se zlomky
 *
 * @author :D
 */

public class Zlomek {
    private int citatel;
    private int jmenovatel;

    public int getCitatel() {
        return citatel;
    }

    public void setCitatel(int citatel) {
        this.citatel = citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    public void setJmenovatel(int jmenovatel) {
        if (jmenovatel == 0) {
            throw new ArithmeticException();
        }
        this.jmenovatel = jmenovatel;
    }

    /**
     * Konstruktor vytvori zlomek se zadanou hodnotou citatele a jmenovatele
     * Prazdny konstrutor vytvori zlomek ve tvaru 1/1
     *
     * @param citatel    hodnota citatele
     * @param jmenovatel hodnota jmenovatele
     */
    public Zlomek(int citatel, int jmenovatel) {
        setCitatel(citatel);
        setJmenovatel(jmenovatel);

    }

    public Zlomek() {
        setCitatel(1);
        setJmenovatel(1);
    }

    /**
     * Metoda pro secteni dvou zlomku
     *
     * @param a prvni zlomek
     * @param b druhy zlomek
     * @return vysledny soucet dvou zlomku
     */
    public Zlomek scitani(Zlomek a) {
        Zlomek z = new Zlomek(a.citatel * this.jmenovatel + this.citatel * a.jmenovatel, a.jmenovatel * this.jmenovatel);
        z.kraceni();
        return z;
    }

    public Zlomek odcitani(Zlomek a) {
        Zlomek z = new Zlomek(this.citatel * a.jmenovatel - a.citatel * this.jmenovatel, this.jmenovatel * a.jmenovatel);
        z.kraceni();
        return z;
    }

    public Zlomek nasobeni(Zlomek a) {
        Zlomek z = new Zlomek(a.citatel * this.citatel, a.jmenovatel * this.jmenovatel);
        z.kraceni();
        return z;
    }

    public Zlomek deleni(Zlomek a) {
        Zlomek z = new Zlomek(this.citatel * a.jmenovatel, this.jmenovatel * a.citatel);
        z.kraceni();
        return z;
    }


    public String toString() {
        return citatel + "/" + jmenovatel;
    }


    public void kraceni() {
        int nsd = NSD(citatel, jmenovatel);
        citatel /= nsd;
        jmenovatel /= nsd;
    }

    /**
     * Metoda vypocita nejvetsiho spolecneho delitele dvou celych cisel
     *
     * @param a prvni cislo
     * @param b druhe cislo
     * @return nejvetsi spoledny delitel
     */
    public static int NSD(int a, int b) {
        while (b != 0) {
            int tempA = a;
            a = b;
            b = tempA % b;
        }
        return a;
    }
}