package eu.ludimus.service.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.InputStream;

public interface PdfConverter {
    byte[] toJpg(InputStream pdf) throws ConvertException;
}
