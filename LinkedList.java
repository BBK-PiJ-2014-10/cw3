public class LinkedList implements List {

    private int size = 0;
    private LinkNode head;
    private LinkNode tail;

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ReturnObjectImpl get(int index) {
        ReturnObjectImpl returnObj;
        if (isEmpty()) {
            returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if ((index < 0) || (index >= size)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            if (index == 0) {
                returnObj = head.getData();
            } else if (index == (size - 1)) {
                returnObj = tail.getData();
            } else {
                LinkNode node = head;
                for (int i = 0; i < index; i++)
                    node = node.getNext();
                returnObj = node.getData();
            }
        }
        return returnObj;
    }

    @Override
    public ReturnObjectImpl remove(int index) {
        ReturnObjectImpl returnObj;

        if ((index < 0) || (index >= size)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            returnObj = get(index);

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                if (index == 0) {
                    returnObj = head.getData();
                    head = head.getNext();
                    head.setPrevious(null);
                } else if (index == (size - 1)) {
                    returnObj = tail.getData();
                    tail = tail.getPrevious();
                    tail.setNext(null);
                } else {
                    LinkNode node = head;
                    for (int i = 0; i < index; i++)
                        node = node.getNext();

                    LinkNode nextNode = node.getNext();
                    LinkNode previousNode = node.getPrevious();

                    nextNode.setPrevious(previousNode);
                    previousNode.setNext(nextNode);
                }
            }
        }
        size--;
        return returnObj;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        ReturnObjectImpl returnObj;

        if ((index < 0) || (index > size)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);
            ReturnObjectImpl dataToSet = new ReturnObjectImpl(item);
            if (isEmpty()) {
                head = new LinkNode(dataToSet, null, null);
                tail = head;
            } else if (index == size) {
                LinkNode oldTail = tail;
                tail = new LinkNode(dataToSet, null, oldTail);
                oldTail.setNext(tail);
            } else {
                if (index == 0) {
                    LinkNode oldHead = head;
                    head = new LinkNode(dataToSet, oldHead, null);
                    oldHead.setPrevious(head);
                } else if (index == (size - 1)) {
                    LinkNode oldTail = tail;
                    tail = new LinkNode(dataToSet, null, oldTail);
                    oldTail.setNext(tail);
                } else {
                    LinkNode oldNode = head;
                    for (int i = 0; i < index; i++)
                        oldNode = oldNode.getNext();

                    LinkNode previousNode = oldNode.getPrevious();
                    LinkNode newNode = new LinkNode(dataToSet, oldNode, previousNode);

                    previousNode.setNext(newNode);
                    oldNode.setPrevious(newNode);
                }
            }
        }
        size++;
        return returnObj;
    }

    @Override
    public ReturnObject add(Object item) {
        ReturnObjectImpl returnObj;

        if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);
            ReturnObjectImpl dataToSet = new ReturnObjectImpl(item);

            if (isEmpty()) {
                head = new LinkNode(dataToSet, null, null);
                tail = head;
            } else {
                LinkNode oldTail = tail;
                tail = new LinkNode(dataToSet, null, oldTail);
                oldTail.setNext(tail);
            }
        }
        size++;
        return returnObj;
    }
}
