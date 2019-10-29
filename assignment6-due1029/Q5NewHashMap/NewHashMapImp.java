package Assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewHashMapImp implements NewHashMap {
    List<Integer> list = new ArrayList<>(2);
    int initSize = 1;

    public NewHashMapImp() {
        for (int i = 0; i < initSize; i++) {
            list.add(-1);
        }
    }

    @Override
    public void put(Integer key, Integer value) {
        int capacity = list.size();

        if (capacity <= key)
            list = extendMap(list, key + 1);

        list.set(key, value);
    }

    private List<Integer> extendMap(List<Integer> list, Integer size) {
        List<Integer> newList = new ArrayList<>(size);
        newList.add(-1);

        int i = 0;
        for ( i = 1; i < list.size(); i++) {
            newList.add(list.get(i));
        }

        while (i < size){
            newList.add(-1);
            i++;
        }

        return newList;
    }

    @Override
    public Integer get(Integer key) {
        if (key >= list.size())
            return -1;
        else {
            Integer value = list.get(key);

            return value;
        }
    }

    @Override
    public void remove(Integer key) {
        if (key >= list.size())
            return;
        else {
            Integer value = list.get(key);

            if (value == -1)
                return;
            else
                list.set(key, -1);
        }
    }

    // main test
    public static void main(String[] args) {
        NewHashMapImp newHashMapImp = new NewHashMapImp();

        newHashMapImp.put(1, 1);
        newHashMapImp.put(2, 2);
        newHashMapImp.get(1);            // returns 1
        newHashMapImp.get(3);            // returns -1 (not found)
        newHashMapImp.put(2, 1);          // update the existing value
        newHashMapImp.get(2);            // returns 1
        newHashMapImp.remove(2);          // remove the mapping for 2
        newHashMapImp.get(2);            // returns -1 (not found)
    }

}
