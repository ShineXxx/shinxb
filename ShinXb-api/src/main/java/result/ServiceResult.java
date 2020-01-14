package result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 *service层返回对象列表封装
 * @param <T>
 */
public class ServiceResult<T>  implements Serializable{

    public static final String HTTPCODE_SUCCESS="200";
    public static final String HTTPCODE_CREATED="201";
    public static final String HTTPCODE_REQUEST_ERROR="400";
    public static final String HTTPCODE_FORBIDDEN="403";
    public static final String HTTPCODE_SERVER_ERROR="500";
    public static final String HTTPCODE_FILE_NOTFIND="404";

    private Status status;

    private T result;

    private ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.result = result;
        item.status = new Status(HTTPCODE_SUCCESS,"success");
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode, String errorMessage) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = new Status(errorCode,errorMessage);
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = new Status(errorCode);
        return item;
    }

    public boolean hasResult() {
        return result != null;
    }

    public T getResult() {
        return result;
    }

    public Status getStatus() {
        return status;
    }

    @Data
    @AllArgsConstructor
    public static class Status {
        private String code;
        private String msg;

        public Status(String code) {
            this.code = code;
        }
    }
}
