public class SampleableListImpl extends LinkedList implements SampleableList {

    @Override
    public SampleableListImpl sample() {
        SampleableListImpl returnList = new SampleableListImpl();
        for (int i = 0; i < size; i++) {
            if ((i + 1) % 2 != 0) {
                returnList.add(get(i).getReturnValue());
            }
        }
        return returnList;
    }
}
