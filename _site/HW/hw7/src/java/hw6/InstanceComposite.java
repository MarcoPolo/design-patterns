package hw6;

public class InstanceComposite extends Component {
    private Component child = null;

    public InstanceComposite(Component c){
        try{
            add(c);
        } catch (Exception e) {}
        return;
    }

    public void doAdd(Component c) throws Exception{
        if (child == null){
            child = c;
        }else{
            throw new Exception("Child already set");
        }
    }

    public void doRemove(Component c) throws Exception{
        if (child == null){
            throw new Exception("Child already set");
        }else{
            child = null;
        }
    }
}





