package eu.ludimus.ws;

import eu.ludimus.domain.entity.User;
import eu.ludimus.service.ticket.TicketService;
import eu.ludimus.service.user.UserService;
import eu.ludimus.ticket.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.text.SimpleDateFormat;
import java.util.Date;


@Endpoint
public class TicketEndpoint {
    private static final String TICKET_REQUEST = "ticketRequest";
    private final String NAMESPACE = "http://www.ludimus.eu/ticket/";
    
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    private ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();

    @Autowired
    private ObjectFactory ticketFactory;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    @PayloadRoot(localPart=TICKET_REQUEST, namespace=NAMESPACE)
    @ResponsePayload
    public TicketResponse ticketRequest(@RequestPayload TicketRequest request) {
    	TicketResponse response = ticketFactory.createTicketResponse();
    	if(! authorized(request.getSecurity()))
    		response.setError(getError(ERRORS.AUTHENTICATION_ERROR));
    	response.setSuccess("ok you successfully did some fiddling");
    	return response;
    }

    private boolean authorized(SecurityType security) {
    	String userName = security.getUserName();
    	String md5Password = security.getMd5Password();
    	String key = StringUtils.join(userName, md5Password, DATE_FORMAT.format(new Date()));
    	User user = userService.findByNameAndPassword(userName, md5Password);
    	if(user == null)
    		return false;
		return shaPasswordEncoder.encodePassword(key, null).equals(security.getSha1());
    }
    
    private ErrorType getError(ERRORS error) {
    	ErrorType errorType = ticketFactory.createErrorType();
    	errorType.setCode(error.getCode());
    	errorType.setMessage(error.getMessage());
    	return errorType;
    }

}
