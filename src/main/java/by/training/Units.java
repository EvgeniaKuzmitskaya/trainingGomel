package by.training;

/**
 * Created by Evgenia on 03.10.2017.
 */
public enum Units {

    KMH(0.278), MPH(0.447), KN(0.514), MS(1.0);

    public final double modifier;

    Units(double modifier){
        this.modifier = modifier;
    }
}
