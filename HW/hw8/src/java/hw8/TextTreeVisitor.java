package hw8;

import java.util.ArrayList;

public class TextTreeVisitor extends ArithmeticVisitor {
  private ArithmeticComponent component;

  public void visitArithmeticComponent(ArithmeticComponent c){
    component = c;
    
  }

  public String toString(){
    return "\n" + textTreeVisitor("",component);
  }

  private String textTreeVisitor(String prefix, ArithmeticComponent c){
    if (c.getChildren().size() == 0){
      return "["+c+"]\n";
    }else{
      String aggregate = "";
      aggregate += "[" + c + "]\n";

      String childrenString = "";
      ArrayList<ArithmeticComponent> children = c.getChildren();

      for (int i=0; i<children.size(); i++){ 
        String childPrefix = " |   ";
        //if it's the last child, we don't want the trail (| char) going down
        if (i == children.size()-1) childPrefix = "     ";

        childrenString += (prefix + " +---" + textTreeVisitor(prefix+childPrefix, children.get(i)) + "");
      }

      aggregate += childrenString;

      return aggregate;
    }
  }
}
