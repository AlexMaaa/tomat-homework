package server.Mapper;

import lombok.Data;

import java.util.List;

/**
 * @author majm
 * @create 2020-03-01 20:30
 * @desc
 **/
@Data
public class Context {
    List<Wrapper> wrappers;

    public List<Wrapper> getWrappers() {
        return wrappers;
    }

    public void setWrappers(List<Wrapper> wrappers) {
        this.wrappers = wrappers;
    }
}
