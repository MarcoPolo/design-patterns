package hw8;

public class AdditionComponent extends ArithmeticComponent {
  public String toString(){ return "+"; }

  protected double doEvaluate() throws Exception{
    double aggregator = 0;
    for ( ArithmeticComponent child : this.getChildren()){
      aggregator += child.evaluate();
    }
    return aggregator;
  }

}
