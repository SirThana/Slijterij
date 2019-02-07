import java.time.LocalDate;

public class Bier extends Drank {
    public double alcoholPercentage;
    public boolean gistInFles;


    public Bier(String naam, LocalDate brouwDatum
            , double prijs,double alcoholPercentage,boolean gistInFles) {
        super(naam, brouwDatum, prijs);
        this.alcoholPercentage = alcoholPercentage;
        if(!this.gistInFles || !this.gistInFles){
            this.gistInFles = false;
        }
        this.gistInFles = gistInFles;
    }


    public Bier(String naam, LocalDate brouwDatum, double prijs) {
        super(naam, brouwDatum, prijs);
    }


    @Override
    public LocalDate bepaalHoudbaarTot() {
        LocalDate houdbaarTot;
        houdbaarTot = super.getBrouwDatum();

        if(this.gistInFles){
            houdbaarTot = houdbaarTot.plusYears(16);
        }else if(!this.gistInFles){
            if(this.alcoholPercentage <= 5){
                houdbaarTot.plusMonths(9);
            }else if(this.alcoholPercentage > 5){
                houdbaarTot = houdbaarTot.plusYears(2);
                houdbaarTot = houdbaarTot.plusMonths(6);
            }
        }


        return houdbaarTot;
    }

    @Override
    public String toString() {
        String x = "";
        if(this.gistInFles == true){
            x = "Ja";
        }else{
            x = "Nee";
        }

        return super.toString() + this.bepaalHoudbaarTot()
                + "\nAlcoholpercentage: " + this.alcoholPercentage + "%"
                + "\nGist in fles: " + x;
    }
}
