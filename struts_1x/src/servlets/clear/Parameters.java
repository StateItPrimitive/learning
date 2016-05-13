package servlets.clear;

import util.TableBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Parameters extends HttpServlet {
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

        TableBuilder tableBuilder = new TableBuilder(out);
        tableBuilder.openTable();
        String contextInitParameterValue = getServletContext().getInitParameter(CONTEXT_INIT_PARAMETER_NAME);
        if (contextInitParameterValue != null) {
            tableBuilder.buildRow(CONTEXT_INIT_PARAMETER_NAME, contextInitParameterValue);
        }

        String servletInitParameterValue = getServletConfig().getInitParameter(SERVLET_INIT_PARAMETER_NAME);
        if (servletInitParameterValue != null) {
            tableBuilder.buildRow(SERVLET_INIT_PARAMETER_NAME, servletInitParameterValue);
        }
        tableBuilder.closeTable();

        out.println("<form action=\"requestParameters?urlRequestParm1Name=urlRequestParm1Value&urlRequestParm2Name=urlRequestParm2Value\" method=POST>");
        out.println("Request parameter:");
        out.println("<input type=text size=20 name=\"requestParameter\"> <br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");

        out.println("<form action=\"requestParametersFromRadioButton\" method=POST>");
        out.println("<p><input type=\"radio\" name=\"radioButtonParameter\" value=\"value1\">Значение №1<br>");
        out.println("<input type=\"radio\" name=\"radioButtonParameter\" value=\"value2\">Значение №2<br>");
        out.println("<input type=\"radio\" name=\"radioButtonParameter\" value=\"value3\">Значение №3</p>");
        out.println("<p><input type=\"submit\"></p>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}