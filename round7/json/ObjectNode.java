
import java.util.TreeMap;
import java.util.Iterator;



/**
 *
 * @author Eppuh
 */
public class ObjectNode extends Node implements Iterable<String>{

    
    private TreeMap<String, Node> pairs;

    public ObjectNode() {
        pairs = new TreeMap<String, Node>();
    }
    
    Node get(String Key){
        return pairs.get(Key);
    }
    
    void set(String key, Node node) {
        pairs.put(key, node);
    }
    
    int size() {
        return pairs.size();
    }
    
    
    
    
    @Override
    public Iterator<String> iterator() {
        return pairs.keySet().iterator();
    }
    
}
