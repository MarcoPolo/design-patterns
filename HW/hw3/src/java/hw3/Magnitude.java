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
