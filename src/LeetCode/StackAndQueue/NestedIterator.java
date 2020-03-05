package LeetCode.StackAndQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> res = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger temp : nestedList)
            DFS(temp);
    }

    @Override
    public Integer next() {
        return res.poll();//Retrieves and removes the head of this queue,
    }

    @Override
    public boolean hasNext() {
        if (res.isEmpty())
            return false;
        return true;

    }

    public void DFS(NestedInteger Node) {
        /* 深度遍历 */
        if (Node.isInteger())
            res.offer(Node.getInteger());
        for (NestedInteger temp : Node.getList())
            DFS(temp);
    }


}
