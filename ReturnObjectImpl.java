public class ReturnObjectImpl implements ReturnObject {
    private Object obj;

    public ReturnObjectImpl(Object obj) {
        this.obj = obj;
    }

    @Override
    public boolean hasError() {
        if (this.obj instanceof ErrorMessage) {
            if (this.obj != ErrorMessage.NO_ERROR) {
                return true;
            }
        }

        return false;
    }

    @Override
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

    @Override
    public Object getReturnValue() {
        if (this.hasError()) {
            return null;
        } else {
            return this.obj;
        }
    }
}