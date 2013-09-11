package hw3;

public class Currency extends Magnitude{
    protected double money;

    public Currency(double money){
        this.money = money;
    }

    public boolean lessThan(Magnitude m){
        double money = ( (Currency) m).money;
        return this.money < money;
    }
}
