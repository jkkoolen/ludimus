package eu.ludimus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.ludimus.exception.InvalidException;
import eu.ludimus.model.ErrorInfo;
import eu.ludimus.model.Kmr;
import eu.ludimus.model.User;
import eu.ludimus.model.googleapi.DistanceResponse;
import eu.ludimus.service.Auth0Service;
import eu.ludimus.service.KmrService;
import org.apache.pdfbox.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class DistanceMatrixServiceController {
    @Autowired
    private Auth0Service auth0Service;
    @Autowired
    private KmrService kmrService;
    private static Logger logger = LoggerFactory.getLogger(DistanceMatrixServiceController.class);
    private ObjectMapper mapper = new ObjectMapper();

    @CrossOrigin
    @RequestMapping(value = "/ludimus/distance", method = RequestMethod.GET)
    @ResponseBody
    public DistanceResponse getDistance(final @RequestParam String origins, final @RequestParam String destinations) throws ParseException, InterruptedException, IOException {
        final InputStream inputStream = createUrl(origins, destinations).getInputStream();
        final byte[] bytes = IOUtils.toByteArray(inputStream);
        final DistanceResponse distanceResponse = mapper.readValue(bytes, DistanceResponse.class);
        return distanceResponse;
    }

    @CrossOrigin
    @RequestMapping(value = "/ludimus/addKmr", method = RequestMethod.POST)
    @ResponseBody
    public Kmr addKmr(final HttpServletRequest request, final @RequestBody Kmr kmr) throws ParseException, InterruptedException, IOException {
        logger.info(kmr.toString());
        final User user = User.builder().build();
        final Long userId = auth0Service.idFromAuthorizationHeader(request.getHeader("Authorization"));
        user.setId(userId);
        kmr.setUser(user);
        final Kmr lastKmr = kmrService.getLastKmr(userId);
        if(lastKmr != null && lastKmr.getEndTotal() - kmr.getStartTotal() > 5) { //if difference is more then 5 km throw exception
            throw new InvalidException("Difference to big with last registration, probably you mist one");
        }
        if(lastKmr != null) {
            kmr.setStartTotal(lastKmr.getEndTotal()); //to make it watertight
        }
        return kmrService.addKmr(kmr);
    }

    @CrossOrigin
    @RequestMapping(value = "/ludimus/kmrOverview", method = RequestMethod.GET)
    @ResponseBody
    public List<Kmr> getOverview(final HttpServletRequest request,
                                    final @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date from,
                                    final @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date to) throws ParseException {
        logger.info("getKmrOverview with from : {} and to : {}", from, to);
        return kmrService.getAllKmr(auth0Service.idFromAuthorizationHeader(request.getHeader("Authorization")), from, to);
    }

    private HttpsURLConnection createUrl(final String origins, final String destinations) throws IOException {
        return (HttpsURLConnection) new URL(String.format("https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s&key=AIzaSyC40StbkB4K95HIPUdWufzvF1QDSUPzJQ4", URLEncoder.encode(origins, "utf-8"), URLEncoder.encode(destinations, "utf-8"))).openConnection();
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ErrorInfo invalid(final InvalidException e) {
        return new ErrorInfo("BAD_REQUEST", e.getMessage());

    }
}
