package hw6;


public class Leaf extends Component {
    private String value; 

    public MyIterator CreateIterator(){
        return new NullIterator<Component>();
    }

    protected String instanceID(){
        return "Leaf";
    }
    public Leaf (String s) {
        value = s;
    }
}

