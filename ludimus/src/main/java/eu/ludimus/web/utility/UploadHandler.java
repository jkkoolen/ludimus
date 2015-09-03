package eu.ludimus.web.utility;

import eu.ludimus.service.pdf.ConvertException;
import eu.ludimus.service.pdf.PdfConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class UploadHandler {
    @Autowired
    private PdfConverter pdfConverter;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public boolean isPdf(MultipartFile file) {
        if(file == null || file.getContentType() == null) {
            return false;
        }
        return file.getContentType().toLowerCase().endsWith("pdf");
    }

    public boolean isJpg(MultipartFile file) {
        if(file == null || file.getContentType() == null) {
            return false;
        }
        return file.getContentType().toLowerCase().endsWith("jpg") ||
                file.getContentType().toLowerCase().endsWith("jpeg");
    }

    public byte[] pdfToJpg(MultipartFile part) throws UploadException {
        if(!isPdf(part)) {
            throw new UploadException("File is not a pdf file");
        }

        try {
            return pdfConverter.toJpg(part.getInputStream());
        } catch (ConvertException e) {
            logger.error(e.getMessage(), e);
            throw new UploadException(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new UploadException(e.getMessage());
        }
    }
}
