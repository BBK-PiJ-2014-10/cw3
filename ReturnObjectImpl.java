public class ReturnObjectImpl implements ReturnObject {
    private Object object;

    public ReturnObjectImpl(Object objectToSet) {
        object = objectToSet;
    }

    @Override
    public boolean hasError() {
        if (object instanceof ErrorMessage) {
            if (!object.equals(ErrorMessage.NO_ERROR)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ErrorMessage getError() {

        if (hasError()) {
            for (ErrorMessage error : ErrorMessage.values()) {
                if (object == error) {
                    return error;
                }
            }
        }
        return ErrorMessage.NO_ERROR;
    }

    @Override
    public Object getReturnValue() {
        if (hasError()) {
            return null;
        } else {
            return object;
        }
    }
}