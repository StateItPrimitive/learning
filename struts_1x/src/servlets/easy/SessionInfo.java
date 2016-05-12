package servlets.easy;

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
    private static final String CONTEXT_INIT_PARAMETER_NAME = "contextInitParameterName";
    private static final String SERVLET_INIT_PARAMETER_NAME = "servletInitParameterName";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Parameters</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>All kind of parameters</h3>");

        HttpSession session = request.getSession(true);

        TableBuilder tableBuilder = new TableBuilder(out);
        tableBuilder.openTable("Session info");
        Date created = new Date(session.getCreationTime());
        Date accessed = new Date(session.getLastAccessedTime());
        tableBuilder.buildRow("ID", session.getId());
        tableBuilder.buildRow("Created", created.toString());
        tableBuilder.buildRow("Last Accessed", accessed.toString());
        tableBuilder.closeTable();

        // set session info if needed
        String dataName = request.getParameter("dataName");
        if (dataName != null && !dataName.isEmpty()) {
            String dataValue = request.getParameter("dataValue");
            session.setAttribute(dataName, dataValue);
        }

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