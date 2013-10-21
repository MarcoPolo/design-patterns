package hw8;

public class LeafNumberComponent extends ArithmeticComponent {
  private double value;
  public String toString(){ return "" + this.value; }

  public LeafNumberComponent(double value){
    this.value = value;
  }

  public double evaluate(){
    return this.value;
  }

  protected double doEvaluate(){
    return 0;
  }

}
