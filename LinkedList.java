public class LinkedList implements List {

    private int size = 0;
    private LinkNode head;
    private LinkNode last;
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

    public ReturnObject get(int index) {
        ReturnObjectImpl returnObj;
        if (isEmpty()) {
            returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if ((index < 0) || (index >= size)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            if (index == 1) {
                returnObj = head.getData();
            } else {
                if (index > (size / 2)) {
                    LinkNode link = last;
                    for (int i = 0; i < index; i++)
                        link = link.getPointer();
                    returnObj = link.getData();
                }
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
    public ReturnObject remove(int index) {
        return null;
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
        return null;
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
