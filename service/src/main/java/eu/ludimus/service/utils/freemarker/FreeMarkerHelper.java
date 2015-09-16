package eu.ludimus.service.utils.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;

public final class FreeMarkerHelper {
    private FreeMarkerHelper() {
        //avoid overiding
    }
    public static final String convertModelToHtml(FreeMarkerModel model) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(model.getClass(), "");
        Template template = configuration.getTemplate(model.getTemplateFileName());
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }
}
