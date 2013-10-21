package hw8;

import java.util.ArrayList;

public class DivideComponent extends ArithmeticComponent {
  public String toString(){ return "/"; }

  protected double doEvaluate() throws Exception{
    double aggregator = 1;
    ArrayList<ArithmeticComponent> children = this.getChildren();

    //depending if there is one item in the tree will change whether the first item is treated as positive or negative
    if (children.size() == 1){
      aggregator = 1 / children.get(0).evaluate();
    }else if (children.size() > 1){
      aggregator = children.get(0).evaluate();
    }

    for ( int i = 1; i<children.size(); i++){
      aggregator /= children.get(i).evaluate();
    }

    return aggregator;
  }

}
