package eu.ludimus.model.googleapi;

public class Distance {

    private String text;
    private Integer value;

    public String getText() {
        return text;
    }

    public Distance setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public Distance setValue(Integer value) {
        this.value = value;
        return this;
    }
}