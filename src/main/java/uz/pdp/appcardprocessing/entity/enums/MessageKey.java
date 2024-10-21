package uz.pdp.appcardprocessing.entity.enums;

public enum MessageKey {
    OPERATION_PROHIBITED("operation.prohibited");

    private final String key;

    MessageKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
