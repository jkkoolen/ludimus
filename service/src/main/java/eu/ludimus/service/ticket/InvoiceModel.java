package eu.ludimus.service.ticket;

import eu.ludimus.service.utils.freemarker.FreeMarkerModel;

public class InvoiceModel implements FreeMarkerModel {
    private InvoiceProperties properties;

    public InvoiceModel(InvoiceProperties properties) {
        this.properties = properties;
    }
    @Override
    public String getTemplateFileName() {
        return "invoice.ftl";
    }

    public InvoiceProperties getProperties() {
        return properties;
    }
}
