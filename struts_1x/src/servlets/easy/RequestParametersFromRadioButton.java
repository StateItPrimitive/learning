package servlets.easy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class RequestParametersFromRadioButton extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request radio button parameters</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Request radio button parameters</h3>");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry: parameterMap.entrySet()) {
            for (String entryValue: entry.getValue()) {
                out.println("got " + entry.getKey() + ": " + entryValue + "<br>");
            }
        }

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
