package eu.ludimus.web.ticket.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import eu.ludimus.service.dto.TicketDto;
import eu.ludimus.web.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Component
public class TicketPdfReport extends AbstractPdfView {
    final String DATA_KEY = "ticketDtoList";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String INLINE_FILENAME = "inline; filename=\"%s.pdf\"";
    public static final String EURO = " , € ";
    public static final float ROTATE_RIGHT = -90f;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public final ModelAndView createModelAndView(List<TicketDto> ticketDtoList) {
        return new ModelAndView(this,DATA_KEY, ticketDtoList);
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader(CONTENT_DISPOSITION, String.format(INLINE_FILENAME,String.format("TicketReport%s", Constants.suffix.format(new Date()))));

        final List<TicketDto> ticketDtoList = (List<TicketDto>) model.get(DATA_KEY);
        try {
            for(TicketDto t : ticketDtoList) {
                document.add(new Paragraph(t.getInvoiceNumber() + EURO + t.getPrice()));
                if(t.getBase64Image() != null) { //no ticket available
                    final java.awt.Image image = Toolkit.getDefaultToolkit().createImage(Base64.decode(t.getBase64Image()));
                    document.add(getOptimalFit(Image.getInstance(image, Color.white), document));
                } else {
                    document.add(new Paragraph(t.getDescription()));
                }
                document.newPage();
            }
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private Image getOptimalFit(Image image, Document document) {
        float percentage;
        final float width = image.getWidth();
        final float height = image.getHeight();
        float effectivePageWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
        if(width > height) {
            image.setRotationDegrees(ROTATE_RIGHT);
            percentage = effectivePageWidth / width;
        } else {
            percentage = effectivePageWidth / height;
        }
        if(((double)percentage) < 1) { //to big to fit
            image.scalePercent(percentage * 110);
        }
        return image;
    }
}
