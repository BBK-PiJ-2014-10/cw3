public class ImprovedStackImpl implements ImprovedStack {
    protected List internalList;

    public ImprovedStackImpl(LinkedList list) {
        internalList = list;
    }

    @Override
    public ImprovedStack reverse() {
        ImprovedStack reversedStack = new ImprovedStackImpl(new LinkedList());
        for (int index = (internalList.size() - 1); index > -1; index--) {
            reversedStack.push(internalList.get(index).getReturnValue());
        }
        return reversedStack;
    }

    @Override
    public void remove(Object object) {
        for (int index = 0; index < size(); index++) {
            if (internalList.get(index).getReturnValue().equals(object)) {
                internalList.remove(index);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public void push(Object item) {
        internalList.add(item);

    }

    @Override
    public ReturnObject top() {
        return internalList.get(internalList.size() - 1);
    }

    @Override
    public ReturnObject pop() {
        return internalList.remove(internalList.size() - 1);
    }
}
