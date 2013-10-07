package hw6;

import static java.lang.System.out;

public class Main { 
    public static void main(String [] args) {
        System.out.println("Stuff:");
        LinkedComposite lc = new LinkedComposite( new Leaf( "A" ), new Leaf( "B" ) ); 
        ArrayComposite ac = new ArrayComposite( new Leaf( "C" ), lc, new Leaf( "D" ) );
        ac.toString();
        System.out.println(ac.toString());

    }

}
