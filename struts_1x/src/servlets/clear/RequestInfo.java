package servlets.clear;

import util.TableBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sbt-yablokov-mv on 11.05.2016.
 */
public class RequestInfo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<body>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        out.println("<body>");
        TableBuilder tableBuilder = new TableBuilder(out);
        tableBuilder.openTable("Request Information");
        tableBuilder.buildRow("Method", request.getMethod());
        tableBuilder.buildRow("Request URI", request.getRequestURI());
        tableBuilder.buildRow("Protocol", request.getProtocol());
        tableBuilder.buildRow("PathInfo", request.getPathInfo());
        tableBuilder.buildRow("Remote Address", request.getRemoteAddr());
        tableBuilder.buildRow("Remote Address", request.getRemoteAddr());
        tableBuilder.closeTable();
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
