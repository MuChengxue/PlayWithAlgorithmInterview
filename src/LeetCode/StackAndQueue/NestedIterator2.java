package LeetCode.StackAndQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator2 implements Iterator<Integer> {

    private List<Integer> list;
    private int index;

    public NestedIterator2(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = -1;
    }

    private static List<Integer> integerIterator(List<NestedInteger> nestedIntegerList) {
        ArrayList<Integer> list = new ArrayList<>(nestedIntegerList.size());
        for (NestedInteger tmp : nestedIntegerList) {
            if (tmp.isInteger())
                list.add(tmp.getInteger());
            else
                list.addAll(integerIterator(tmp.getList()));
        }
        return list;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) return list.get(++index);
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index + 1 < list.size()) return true;
        return false;
    }
}

