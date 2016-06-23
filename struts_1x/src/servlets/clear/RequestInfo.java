package servlets.clear;

import util.TableBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

        tableBuilder.openTable("Request attributes");
        for (Enumeration attributeNames = request.getAttributeNames(); attributeNames.hasMoreElements();) {
            String name = (String)attributeNames.nextElement();
            String value = request.getAttribute(name).toString();
            tableBuilder.buildRow(name, value);
        }
        tableBuilder.closeTable();

        getServletContext().setAttribute("attributeName1", "attributeValue1");
        getServletContext().setAttribute("attributeName2", "attributeValue2");
        getServletContext().setAttribute("attributeName3", "attributeValue3");

        out.println("<form action=\"sessionInfo\" method=POST>");
        out.println("Send new parameters by POST request:<br>");
        out.println("Session attribute name<input type=text size=20 name=" + SessionInfo.SESSION_ATTRIBUTE_NAME + "><br>");
        out.println("Session attribute value<input type=text size=20 name=" + SessionInfo.SESSION_ATTRIBUTE_VALUE + "><br>");
        out.println("<input type=\"submit\">");
        out.println("</form><br>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
