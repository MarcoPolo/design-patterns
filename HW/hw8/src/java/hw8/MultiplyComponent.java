package hw8;

public class MultiplyComponent extends ArithmeticComponent {
  public String toString(){ return "*"; }

  protected double doEvaluate() throws Exception{
    double aggregator = 1;
    for ( ArithmeticComponent child : this.getChildren()){
      aggregator *= child.evaluate();
    }

    return aggregator;
  }

}
