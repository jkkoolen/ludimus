package eu.ludimus.converter;

public final class ConverterFactoy {
    public enum ConverterType {
        PDF,
        IMAGE

    }
    public final static JpgConverter createConverter(final ConverterType type) {
        switch(type == null ? ConverterType.IMAGE : type) {
            case PDF: return new Pdf2JpgConverter();
            case IMAGE:
            default: return new Image2JpgConverter();
        }
    }
}
