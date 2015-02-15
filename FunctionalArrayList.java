import java.util.Arrays;

public class FunctionalArrayList extends ArrayList implements FunctionalList{

    /**
     * Returns the element at the beginning of the list.
     *
     * If the list is empty, an appropriate error is returned.
     *
     * @return a copy of the element at the beginning of the list or
     *         an error if the list is empty.
     */
    public ReturnObjectImpl head() {
        ReturnObjectImpl returnObj;
        if (isEmpty()) {
            returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            returnObj = new ReturnObjectImpl(get(0).getReturnValue());
        }
        return returnObj;
    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list.
     *
     * If the list is empty, another empty list is returned.
     */
    public FunctionalArrayList rest() {
        FunctionalArrayList returnList;
        if (isEmpty()) {
            returnList = new FunctionalArrayList();
        } else {
            ReturnObjectImpl[] newArray = Arrays.copyOf(array, array.length - 1);
            for (int i = 1; i < array.length; i++) {
                ReturnObjectImpl currentObject = array[i];
                newArray[i - 1] = currentObject;
            }
            returnList = new FunctionalArrayList();
            returnList.setArray(newArray);
        }
        return returnList;
    }

    public void setArray(ReturnObjectImpl[] arrayToSet) {
        array = arrayToSet;
    }
}