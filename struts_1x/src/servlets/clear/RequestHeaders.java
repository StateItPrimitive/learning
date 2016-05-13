package servlets.clear;

import util.TableBuilder;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestHeaders extends HttpServlet {
    private String getTableRow(String requestParmName, String requestParmValue) {
        return "<tr> <td><b>" + requestParmName + " :</b></td> <td>" + requestParmValue + "</td> </tr>";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        out.println("<body>");
        TableBuilder tableBuilder = new TableBuilder(out);
        tableBuilder.openTable("Request Information Example");
        for (Enumeration headerNames = request.getHeaderNames(); headerNames.hasMoreElements();) {
            String name = (String)headerNames.nextElement();
            String value = request.getHeader(name);
            tableBuilder.buildRow(name, value);
        }
        tableBuilder.closeTable();
        out.println("</body>");
        out.println("</html>");
    }
}
