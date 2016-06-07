package use;

import java.util.List;

/**
 * Created by sbt-yablokov-mv on 07.06.2016.
 */
public interface MyProxyInterface2<T> {
    void setList(List<T> list);
    void setNotGenericData(Integer data);
}
