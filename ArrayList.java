public class ArrayList implements List {
    private ReturnObject[] array = new ReturnObjectImpl[0];

    @Override
    public boolean isEmpty() {
        return (array.length == 0);
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ReturnObject get(int index) {
        ReturnObject returnObj;

        if (isEmpty()) {
            returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if ((index < 0) || (index >= array.length)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            returnObj = array[index];
        }
        return returnObj;
    }

    @Override
    public ReturnObject remove(int index) {
        ReturnObject returnObj;

        if ((index < 0) || (index >= array.length)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            returnObj = array[index];
            ReturnObject[] modifiedArray = new ReturnObjectImpl[array.length - 1];

            for (int i = 0; i < array.length; i++) {
                if (i < index) {
                    modifiedArray[i] = array[i];
                } else if (i != index) {
                    modifiedArray[i - 1] = array[i];
                }
            }
            array = modifiedArray;
        }
        return returnObj;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        ReturnObject returnObj;

        if ((index < 0) || (index > array.length)) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);
            ReturnObject[] modifiedArray = new ReturnObjectImpl[array.length + 1];

            for (int i = 0; i < array.length; i++) {
                if (i < index) {
                    modifiedArray[i] = array[i];
                } else if (i > index) {
                    modifiedArray[i + 1] = array[i];
                }
            }
            modifiedArray[index] = new ReturnObjectImpl(item);
            array = modifiedArray;
        }
        return returnObj;
    }

    @Override
    public ReturnObjectImpl add(Object item) {
        ReturnObjectImpl returnObj;

        if (item == null) {
            returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            // As per http://moodle.bbk.ac.uk/mod/forumng/discuss.php?d=289
            returnObj = new ReturnObjectImpl(null);

            ReturnObject[] modifiedArray = new ReturnObjectImpl[array.length + 1];

            for (int i = 0; i < array.length; i++) {
                modifiedArray[i] = array[i];
            }
            modifiedArray[modifiedArray.length - 1] = new ReturnObjectImpl(item);
            array = modifiedArray;
        }

        return returnObj;
    }
}
