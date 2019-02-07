import java.time.LocalDate;

public abstract class Drank implements Comparable<Drank>{
    private String naam;
    private LocalDate brouwDatum;
    private double prijs;

    public Drank(String naam, LocalDate brouwDatum, double prijs) {
        this.naam = naam;
        this.brouwDatum = brouwDatum;
        this.prijs = prijs;
    }

    public abstract LocalDate bepaalHoudbaarTot();


    public String toString(){
        return this.naam + ": " + this.prijs + " euro per fles" + "\nHoudbaar tot: ";
    };

    public LocalDate getBrouwDatum() {
        return brouwDatum;
    }

    @Override
    public int compareTo(Drank drank) {
        return 0;
    }

    public double getPrijs() {
        return prijs;
    }
}
