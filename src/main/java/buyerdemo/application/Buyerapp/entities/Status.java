package buyerdemo.application.Buyerapp.entities;

public enum Status {

    ACTIVE("ACTIVE"),

    INACTIVE("INACTIVE"),

    DELETED("DELETED");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
