package hw6;

public class InstanceComposite extends Component {
    private Component child = null;

    public InstanceComposite(Component c){
        child = c;
        child.setParent(this);
        return;
    }

    public Component add(Component c) throws Exception{
        if (child == null){
            child = c;
            child.setParent(this);
        }else{
            throw new Exception("Child already set");
        }
        return child;
    }

    public Component remove(Component c) throws Exception{
        if (child == null){
            throw new Exception("Child already set");
        }else{
            child.setParent(null);
            child = null;
        }
        return c;
    }

    public String toString(){
        String indent = calculateIndent();
        if (child == null){
            return indent + "InstanceComposite Containing: Nothing :(";
        }
        return indent + "InstanceComposite Containing:\n"+child.toString();
    }
}





