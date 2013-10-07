package hw6;

public class LinkedComposite extends Component {
    private Node<Component> rootNode = null; 
    public LinkedComposite (Component... components) {
        for (int i = 0; i< components.length; i++){
            try {
                add(components[i]);
            } catch (Exception e){
                //ehh
            }
        }
    }

    public String toString() {
        String indent = calculateIndent();
        String s = "";
        Node<Component> node = rootNode;
        while (node != null){
            s += node.value.toString() + "\n";
            node = node.next;
        }
        if ( s.equals("") ){
            return indent + "LinkedComposite Containing: Nothing :( ";
        }else{
            return indent + "LinkedComposite Containing: \n"+s;
        }
    }

    public Component remove(Component c) throws Exception{
        boolean found = false;
        Node<Component> node = rootNode;

        //check the root node
        if ( node.value == c ){
            rootNode = node.next;
            found = true;
        }else{
            while (node.next != null){
                if ( node.next.value == c ){
                    node.next.value.setParent(null);
                    node.next = node.next.next;
                    found = true;
                    break;
                }
                node = node.next;
            }
        }

        if (!found){
            throw new Exception("Component wasn't in there, sorry");
        }
        return c;
    }

    public Component add(Component c) throws Exception{
        if (rootNode == null){
            rootNode = new Node<Component>(c);
        }else{
            Node<Component> node = rootNode;
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node<Component>(c);
        }
        c.setParent(this);
        return c;
    }
}




