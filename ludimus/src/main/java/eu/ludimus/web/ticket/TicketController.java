package eu.ludimus.web.ticket;

import eu.ludimus.service.authentication.LudimusSecurityContext;
import eu.ludimus.service.dto.TicketDto;
import eu.ludimus.service.ticket.TicketService;
import eu.ludimus.web.Constants;
import eu.ludimus.web.utility.UploadException;
import eu.ludimus.web.utility.UploadHandler;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/user/ticket")
public class TicketController {
    private static final String TICKET_VIEW = "/user/ticket/ticket";
    private static final String TICKET_REPORT_VIEW = "/user/ticket/reports";
    private static final String TICKET_DTO = "ticketDto";
    private static final String REPORT_CRITERIA = "reportCriteria";
    private static final String TICKET_IMAGE_FIELD = "ticketImage";
    @Autowired
    private TicketService ticketService;
    @Autowired
    private LudimusSecurityContext ludimusSecurityContext;
    @Autowired
    private UploadHandler uploadHandler;

    @Autowired
    private VATExcelReport vatExcelReport;

    @Autowired
    private TicketPdfReport ticketPdfReport;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

//        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @ModelAttribute("months")
    public int[] getMonths() {
        return new int[]{
                Calendar.JANUARY
                ,Calendar.FEBRUARY
                ,Calendar.MARCH
                ,Calendar.APRIL
                ,Calendar.MAY
                ,Calendar.JUNE
                ,Calendar.JULY
                ,Calendar.AUGUST
                ,Calendar.SEPTEMBER
                ,Calendar.OCTOBER
                ,Calendar.NOVEMBER
                ,Calendar.DECEMBER
        };
    }

    @ModelAttribute("reportTypes")
    public List<ReportCriteria.Type> getReportTypes() {
        return Arrays.asList(ReportCriteria.Type.TAX_EXPORT,
                ReportCriteria.Type.PDF_EXPORT,
                ReportCriteria.Type.OVERVIEW);
    }

    @ModelAttribute("periods")
    public final List<Pair<Integer, String>> getPeriods() {
        return Arrays.asList(Pair.of(-1, "ticket.report.nochoice")
            ,Pair.of(0,"ticket.report.q1")
            ,Pair.of(1,"ticket.report.q2")
            ,Pair.of(2,"ticket.report.q3")
            ,Pair.of(3,"ticket.report.q4")
            ,Pair.of(4,"ticket.report.thisyear"));
    }

    @ModelAttribute("vatValues")
    public final VAT[] getVatValues() {
        return VAT.values();
    }

    @RequestMapping(value = "/ticket")
    public String ticket(Model model) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setUser(ludimusSecurityContext.getUserDto());
        model.addAttribute(TICKET_DTO, ticketDto);
        return TICKET_VIEW;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @Valid @ModelAttribute TicketDto ticketDto, BindingResult result, @RequestParam("file") MultipartFile file) {
        if(uploadHandler.isPdf(file)) {
            try {
                ticketDto.setTicketImage(uploadHandler.pdfToJpg(file));
            } catch (UploadException e) {
                result.addError(new FieldError(TICKET_DTO, TICKET_IMAGE_FIELD, e.getMessage()));
            }
        } else if(uploadHandler.isJpg(file)) {
            try {
                ticketDto.setTicketImage(IOUtils.toByteArray(file.getInputStream()));
            } catch (IOException e) {
                result.addError(new FieldError(TICKET_DTO, TICKET_IMAGE_FIELD, e.getMessage()));
            }
        } else {
            result.addError(new FieldError(TICKET_DTO, TICKET_IMAGE_FIELD, "Not a valid jpg or a 1 page pdf, file"));
        }
        if(result.hasErrors()) {
            return TICKET_VIEW;
        }
        ticketDto.setUser(ludimusSecurityContext.getUserDto());
        ticketService.save(ticketDto);
        model.addAttribute(Constants.SUCCESS_KEY, "ticket.save.success");
        return ticket(model);
    }

    @RequestMapping(value = "/reports")
    public String report(Model model) {
        model.addAttribute(REPORT_CRITERIA, new ReportCriteria());
        return TICKET_REPORT_VIEW;
    }

    @RequestMapping(value="/report", method = RequestMethod.POST)
    public ModelAndView showReport(Model model, @Valid @ModelAttribute ReportCriteria criteria, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView(TICKET_REPORT_VIEW);
        }
        final List<TicketDto> list = ticketService.findBetweenTicketDate(ludimusSecurityContext.getUser(), criteria.getFromDate(), criteria.getToDate());
        if(list.isEmpty()) {
            model.addAttribute(Constants.WARNING_KEY, "error.notickets");
            return new ModelAndView(TICKET_REPORT_VIEW);
        }
        if(criteria.getType() == ReportCriteria.Type.TAX_EXPORT) {
            return vatExcelReport.createModelAndView(list);
        } else if(criteria.getType() == ReportCriteria.Type.PDF_EXPORT) {
            return ticketPdfReport.createModelAndView(list);
        } else if(criteria.getType() == ReportCriteria.Type.OVERVIEW) {
            model.addAttribute("list", list);
        }
        return new ModelAndView(TICKET_REPORT_VIEW);
    }
}
