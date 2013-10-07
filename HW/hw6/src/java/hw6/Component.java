package hw6;

public abstract class Component {
    public abstract String toString();

    private Component parent = null;

    public Component add(Component c) throws Exception{
        return null;
    }
    public Component remove(Component c) throws Exception{
        return null;
    }
    public Component getChild(int i){
        return null;
    }

    public Component getParent(){
        return parent;
    }

    public void setParent(Component c){
        parent = c;
    }

    protected String calculateIndent(){
        //count how much it should indent
        String indent = "";
        Component parent = this.parent;
        while (parent != null){
            indent += "\t";
            parent = parent.parent;
        }
        return indent;
    }
}

