public class ReturnObjectImpl implements ReturnObject {
    private Object obj;
    private int index;

    public ReturnObjectImpl (Object obj) {
        this.obj = obj;
    }

    public int getIndex() {
        return this.index;
    }

    public int setIndex(int index) {
        return this.index = index;
    }

    /**
     * Returns whether there has been an error
     * @return whether there has been an error
     */
    public boolean hasError() {
        if (this.obj instanceof ErrorMessage) {
            if (this.obj != ErrorMessage.NO_ERROR) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the error message.
     *
     * This method must return NO_ERROR if and only if
     * {@hasError} returns false.
     *
     * @return the error message
     */
    public ErrorMessage getError() {

        if (this.hasError()) {
            for (ErrorMessage error : ErrorMessage.values()) {
                if (this.obj == error) {
                    return error;
                }
            }
        }

        return ErrorMessage.NO_ERROR;
    }

    /**
     * Returns the object wrapped in this ReturnObject, i.e. the
     * result of the operation if it was successful, or null if
     * there has been error.
     *
     * Note that the output of this method must be null if {@see
     * hasError} returns true, but the opposite is not true: if
     * {@see hasError} returns false, this method may or may not
     * return null.
     *
     * @return the return value from the method or null if there has been an
     *         error
     */
    public Object getReturnValue() {
        if (this.hasError()) {
            return null;
        } else {
            return this.obj;
        }
    }
}