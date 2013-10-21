package hw6;


public class ArrayComposite extends Component {
    private Component[] leaves; 
    
    public MyIterator CreateIterator() throws Exception{
        return (new ArrayIterator<Component>(leaves));
    }

    public ArrayComposite (Component... components) {
        for (Component c : components){
            try {
            add(c);
            } catch (Exception e){}
        }
    }

    public void doRemove(Component c) throws Exception{
        boolean found = false;
        for (int i = 0; i< leaves.length; i++){
            if ( leaves[i] == c ){
                leaves[i] = null;
                found = true;
                break;
            }
        }

        if (!found){
            throw new Exception("Component wasn't in there, sorry");
        }
    }

    public void doAdd(Component c) throws Exception{
        boolean foundSpace = false;
        for (int i = 0; i< leaves.length; i++){
            if ( leaves[i] == null ){
                leaves[i] = c;
                foundSpace = true;
                break;
            }
        }

        if (!foundSpace){
            throw new Exception("There wasn't space to put the components, sorry");
        }
    }
}


