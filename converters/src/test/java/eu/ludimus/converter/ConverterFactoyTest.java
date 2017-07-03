package eu.ludimus.converter;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import static eu.ludimus.converter.ConverterFactoy.ConverterType.IMAGE;
import static eu.ludimus.converter.ConverterFactoy.ConverterType.PDF;
import static org.junit.Assert.assertTrue;

public class ConverterFactoyTest {
    @Test
    public void createConverter() throws Exception {
        assertTrue(ConverterFactoy.createConverter(PDF) instanceof Pdf2JpgConverter);
        assertTrue(ConverterFactoy.createConverter(IMAGE) instanceof Image2JpgConverter);
        assertTrue(ConverterFactoy.createConverter(null) instanceof Image2JpgConverter);
    }

    @Test
    public void pdfToJpg() throws Exception {
        final byte[] jpg1 = ConverterFactoy.createConverter(PDF).toJpg(ConverterFactoyTest.class.getResourceAsStream("test.pdf"));
        final byte[] jpg2 = ConverterFactoy.createConverter(IMAGE).toJpg(new ByteArrayInputStream(jpg1));
        final byte[] jpg3 = ConverterFactoy.createConverter(IMAGE).toJpg(ConverterFactoyTest.class.getResourceAsStream("test.png"));
        final URL resource = ConverterFactoyTest.class.getResource("");
        System.out.println(jpg1.length + "  - " + jpg2.length);
        final FileOutputStream output1 = new FileOutputStream(new File(resource.getFile(), "test1.jpg"));
        final FileOutputStream output2 = new FileOutputStream(new File(resource.getFile(), "test2.jpg"));
        final FileOutputStream output3 = new FileOutputStream(new File(resource.getFile(), "test3.jpg"));
        output1.write(jpg1);
        output2.write(jpg2);
        output3.write(jpg3);
        output1.close();
        output2.close();
        output3.close();
    }

}
