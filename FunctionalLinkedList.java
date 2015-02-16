public class FunctionalLinkedList extends LinkedList implements FunctionalList {

    @Override
    public ReturnObject head() {
        ReturnObject returnObj;
        if (isEmpty()) {
            returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            returnObj = new ReturnObjectImpl(get(0).getReturnValue());
        }
        return returnObj;
    }

    @Override
    public FunctionalList rest() {
        FunctionalList restList = new FunctionalLinkedList();
        for (int i = 1; i < size(); i++) {
            restList.add(get(i).getReturnValue());
        }
        return restList;
    }
}
