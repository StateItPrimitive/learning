package util;

import java.io.PrintWriter;

/**
 * Created by sbt-yablokov-mv on 12.05.2016.
 */
public class TableBuilder {
    private PrintWriter out;

    public TableBuilder(PrintWriter out) {
        this.out = out;
    }

    public void openTable() {
        openTable(null);
    }

    public void openTable(String caption) {
        out.println("<table border=0>");
        if (caption != null && !caption.isEmpty()) {
            out.println("<caption><b>" + caption + "</b></caption>");
        }
    }

    public void buildRow(String requestParmName, String requestParmValue) {
        out.println("<tr> <td><b>" + HTMLFilter.filter(requestParmName) + "</b></td> <td>" + HTMLFilter.filter(requestParmValue) + "</td> </tr>");
    }

    public void closeTable(){
        out.println("</table><br>");
    }
}
