package servlets.clear;

import util.TableBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

public class SessionInfo extends HttpServlet {
    public static final String SESSION_ATTRIBUTE_NAME = "sessionAttributeName";
    public static final String SESSION_ATTRIBUTE_VALUE = "sessionAttributeValue";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + this.getClass().getName() + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Session info</h3>");

        HttpSession session = request.getSession(true);

        TableBuilder tableBuilder = new TableBuilder(out);
        tableBuilder.openTable("Session info");
        Date created = new Date(session.getCreationTime());
        Date accessed = new Date(session.getLastAccessedTime());
        tableBuilder.buildRow("ID", session.getId());
        tableBuilder.buildRow("Created", created.toString());
        tableBuilder.buildRow("Last Accessed", accessed.toString());
        tableBuilder.closeTable();

        String sessionAttributeName = request.getParameter(SESSION_ATTRIBUTE_NAME);
        String sessionAttributeValue = request.getParameter(SESSION_ATTRIBUTE_VALUE);
        if (sessionAttributeName != null && !sessionAttributeName.isEmpty())
            if (sessionAttributeValue != null && !sessionAttributeValue.isEmpty())
                session.setAttribute(sessionAttributeName, sessionAttributeValue);

        out.println("<form action=\"sessionInfo\" method=POST>");
        out.println("Send new parameters by POST request:<br>");
        out.println("Session attribute name<input type=text size=20 name=" + SESSION_ATTRIBUTE_NAME + "><br>");
        out.println("Session attribute value<input type=text size=20 name=" + SESSION_ATTRIBUTE_VALUE + "><br>");
        out.println("<input type=\"submit\">");
        out.println("</form><br>");

        tableBuilder.openTable("Session content");
        for (Enumeration attributeNames = session.getAttributeNames(); attributeNames.hasMoreElements();) {
            String name = (String)attributeNames.nextElement();
            String value = session.getAttribute(name).toString();
            tableBuilder.buildRow(name, value);
        }
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