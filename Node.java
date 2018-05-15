import java.util.LinkedList;

public class Node<T> {
    T data;
    Node<T> parent;
    LinkedList<Node<T>> children;

    public Node(T d){
        this.data = d;
        this.parent = null;
        this.children = new LinkedList<Node<T>>();
    }

    public void append(T d){
        Node<T> new_node = new Node<T>(d);
        new_node.parent = this;
        this.children.add(new_node);
    }

    public String toString(){
    	return c2s(this, 0);
	}

	private String c2s(Node<T> node, int l){
    	// recursive function to read children nodes in a general way
		String s = "";
		int c = 0;
		while(c < l){
			s += "\t";
			c++;
		}
		s += node.data.toString() + " " + " \n";
		if(node.children.size() > 0){
			for(Node<T> n : node.children){
				s += c2s(n, l+1);
			}
		}
		return s;
	}
}
