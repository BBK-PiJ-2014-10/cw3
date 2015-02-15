public class LinkNode {
    private ReturnObjectImpl data;
    private LinkNode pointer = null;

    public LinkNode(ReturnObjectImpl dataToSet, LinkNode pointerToSet, int indexToSet) {
        data = dataToSet;
        pointer = pointerToSet;
    }

    public void setData(ReturnObjectImpl dataToSet){
        data = dataToSet;
    }

    public ReturnObjectImpl getData() {
        return data;
    }

    public void setPointer(LinkNode pointerToSet) {
        pointer = pointerToSet;
    }

    public LinkNode getPointer() {
        return pointer;
    }

}
