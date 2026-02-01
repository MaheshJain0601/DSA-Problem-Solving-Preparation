/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class NestedIteratorApproach1 implements Iterator<Integer> {
    Stack<NestedInteger> st;

    public NestedIteratorApproach1(List<NestedInteger> nestedList) {
        st = new Stack<>();
        int index = nestedList.size() - 1;
        while (index >= 0) {
            st.push(nestedList.get(index));
            index--;
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!st.isEmpty()) {
            NestedInteger nestedInteger = st.peek();
            if (nestedInteger.isInteger()) {
                return true;
            }
            st.pop();
            List<NestedInteger> nestedList = nestedInteger.getList();
            int index = nestedList.size() - 1;
            while (index >= 0) {
                st.push(nestedList.get(index));
                index--;
            }
        }
        return false;
    }
}

public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    Iterator<Integer> iterator;

    private void recursiveFlatten(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                queue.offer(ni.getInteger());
            } else {
                recursiveFlatten(ni.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        recursiveFlatten(nestedList);
        iterator = queue.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */