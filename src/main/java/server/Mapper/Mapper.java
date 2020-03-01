package server.Mapper;

import lombok.Data;

import java.util.List;

/**
 * @author majm
 * @create 2020-03-01 20:29
 * @desc
 **/
@Data
public class Mapper {
    List<Host> hosts;

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }
}
