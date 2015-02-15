public class LinkNode {
    private ReturnObjectImpl data;
    private LinkNode next = null;
    private LinkNode previous = null;

    public LinkNode(ReturnObjectImpl dataToSet, LinkNode nextToSet, LinkNode previousToSet) {
        data = dataToSet;
        next = nextToSet;
        previous = previousToSet;
    }

    public void setData(ReturnObjectImpl dataToSet){
        data = dataToSet;
    }

    public ReturnObjectImpl getData() {
        return data;
    }

    public void setNext(LinkNode nextToSet) {
        next = nextToSet;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setPrevious(LinkNode previousToSet) {
        previous = previousToSet;
    }

    public LinkNode getPrevious() {
        return previous;
    }

}
