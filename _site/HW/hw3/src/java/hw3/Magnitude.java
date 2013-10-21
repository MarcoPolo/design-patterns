package hw3;

public abstract class Magnitude {

    public abstract boolean lessThan(Magnitude m);

    public final boolean lessThanEqualTo(Magnitude m){
        return (this.lessThan(m) || this.equalTo(m));
    }

    public final boolean equalTo(Magnitude m){
        return ( !this.lessThan(m) && !m.lessThan(this) );
    }

    public final boolean greaterThan(Magnitude m){
        return (!this.lessThan(m) && this.notEqual(m));
    }

    public final boolean greaterThanEqualTo(Magnitude m){
        return (this.greaterThan(m) || this.equalTo(m));
    }

    public final boolean notEqual(Magnitude m){
        return !this.equalTo(m);
    }

}


---------------------

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

----------------------

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

