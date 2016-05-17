package servlets.with_jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by sbt-yablokov-mv on 13.05.2016.
 */
public class Hello_TagImplementation extends TagSupport {
    private String myName = null;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (myName == null || myName.isEmpty()) {
                pageContext.getOut().write("Hello, JSP and TLD!");
            } else {
                pageContext.getOut().write("Hello, JSP and TLD! I'm " + myName);
            }
        } catch (IOException ioe) {
            throw new JspTagException(ioe.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public void release() {
        super.release();
        myName = null;
    }
}
