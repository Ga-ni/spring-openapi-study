package career.task.eums;

public enum SortType {

    ACCURACY("accuracy"),
    RECENCY("recency");


    private final String value;

    SortType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
