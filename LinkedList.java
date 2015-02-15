public class LinkedList implements List {

    private int size = 0;
    private LinkNode head;
    private LinkNode tail;
    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns the number of items currently in the list.
     *
     * @return the number of items currently in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the elements at the given position.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */

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

    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObjectImpl remove(int index) {
        ReturnObjectImpl returnObj;

        if ((index < 0) || (index >= size)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            returnObj = get(index);
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
        size--;
        return returnObj;
    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    public ReturnObject add(int index, Object item) {
        ReturnObjectImpl returnObj;

        if ((index < 0) || (index >= size)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);
            ReturnObjectImpl dataToset = new ReturnObjectImpl(item)
            if (index == 0) {
                LinkNode oldHead = head;
                head = new LinkNode(dataToset, oldHead, null);
                oldHead.setPrevious(head);
            } else if (index == (size - 1)) {
                LinkNode oldTail = tail;
                tail = new LinkNode(dataToset, null, oldTail);
                oldTail.setNext(tail);
            } else {
                LinkNode oldNode = head;
                for (int i = 0; i < index; i++)
                    oldNode = oldNode.getNext();

                LinkNode previousNode = oldNode.getPrevious();
                LinkNode newNode = new LinkNode(dataToset, oldNode, previousNode);

                previousNode.setNext(newNode);
                oldNode.setPrevious(newNode);
            }
        }
        size++;
        return returnObj;
    }

    /**
     * Adds an element at the end of the list.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    public ReturnObject add(Object item) {
        return null;
    }
}
