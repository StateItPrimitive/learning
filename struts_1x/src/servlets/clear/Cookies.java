package servlets.clear;

import util.TableBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Cookies extends HttpServlet {
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
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            tableBuilder.openTable("Cookie list");
            for (Cookie cookie: cookies) {
                tableBuilder.buildRow(cookie.getName(), cookie.getValue());
            }
            tableBuilder.closeTable();
        }

        String name = request.getParameter("cookieName");
        if (name != null && !name.isEmpty()) {
            tableBuilder.openTable("Got cookie:");
            String value = request.getParameter("cookieValue");
            tableBuilder.buildRow("Cookie name", name);
            tableBuilder.buildRow("Cookie value", value);

            // set a cookie
            Cookie cookie = new Cookie(name, value);
            response.addCookie(cookie);
        }
        tableBuilder.closeTable();

        out.println("<form action=\"cookies\" method=POST>");
        out.println("Create a cookie to send to your browser:<br>");
        out.println("Name: <input type=text size=20 name=\"cookieName\"><br>");
        out.println("Value: <input type=text size=20 name=\"cookieValue\"><br>");
        out.println("<input type=\"submit\">");
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