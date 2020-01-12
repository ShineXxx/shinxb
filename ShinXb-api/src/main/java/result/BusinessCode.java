package result;

/**
 * 业务返回码
 */
public enum BusinessCode {

    DATA_RETURN("1","数据返回"),
    DATA_EMPTY("0","没有符合条件的数据"),
    PARAM_NOTMATCH("4001","请求参数不符合要求"),
    PARAM_INCORRECT("4002","参数值不符合格式和正确性"),
    NOresource("4004","资源中没有找到指定的资源"),
    Ultrapower("4003","当前用户越权"),
    server_issues("5000","服务器内部问题"),
    Create_Resource_success("2001","创建资源成功");

    private final String code;
    private final String info;

    private BusinessCode(String code,String info)
    {
        this.code = code;
        this.info=info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
