package server;

import server.Mapper.Context;
import server.Mapper.Host;
import server.Mapper.Mapper;
import server.Mapper.Wrapper;

import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class RequestProcessor extends Thread {

    private Socket socket;
    private Map<String, HttpServlet> servletMap;
    private Mapper mapper;

    public RequestProcessor(Socket socket, Map<String, HttpServlet> servletMap, Mapper mapper) {
        this.socket = socket;
        this.servletMap = servletMap;
        this.mapper = mapper;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();

            // 封装Request对象和Response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());
            HttpServlet s = (HttpServlet) getWrapper(request, request.getUrl());
            // 静态资源处理
            if (servletMap.get(request.getUrl()) != null) {
                // 动态资源servlet请求
                HttpServlet httpServlet = servletMap.get(request.getUrl());
                httpServlet.service(request, response);
            } else if (s != null) {
                s.service(request, response);
            } else {
                response.outputHtml(request.getUrl());
            }
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private Servlet getWrapper(Request request, String url) {
        List<Host> hosts = mapper.getHosts();
        for (Host host : hosts) {
            if (host.getHostName().trim().equals(request.getHostName().trim())) {
                List<Context> contexts = host.getContexts();
                for (Context context : contexts) {
                    List<Wrapper> wrappers = context.getWrappers();
                    for (Wrapper wrapper : wrappers) {
                        if (wrapper.getUrlpatten().equals(url)) {
                            return wrapper.getServlet();
                        }
                    }

                }
            }
        }

        return null;
    }
}
