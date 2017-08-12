package eu.ludimus.model.googleapi;

import java.util.List;

public class Row {

    private List<Element> elements = null;

    public List<Element> getElements() {
        return elements;
    }

    public Row setElements(List<Element> elements) {
        this.elements = elements;
        return this;
    }

}