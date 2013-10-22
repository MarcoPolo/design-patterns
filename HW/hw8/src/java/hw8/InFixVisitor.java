package hw8;

import java.util.ArrayList;

public class InFixVisitor extends ArithmeticVisitor {
  private ArithmeticComponent component;

  public void visitArithmeticComponent(ArithmeticComponent c){
    component = c;
  }

  public String toString(){
    try {
      return InFixExpression(component);
    } catch (Exception e){
      return null;
    }
  }

  private String InFixExpression(ArithmeticComponent c) throws Exception{
    if (c.getChildren().size() == 0){
      return ""+c;
    } else if (c.getChildren().size() != 2){
      throw new Exception("Wrong number of children for infix, needs exactly two");
    }else{
      ArrayList<ArithmeticComponent> children = c.getChildren();

      String aggregate = "";

      aggregate += "(";
      aggregate += InFixExpression(children.get(0));
      aggregate += " ";
      aggregate += c;
      aggregate += " ";
      aggregate += InFixExpression(children.get(1));
      aggregate += ")";

      return aggregate;
    }
  }
}
