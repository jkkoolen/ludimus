package eu.ludimus.converter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.pdfbox.pdmodel.PDDocument.load;

class Pdf2JpgConverter implements JpgConverter {
    public static final String JPG_FORMAT_NAME = "jpg";

    @Override
    public byte[] toJpg(InputStream input) throws ConvertException {
        if(input == null) {
            throw new ConvertException("input cannot be null");
        }
        PDDocument document = null;
        try {
            document = load(input);
            if(document.getNumberOfPages() != 1) {
                throw new ConvertException("pdf should contain only 1 page");
            }
            final PDPage pdPage = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(pdPage.convertToImage(), JPG_FORMAT_NAME, bao);
            return bao.toByteArray();
        } catch (IOException e) {
            throw new ConvertException(e);
        }
    }
}
