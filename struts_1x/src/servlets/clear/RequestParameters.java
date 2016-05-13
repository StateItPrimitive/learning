package servlets.clear;

import util.HTMLFilter;
import util.TableBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class RequestParameters extends HttpServlet {
    private static final String FORM_REQUEST_PARAMETER_NAME = "requestParameter";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Parameters</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Request Parameters</h3>");

        String requestParameter = request.getParameter(FORM_REQUEST_PARAMETER_NAME);
        if (requestParameter != null && !requestParameter.isEmpty()) {
            out.println("Got request parameter: " + HTMLFilter.filter(requestParameter) + "<br><br>");
        } else {
            out.println("No previous request parameter, Please enter some");
        }

        out.println("<form action=\"requestParameters\" method=GET>");
        out.println("Send new parameters by GET request:");
        out.println("<input type=text size=20 name=\"requestParameter\"><br>");
        out.println("<input type=\"submit\">");
        out.println("</form><br>");

        out.println("<form action=\"requestParameters\" method=POST>");
        out.println("Send new parameters by POST request:");
        out.println("<input type=text size=20 name=\"requestParameter\"><br>");
        out.println("<input type=\"submit\">");
        out.println("</form><br>");

        TableBuilder tableBuilder = new TableBuilder(out);

        Map<String, String[]> parametersMap = request.getParameterMap();
        if (!parametersMap.isEmpty()) {
            tableBuilder.openTable("Got url request parameters");
            for (Map.Entry<String, String[]> parameterEntry : parametersMap.entrySet()) {
                for (String parameterEntryValue : parameterEntry.getValue()) {
                    if (!parameterEntry.getKey().equals(FORM_REQUEST_PARAMETER_NAME))
                        tableBuilder.buildRow(parameterEntry.getKey(), parameterEntryValue);
                }
            }
            tableBuilder.closeTable();
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}