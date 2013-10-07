package hw6;


public class Leaf extends Component {
    private String value; 
    public Leaf (String s) {
        value = s;
    }

    public String toString() {
        String s = this.calculateIndent();
        return this.calculateIndent() + "Leaf: "+value.toString();
    }
}

