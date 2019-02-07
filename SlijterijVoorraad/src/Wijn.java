import java.time.LocalDate;

public class Wijn extends Drank {
    private boolean bewaarWijn;


    public Wijn(String naam, LocalDate brouwDatum, double prijs, boolean bewaarWijn) {
        super(naam, brouwDatum, prijs);
        this.bewaarWijn = bewaarWijn;
    }

    @Override
    public LocalDate bepaalHoudbaarTot() {
        LocalDate houdbaarTot;
        houdbaarTot = super.getBrouwDatum();
        if(super.getPrijs() < 35){
            if(this.bewaarWijn){
                houdbaarTot = houdbaarTot.plusYears(10);
            }else{
                houdbaarTot = houdbaarTot.plusYears(2);
            }

        }else if(super.getPrijs() >= 35){
            if(bewaarWijn){
                houdbaarTot = houdbaarTot.plusYears(100);
            }else{
                houdbaarTot = houdbaarTot.plusYears(10);
            }
        }

        return houdbaarTot;
    }

    @Override
    public String toString() {
        String x = "";
        if(this.bewaarWijn){
            x = "Ja";
        }else {
            x = "Nee";
        }


        return super.toString() + bepaalHoudbaarTot() + "\nBewaarwijn: " + x;


    }
}