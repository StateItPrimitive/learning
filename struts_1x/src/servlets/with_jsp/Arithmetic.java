package servlets.with_jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by sbt-yablokov-mv on 16.05.2016.
 */
public class Arithmetic extends HttpServlet {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("resources/servlets");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");

        String fullPathToJSP = RESOURCE_BUNDLE.getString("arithmeticJSP.fullPathToJSP");
        getServletContext().getRequestDispatcher(fullPathToJSP).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
