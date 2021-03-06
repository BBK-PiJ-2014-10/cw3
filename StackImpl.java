public class StackImpl extends AbstractStack {

    public StackImpl(LinkedList list) {
        super(list);
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
