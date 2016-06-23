package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by sbt-yablokov-mv on 21.06.2016.
 */
public class MyFilter1 extends MyGenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("filterAttribute1", "attribute set by " + this.getClass().getCanonicalName());
        super.doFilter(servletRequest, servletResponse, filterChain);
    }
}
