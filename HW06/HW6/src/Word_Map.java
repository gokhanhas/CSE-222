/*
 * Gokhan Has - 161044067
 */

import java.util.*;

public class Word_Map implements Map, Iterable, Iterator {

    final static int INITCAP=10;  //initial capacity
    int CURRCAP = INITCAP;   //current capacity
    final static float LOADFACT = 0.75f;
    private Node headNode;
    private Node table[];
    private int size;

    public Word_Map() {
        this.table = new Node[INITCAP];
        headNode = null;
        tempNode = null;
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return (headNode.nextNode != null);
    }

    @Override
    public Object next() {
        if(hasNext()) {
            String tempkey = headNode.key;
            headNode = headNode.nextNode;
            return tempkey;
        }
        return null;
    }


    static class Node {

        private String key;
        private File_Map val;
        private Node nextNode;


        public Node() {
            key = null;
            val = null;
            nextNode = null;
        }

        public Node(String key, File_Map value) {
            this.key = key;
            val = value;
            nextNode = null;
        }

        public Node(String key, File_Map value, Node next) {
            this.key = key;
            val = value;
            nextNode = next;
        }

        public Node(Node other) {
            this.key = other.key;
            this.val = other.val;
            this.nextNode = other.nextNode;
        }

        public void setNextNode(Node next) {
            nextNode = next;
        }

        public String getKey() {
            return key;
        }

        public Node getNextNode() {
            return nextNode;
        }

        // complete this class according to the given structure in homework definition
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsKey(Object key) {
        int index = calculateIndex(key);
        if(table[index] == null)
            return false;
        if(table[index].key.equals(key))
            return true;
        return false;
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsValue(Object value) {
        int k=0;
        while(k < table.length) {
            if(table[k] != null) {
                if(table[k].val.equals(value))
                    return true;
            }
            ++k;
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        if(containsKey(key)) {
            int index = calculateIndex(key);
            return table[index].val;
        }
        return null;
    }

    @Override
    /*
    Use linear probing in case of collision
    * */
    public Object put(Object key, Object value) {

        int index = calculateIndex(key);

        if(headNode == null) {
            table[index] = new Node((String) key,(File_Map) value);
            headNode = table[index];
            tempNode = headNode;
            size++;
            return null;
        }

        if(!(table[index] == null)) {
            Object tempValue = table[index].val;
            table[index].val = (File_Map) value;
            return tempValue;
        }

        table[index] = new Node((String) key,(File_Map) value);
        tempNode.nextNode = table[index];
        tempNode = tempNode.nextNode;
        size++;

        if(getCurrLoadFactor() > LOADFACT)
            rehash();

        return null;
    }

    @Override
    /*You do not need to implement remove function
    * */
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {
        Collection collection = new LinkedList(m.values());
        Object array[] = new String[m.keySet().size()];
        array = m.keySet().toArray();

        for(int i=0; i<array.length;++i)
            put(array[i],((LinkedList) collection).get(i));
    }

    @Override
    public void clear() {
        table = null;
        CURRCAP = INITCAP;
        headNode = null;
        tempNode = null;
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Set keySet() {
        Set<String> returnSet = new TreeSet<>();
        Node temp = new Node(headNode);
        while(temp != null) {
            returnSet.add(temp.key);
            temp = temp.nextNode;
        }
        return returnSet;
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Collection values() {

        Node tempNode = headNode;
        Collection<File_Map> collection = new ArrayList<File_Map>();

        while (tempNode != null) {
            collection.add(tempNode.val);
            tempNode = tempNode.nextNode;
        }
        return collection;
    }
    private Node tempNode;
    @Override
    /*You do not need to implement entrySet function
     * */
    public Set<Entry> entrySet() {
        return null;
    }

    private void rehash() {

        Node[] tableTemp = table;
        table = new Node[3 * table.length + 1];
        CURRCAP = table.length;
        int k=0;
        size = 0;
        headNode = null;
        tempNode = null;
        while(k < tableTemp.length) {
            if(tableTemp[k] != null)
                this.put(tableTemp[k].key,tableTemp[k].val);
            ++k;
        }
    }

    private double getCurrLoadFactor() {
        return (double) (this.size() / table.length);
    }

    private int calculateIndex(Object key) {

        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;

        while(table[index] != null && (!key.equals(table[index].key))) {
            // Collosion problem in here.
            index++;
            if(index >= table.length)
                index = 0;
        }
        return index;
    }
}
