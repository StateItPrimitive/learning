package servlets.with_jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by sbt-yablokov-mv on 13.05.2016.
 */
public class HelloJSP extends HttpServlet {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("servlets.with_jsp.LocalStrings");

    private String getBundleKeyName(HttpServletRequest request) {
        String useTLD = request.getParameter("useTLD");
        return "yes".equals(useTLD) ? "helloJSP_usingTLD.fullPathToJSP" : "helloJSP.fullPathToJSP";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> parametersMap = request.getParameterMap();

        String fullPathToJSP = RESOURCE_BUNDLE.getString(getBundleKeyName(request));
        getServletContext().getRequestDispatcher(fullPathToJSP + "?myName=Max").forward(request, response);

//        String relativePathToJSP = RESOURCE_BUNDLE.getString("helloJSP.relativePathToJSP");
//        request.getRequestDispatcher(relativePathToJSP + "?myName=Max").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
