package eu.ludimus.service.pdf;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class DefaultPdfConverter implements PdfConverter{

    public static final String JPG_FORMAT_NAME = "jpg";

    @Override
    public byte[] toJpg(InputStream pdf) throws ConvertException{
        if(pdf == null) {
            throw new ConvertException("input cannot be null");
        }
        try {
            PDDocument document = PDDocument.load(pdf);
            final List pages = document.getDocumentCatalog().getAllPages();
            if(pages.size() != 1) {
                throw new ConvertException("pdf should contain only 1 page");
            }
            final PDPage pdPage = (PDPage) pages.get(0);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(pdPage.convertToImage(), JPG_FORMAT_NAME, bao);
            return bao.toByteArray();
        } catch (IOException e) {
            throw new ConvertException(e);
        }
    }
}
