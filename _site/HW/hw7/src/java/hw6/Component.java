package hw6;

public abstract class Component {
    private Component parent = null;
    protected String instanceID(){
        return "Component";
    }

    public MyIterator CreateIterator() throws Exception{
        throw new Exception("bro, there isn't an interator for this");
    }

    public MyIterator CreatePreOrderIterator() throws Exception{
        return new PreOrderIterator<Component>(this);
    }

    public Component add(Component c) throws Exception{
        doAdd(c);
        c.parent = this;
        return c;
    }

    public Component remove(Component c) throws Exception{
        doRemove(c);
        c.parent = null;
        return c;
    }
    

    protected void doAdd(Component c) throws Exception{
        throw new Exception("Not implemented");
    } 

    protected void doRemove(Component c) throws Exception{
        throw new Exception("Not implemented");
    } 

    public Component getChild(int i){
        return null;
    }

    public String toString(){
        return (parent == null) ?
            instanceID() + " is the root" :
            instanceID() + " is the child of " + parent;
    }

}

