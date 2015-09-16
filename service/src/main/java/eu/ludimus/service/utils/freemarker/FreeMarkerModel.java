package eu.ludimus.service.utils.freemarker;

/**
 * FreeMarkerModel is an interface which is used for the freemarker template engine.
 * The implementing class should add the template to the resource dir under the packagename
 * of the class provided.
 * e.g.
 *     src.main.java.mypackage.MyFreeMarkerModel
 *     refers to
 *     src/main/resources/mypackage/TemplateName.ftl
 */
public interface FreeMarkerModel {
    String getTemplateFileName();
}
