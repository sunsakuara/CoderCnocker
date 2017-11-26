package net.zhuruyi.bbs.response;

import java.io.Serializable;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 23:32 2017/11/23
 * @Modified By:
 */
public class Response<T> implements Serializable {

    /**
     * 0:代表失败，1：代表成功
     */
    private int code = 0;
    /**
     * 存储的信息
     */
    private String message = "";

    private T data;

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
