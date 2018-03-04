package eu.ludimus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.ludimus.exception.InvalidException;
import eu.ludimus.model.ErrorInfo;
import eu.ludimus.model.Kmr;
import eu.ludimus.model.User;
import eu.ludimus.model.googleapi.DistanceResponse;
import eu.ludimus.security.UserRequestUtil;
import eu.ludimus.service.KmrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class DistanceMatrixServiceController {
    @Autowired
    private KmrService kmrService;
    @Autowired
    private UserRequestUtil userRequestUtil;

    @Value("${google.mapsUrl}")
    private String mapsUrl;
    private ObjectMapper mapper = new ObjectMapper();

    @CrossOrigin
    @RequestMapping(value = "/ludimus/distance", method = RequestMethod.GET)
    @ResponseBody
    public DistanceResponse getDistance(final @RequestParam String origins, final @RequestParam String destinations) throws IOException {
        final InputStream inputStream = createUrl(origins, destinations).getInputStream();
        final byte[] bytes = IOUtils.toByteArray(inputStream);
        final DistanceResponse distanceResponse = mapper.readValue(bytes, DistanceResponse.class);
        return distanceResponse;
    }

    @CrossOrigin
    @RequestMapping(value = "/ludimus/addKmr", method = RequestMethod.POST)
    @ResponseBody
    public Kmr addKmr(final @RequestBody Kmr kmr) {
        kmr.setUser(userRequestUtil.getUser());
        final Kmr lastKmr = kmrService.getLastKmr(kmr.getUser().getId());
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
    public List<Kmr> getOverview(final @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date from,
                                 final @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date to) {
        log.info("getKmrOverview with from : {} and to : {}", from, to);
        return kmrService.getAllKmr(userRequestUtil.getUser().getId(), from, to);
    }

    private HttpsURLConnection createUrl(final String origins, final String destinations) throws IOException {
        return (HttpsURLConnection) new URL(String.format("%s?origins=%s&destinations=%s&key=AIzaSyC40StbkB4K95HIPUdWufzvF1QDSUPzJQ4", mapsUrl, URLEncoder.encode(origins, "utf-8"), URLEncoder.encode(destinations, "utf-8"))).openConnection();
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ErrorInfo invalid(final InvalidException e) {
        return new ErrorInfo("BAD_REQUEST", e.getMessage());

    }
}
