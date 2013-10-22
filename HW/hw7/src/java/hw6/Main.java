package hw6;

import static java.lang.System.out;

public class Main { 
    public static void main(String [] args) {
        System.out.println("Stuff:");
        LinkedComposite lc = new LinkedComposite( new Leaf( "A" ), new Leaf( "B" ) ); 
        LinkedComposite ac = new LinkedComposite( new Leaf( "C" ), lc, new Leaf( "D" ) );
        Leaf a = new Leaf("A");

        ac.toString();
        try{
            System.out.println("PREorder stuff: ");
            MyIterator i3 = ac.CreatePreOrderIterator();
            System.out.println("K: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is1: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is2: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is3: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is4: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is5: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is6: "+ i3.currentItem());
            i3.next();
            System.out.println("Next one is7: "+ i3.currentItem());


        }catch(Exception e){
            System.out.println("e"+e);
        }
        System.out.println("Done");

        System.out.println(ac.toString());


            Leaf c = new Leaf("C");

            try {
           

            lc = new LinkedComposite( a, new Leaf( "B" ) );

            //ArrayIterator<Component> 

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
