package hw8;

public class EvaluatedVisitor extends ArithmeticVisitor {
  private ArithmeticComponent component;

  public void visitArithmeticComponent(ArithmeticComponent c){
    component = c;
  }

  public String toString(){
    try {
      return ""+component.evaluate();
    } catch (Exception e){
      return null;
    }
  }
}
