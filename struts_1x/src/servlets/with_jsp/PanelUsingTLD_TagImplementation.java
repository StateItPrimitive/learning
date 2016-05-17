package servlets.with_jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PanelUsingTLD_TagImplementation extends SimpleTagSupport {
    private int num;

    @Override
    public void doTag() throws JspException, IOException {
        for (int i = 0; i < num; i++) {
            getJspContext().setAttribute("count", String.valueOf(i + 1));
            getJspBody().invoke(null);
        }
    }

    public void setNum(int num) {
        this.num = num;
    }
}
