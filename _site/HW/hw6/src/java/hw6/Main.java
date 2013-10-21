package hw6;

import static java.lang.System.out;

public class Main { 
    public static void main(String [] args) {
        System.out.println("Stuff:");
        LinkedComposite lc = new LinkedComposite( new Leaf( "A" ), new Leaf( "B" ) ); 
        ArrayComposite ac = new ArrayComposite( new Leaf( "C" ), lc, new Leaf( "D" ) );
        ac.toString();
        System.out.println(ac.toString());

            Leaf a = new Leaf("A");

            Leaf c = new Leaf("C");

            try {
           

            lc = new LinkedComposite( a, new Leaf( "B" ) );

            ac = new ArrayComposite( c, lc, new Leaf( "D" ) );
            ac = new ArrayComposite( c, new Leaf( "D" ) );

            ArrayIterator<Component> 

            System.out.println("EXPECTED OUTPUT---------");

            System.out.println(ac.toString());

           

            lc.remove(a);

            System.out.println("TEST CASE 2---------");

            System.out.println(ac.toString());

           

            Leaf e = new Leaf("E");

            Component sc = new InstanceComposite(e);

            lc.add(sc);

            System.out.println("TEST CASE 3---------");

            System.out.println(ac.toString());

 

            ac.remove(c);

            System.out.println("TEST CASE 4---------");

            System.out.println(ac.toString());

           

            ac.add(new Leaf("ZZ"));

            System.out.println("TEST CASE 5---------");

            System.out.println(ac.toString());

           
            } catch (Exception e){
            }


    }

}
