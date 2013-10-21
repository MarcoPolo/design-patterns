package hw8;

public class Main {
  public static void main(String [ ] args) {
    System.out.println("Starting");
    AdditionComponent a = new AdditionComponent();
    ArithmeticComponent num = new LeafNumberComponent(13);
    ArithmeticComponent num2 = new LeafNumberComponent(12);
    ArithmeticComponent num4 = new LeafNumberComponent(4);
    ArithmeticComponent num5 = new LeafNumberComponent(5);

    ArithmeticComponent s = new SubtractComponent();
    ArithmeticComponent d = new DivideComponent();
    ArithmeticComponent m = new MultiplyComponent();

    ArithmeticComponent m2 = new MultiplyComponent();

    ArithmeticComponent n1 = new LeafNumberComponent(1);
    ArithmeticComponent n2 = new LeafNumberComponent(2);
    ArithmeticComponent n3 = new LeafNumberComponent(3);
    ArithmeticComponent n4 = new LeafNumberComponent(4);
    ArithmeticComponent n5 = new LeafNumberComponent(5);

    ArithmeticComponent n11 = new LeafNumberComponent(11);
    ArithmeticComponent n5n = new LeafNumberComponent(-5);
    ArithmeticComponent n23n = new LeafNumberComponent(-23);
    ArithmeticComponent n45 = new LeafNumberComponent(45);

    ArithmeticComponent m1 = new MultiplyComponent();
    ArithmeticComponent a1 = new AdditionComponent();
    ArithmeticComponent a2 = new AdditionComponent();
    ArithmeticComponent s1 = new SubtractComponent();
    ArithmeticComponent d1 = new DivideComponent();
    
    a1.addChild(n3,n5n);
    s1.addChild(a1,n45);
    d1.addChild(n1,n2);
    m1.addChild(d1,s1);
    a2.addChild(n11,m1,n23n);

    ArithmeticVisitor l1 = new LispVisitor();
    a2.acceptVisitor(l1);

    ArithmeticVisitor ttv1 = new TextTreeVisitor();
    a2.acceptVisitor(ttv1);


    d.addChild(num2, num4);
    a.addChild(num);
    s.addChild(num);
    s.addChild(num2);

    m.addChild(d, num5);


    //lisp expressions
    ArithmeticVisitor l = new LispVisitor();
    m.acceptVisitor(l);

    ArithmeticVisitor i = new InFixVisitor();
    m.acceptVisitor(i);

    ArithmeticVisitor ev = new EvaluatedVisitor();
    m.acceptVisitor(ev);

    ArithmeticVisitor ttv = new TextTreeVisitor();
    m.acceptVisitor(ttv);
    
    try {
      System.out.println("Number is "+num+", and addition is "+a.evaluate());
      System.out.println("Number is "+num+", and subtraction is "+s.evaluate());
      System.out.println("Number is "+num+", and division is "+d.evaluate());
      System.out.println("Number is "+num+", and mult is "+m.evaluate());
      System.out.println("s expression is "+ l);
      System.out.println("infix expression is "+ i);
      System.out.println("Evaluted expression is "+ ev);
      System.out.println("tree expression is "+ ttv);
      System.out.println("s expression is "+ l1);
      System.out.println("tree expression is "+ ttv1);
    } catch (Exception e){
      System.out.println("There was an error: "+e);
    }
  }
}
