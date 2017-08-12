package eu.ludimus.model.googleapi;

public class Duration {

    private String text;
    private Integer value;

    public String getText() {
        return text;
    }

    public Duration setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public Duration setValue(Integer value) {
        this.value = value;
        return this;
    }
}