package hw6;


public class ArrayComposite extends Component {
    private Component[] leaves; 
    public ArrayComposite (Component... components) {
        leaves = components;
        for (Component c : leaves){
            c.setParent(this);
        }
    }

    public String toString() {
        String s = "";
        String indent = calculateIndent();
        for (Component c : leaves){
            if (c != null){
                s += c.toString() + "\n";
            }
        }
        if ( s.equals("") ){
            return indent + "ArrayComposite Containing: Nothing :( ";
        }else{
            return indent + "ArrayComposite Containing: \n"+s;
        }
    }

    public Component remove(Component c) throws Exception{
        boolean found = false;
        for (int i = 0; i< leaves.length; i++){
            if ( leaves[i] == c ){
                leaves[i].setParent(null);
                leaves[i] = null;
                found = true;
                break;
            }
        }

        if (!found){
            throw new Exception("Component wasn't in there, sorry");
        }
        return c;
    }

    public Component add(Component c) throws Exception{
        boolean foundSpace = false;
        for (int i = 0; i< leaves.length; i++){
            if ( leaves[i] == null ){
                leaves[i] = c;
                leaves[i].setParent(this);
                foundSpace = true;
                break;
            }
        }

        if (!foundSpace){
            throw new Exception("There wasn't space to put the components, sorry");
        }
        return c;
    }
}



