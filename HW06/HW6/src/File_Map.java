/*
 * Gokhan Has - 161044067
 */

import java.util.*;

public class File_Map implements Map {

    /*
    For this hashmap, you will use arraylists which will provide easy but costly implementation.
    Your should provide and explain the complexities for each method in your report.
    * */
   ArrayList<String> fnames = new ArrayList<String>();
   ArrayList<List<Integer>> occurances = new ArrayList<>();


    @Override
    public int size() {
        return fnames.size();
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return fnames.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return occurances.contains(value);
    }

    @Override
    public Object get(Object key) {
        if(containsKey(key))
            return occurances.get(fnames.indexOf(key));
        return null;
    }

    @Override
    /* Each put operation will extend the occurance list*/
    public Object put(Object key, Object value) {
        if(!fnames.contains(key)) {
            fnames.add((String) key);
            occurances.add((List<Integer>) value);
            return null;
        }
        int index = fnames.indexOf(key);
        Object temp = occurances.get(index);
        occurances.set(index,(List<Integer>) value);
        return temp;
    }

    @Override
    public Object remove(Object key) {
        if(!fnames.contains(key))
            return null;

        int index = fnames.indexOf(key);
        Object temp = occurances.get(index);
        occurances.remove(index);
        fnames.remove(index);
        return temp;
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
        occurances.clear(); fnames.clear();
    }

    @Override
    public Set keySet() {
        Set<String> key = new TreeSet<>();
        int k = 0;
        while( k < fnames.size()) {
            key.add(fnames.get(k));
            ++k;
        }
        return key;
    }

    @Override
    public Collection values() {
        Collection<List<Integer>> collection = new ArrayList<List<Integer>>();
        int k=0;
        while(k < occurances.size()) {
            collection.add(occurances.get(k));
            ++k;
        }
        return collection;
    }

    @Override
    public Set<Entry> entrySet() {
        TreeMap<String,List<Integer>> returnSet = new TreeMap<String, List<Integer>>();
        int k = 0;
        while (k < this.size()) {
            returnSet.put(fnames.get(k),occurances.get(k));
            ++k;
        }
        return ((Set) returnSet.entrySet());
    }

}
