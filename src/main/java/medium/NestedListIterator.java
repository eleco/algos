package medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator {
/*
Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,1,2,1,1].
 */


}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> s;

    public NestedIterator(List<NestedInteger> nestedList) {
        s = new Stack();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            s.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return s.pop().getInteger();

        } else return null;
    }

    @Override
    public boolean hasNext() {

        while (!s.isEmpty() && !s.peek().isInteger()) {
            NestedInteger ni = s.pop();
            if (ni.isInteger()) {
                s.push(ni);
            } else {
                for (int i = ni.getList().size() - 1; i >= 0; i--) {
                    s.push(ni.getList().get(i));
                }
            }
        }
        return (!s.isEmpty());

    }
}
