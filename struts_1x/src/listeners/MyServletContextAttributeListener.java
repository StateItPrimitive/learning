package listeners;

import logging.MyLogger;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import java.util.Enumeration;

/**
 * Created by sbt-yablokov-mv on 23.06.2016.
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    public static final Logger logger = MyLogger.logger;

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attributesInfo = "attributeAdded\n" + getAttributesInfo(servletContextAttributeEvent.getServletContext());
        logger.error(attributesInfo);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attributesInfo = "attributeRemoved\n" + getAttributesInfo(servletContextAttributeEvent.getServletContext());
        logger.trace(attributesInfo);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attributesInfo = "attributeReplaced\n" + getAttributesInfo(servletContextAttributeEvent.getServletContext());
        logger.info(attributesInfo);
    }

    private static String getAttributesInfo(ServletContext servletContext) {
        String result = "current attribute list:";
        for (Enumeration<String> attributeNames = servletContext.getAttributeNames(); attributeNames.hasMoreElements();) {
            String attributeName = attributeNames.nextElement();
            result += "\nattribute: " + attributeName + " = " + servletContext.getAttribute(attributeName);
        }
        return result;
    }
}
