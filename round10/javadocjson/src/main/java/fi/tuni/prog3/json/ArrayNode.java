package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;
public class ArrayNode extends Node implements Iterable<Node>{

    ArrayList<Node> nodes;
    
    public ArrayNode() {
        nodes = new ArrayList<>();
    }
    
    void add(Node node) {
        nodes.add(node);
    }
    
    int size() {
        return nodes.size();
    }

    
    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
    
}
