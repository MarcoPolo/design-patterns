package hw8;

import java.util.ArrayList;

public abstract class ArithmeticComponent {
  //return the string representing the item at this node
  public abstract String toString();

  public ArrayList<ArithmeticComponent> children = new ArrayList<ArithmeticComponent>();

  //return the evaulated value depending on what the component is.
  //If it's a leaf, it's just the identity function
  //else: it's the specific operation (e.g. + addition) on it's children's.evaluate()
  public double evaluate() throws Exception{
    checkChildrenExists();
    return doEvaluate();
  }

  protected abstract double doEvaluate() throws Exception;

  public ArrayList<ArithmeticComponent> getChildren(){
    return children;
  }

  public void addChild(ArithmeticComponent... children){
    for (ArithmeticComponent child : children){
      this.children.add(child);
    }
  }

  public void removeChild(ArithmeticComponent... children){
    for (ArithmeticComponent child : children){
      this.children.add(child);
    }
  }

  protected void checkChildrenExists() throws Exception{
    if (this.getChildren().size() == 0){
      throw new Exception("There aren't any children here, fix it");
    }
  }

  public void acceptVisitor(ArithmeticVisitor visitor){
    visitor.visitArithmeticComponent(this);
  }


}
