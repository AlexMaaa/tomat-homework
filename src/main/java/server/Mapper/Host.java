package server.Mapper;

import lombok.Data;

import java.util.List;

/**
 * @author majm
 * @create 2020-03-01 20:30
 * @desc
 **/
@Data
public class Host {
    String hostName;
    List<Context> contexts;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }
}
