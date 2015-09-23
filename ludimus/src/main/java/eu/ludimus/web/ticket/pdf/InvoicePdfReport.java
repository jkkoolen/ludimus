package eu.ludimus.web.ticket.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import eu.ludimus.service.pdf.PdfConverter;
import eu.ludimus.service.ticket.InvoiceModel;
import eu.ludimus.service.ticket.InvoiceProperties;
import eu.ludimus.service.utils.freemarker.FreeMarkerHelper;
import eu.ludimus.web.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.util.Date;
import java.util.Map;

@org.springframework.stereotype.Component
public class InvoicePdfReport extends AbstractPdfView {
    final String DATA_KEY = "invoiceProperties";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String INLINE_FILENAME = "inline; filename=\"%s.pdf\"";
    @Autowired
    private PdfConverter pdfConverter;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public final ModelAndView createModelAndView(InvoiceProperties invoiceProperties) {
        return new ModelAndView(this,DATA_KEY, invoiceProperties);
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader(CONTENT_DISPOSITION, String.format(INLINE_FILENAME,String.format("Invoice_%s", Constants.suffix.format(new Date()))));

        final InvoiceProperties invoiceProperties = (InvoiceProperties) model.get(DATA_KEY);
        // CSS
        CSSResolver cssResolver = new StyleAttrCSSResolver();
        CssFile cssFile = XMLWorkerHelper.getCSS(InvoicePdfReport.class.getResourceAsStream("invoice.css"));
        cssResolver.addCss(cssFile);

        // HTML
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

        // XML Worker
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        p.parse(new StringReader(FreeMarkerHelper.convertModelToHtml(new InvoiceModel(invoiceProperties))));

    }
}
