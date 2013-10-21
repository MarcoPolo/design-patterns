package hw3;

public class CartPoint extends Magnitude{
    protected double magnitude;

    public CartPoint(double x, double y){
        this.magnitude = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public boolean lessThan(Magnitude m){
        double magnitude = ( (CartPoint) m).magnitude;
        return this.magnitude < magnitude;
    }
}
