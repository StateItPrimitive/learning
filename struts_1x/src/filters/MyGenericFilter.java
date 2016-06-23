package filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sbt-yablokov-mv on 21.06.2016.
 */
public class MyGenericFilter implements Filter {
    public FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        System.out.println("init " + this.getClass().getCanonicalName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("preprocessing request: doFilter " + this.getClass().getCanonicalName());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("postprocessing response: doFilter " + this.getClass().getCanonicalName());
    }

    @Override
    public void destroy() {
        System.out.println("destroy " + this.getClass().getCanonicalName());
    }
}
