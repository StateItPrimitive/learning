package servlets.with_jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by sbt-yablokov-mv on 17.05.2016.
 */
public class Tiles extends HttpServlet {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("resources/servlets");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");

        String fullPathToJSP = RESOURCE_BUNDLE.getString("jsp.tiles.myTile.fullPath");
        getServletContext().getRequestDispatcher(fullPathToJSP).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}