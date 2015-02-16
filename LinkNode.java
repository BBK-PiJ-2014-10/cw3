public class LinkNode {
    private ReturnObject data;
    private LinkNode next = null;
    private LinkNode previous = null;

    public LinkNode(ReturnObject dataToSet, LinkNode nextToSet, LinkNode previousToSet) {
        data = dataToSet;
        next = nextToSet;
        previous = previousToSet;
    }

    public ReturnObject getData() {
        return data;
    }

    public void setData(ReturnObject dataToSet) {
        data = dataToSet;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode nextToSet) {
        next = nextToSet;
    }

    public LinkNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkNode previousToSet) {
        previous = previousToSet;
    }

}
