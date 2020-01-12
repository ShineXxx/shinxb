package result;

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

    private boolean success = false;

    private String code;

    private String message;

    private T result;

    private ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.result = result;
        item.code = HTTPCODE_SUCCESS;
        item.message = "success";
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode, String errorMessage) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = errorMessage;
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = "failure";
        return item;
    }

    public boolean hasResult() {
        return result != null;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
