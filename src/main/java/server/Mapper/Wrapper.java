package server.Mapper;

import lombok.Data;
import server.Servlet;

/**
 * @author majm
 * @create 2020-03-01 20:30
 * @desc
 **/
@Data
public class Wrapper {
    String urlpatten;
    Servlet Servlet;

    public Wrapper(String urlpatten, server.Servlet servlet) {
        this.urlpatten = urlpatten;
        Servlet = servlet;
    }

    public String getUrlpatten() {
        return urlpatten;
    }

    public void setUrlpatten(String urlpatten) {
        this.urlpatten = urlpatten;
    }

    public server.Servlet getServlet() {
        return Servlet;
    }

    public void setServlet(server.Servlet servlet) {
        Servlet = servlet;
    }
}
