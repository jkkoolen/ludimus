package eu.ludimus.service.pdf;

import com.lowagie.text.Document;

import java.io.InputStream;

public interface PdfConverter {
    byte[] toJpg(InputStream pdf) throws ConvertException;
    Document toDocument(String htmlPage) throws ConvertException;
}
