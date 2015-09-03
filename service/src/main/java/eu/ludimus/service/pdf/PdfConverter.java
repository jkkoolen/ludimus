package eu.ludimus.service.pdf;

import java.io.InputStream;

public interface PdfConverter {
    byte[] toJpg(InputStream pdf) throws ConvertException;
}
