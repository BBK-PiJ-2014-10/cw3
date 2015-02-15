import java.util.Arrays;

public class ArrayList implements List {
    private ReturnObjectImpl[] array = new ReturnObjectImpl[0];

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (array.length == 0);
    }

    /**
     * Returns the number of items currently in the list.
     *
     * @return the number of items currently in the list
     */
    public int size() {
        return array.length;
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
        } else if ((index < 0) || (index >= array.length)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            returnObj = array[index];
        }
        return returnObj;
    }
    /**
     * Returns the elements at the given position and removes it
     * from the list. The indices of elements after the removed
     * element must be updated accordingly.
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

        if ((index < 0) || (index >= array.length)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            returnObj = array[index];
            ReturnObjectImpl[] modifiedArray = Arrays.copyOf(array, array.length - 1);

            for (int i = index + 1; i < array.length; i++) {
                ReturnObjectImpl currentObject = array[i];
                modifiedArray[i - 1] = currentObject;
            }
            array = modifiedArray;
        }
        return returnObj;
    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indices of elements at and after that position
     * must be updated accordingly.
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
    public ReturnObjectImpl add(int index, Object item) {
        ReturnObjectImpl returnObj;

        if ((index < 0) || (index > array.length)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);
            ReturnObjectImpl[] modifiedArray = Arrays.copyOf(array, array.length + 1);

            for (int i = index; i < array.length; i++) {
                ReturnObjectImpl currentObject = array[i];
                modifiedArray[i + 1] = currentObject;
            }
            modifiedArray[index] = new ReturnObjectImpl(item);
            array = modifiedArray;
        }
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
     * @return an ReturnObject, empty (null) if the operation is successful, or containing an appropriate error message
     */
    public ReturnObjectImpl add(Object item) {
        ReturnObjectImpl returnObj;

        if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);

            ReturnObjectImpl[] modifiedArray = Arrays.copyOf(array, array.length + 1);
            modifiedArray[modifiedArray.length - 1] = new ReturnObjectImpl(item);
            array = modifiedArray;
        }

        return returnObj;
    }
}
