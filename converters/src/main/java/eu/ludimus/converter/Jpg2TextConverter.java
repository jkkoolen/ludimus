package eu.ludimus.converter;

import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;

public class Jpg2TextConverter {
    public static String toText(byte[] input) throws ConvertException {
        final Tesseract tesseract = new Tesseract();
        try {
            return tesseract.doOCR(ImageIO.read(new ByteArrayInputStream(input)));
        } catch(Exception e) {
            throw new ConvertException(e);
        }

    }
}
