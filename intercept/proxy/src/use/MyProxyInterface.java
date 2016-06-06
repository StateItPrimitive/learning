package use;

/**
 * Created by sbt-yablokov-mv on 06.06.2016.
 */
public interface MyProxyInterface<T> {
    T getData();
    void setData(T data);
    void setNotGenericData(Integer data);
}
