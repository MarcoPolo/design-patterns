package hw8;

public class LispVisitor extends ArithmeticVisitor {
  private ArithmeticComponent component;

  public void visitArithmeticComponent(ArithmeticComponent c){
    component = c;
    
  }

  public String toString(){
    return lispExpression(component);
  }

  private String lispExpression(ArithmeticComponent c){
    if (c.getChildren().size() == 0){
      return ""+c;
    }else{
      String childrenString = "";
      for (ArithmeticComponent child : c.getChildren()){
        childrenString += (" " + lispExpression(child));
      }

      return "("+c+childrenString+")";
    }
  }
}
