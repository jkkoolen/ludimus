package eu.ludimus.service.ticket;

import eu.ludimus.service.dto.AddressDto;
import eu.ludimus.service.dto.UserDto;
import eu.ludimus.service.utils.freemarker.FreeMarkerHelper;
import org.junit.Test;

import java.util.Date;

public class DefaultTicketServiceTest {

    @Test
    public void testCreateInvoice() throws Exception {
        final InvoiceProperties invoiceProperties = createInvoiceProperties();
        final String html = FreeMarkerHelper.convertModelToHtml(new InvoiceModel(invoiceProperties));
        System.out.println(html);
    }

    private InvoiceProperties createInvoiceProperties() {
        final InvoiceProperties properties = new InvoiceProperties();
        properties.setUser(new UserDto());
        final UserDto userDto = properties.getUser();
        userDto.setBank("Rabobank");
        userDto.setVatNumber("NL152819502B01");
        userDto.setBic("RABONL2U");
        userDto.setCoc(60892528l);
        userDto.setIban("NL03RABO0165839546");
        userDto.setFullName("Jan-Karel Koolen");
        properties.setInvoiceNumber("jk0000012");
        properties.setAddress(new AddressDto());
        final AddressDto address = properties.getAddress();
        address.setStreetNumber("137");
        address.setPostalcode("1087GC");
        address.setCity("Amsterdam");
        address.setStreet("Mattenbiesstraat");
        properties.setDescription("Voor Consultancy Services verleend door:" + "Jan-Karel Koolen".toUpperCase());
        properties.setEndPeriod(new Date());
        properties.setFare(77.5);
        properties.setUnits(121.0);
        return properties;

    }
}