package edu.cauc.cabin.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {

    /**
     * 业务码：200表示成功 其他表示异常，具体如下：
     *
     */
    private Integer code;

    //业务数据
    private T data;

    //提示信息
    private String msg;

    //时间戳
    private long timestamp;

    public static <T> ApiResult<T> buildSuccess(T data,String msg){
        return new ApiResult<>(200,data,msg,System.currentTimeMillis());
    }

    public static <T> ApiResult<T> buildSuccess(String msg){
        return new ApiResult<>(200,null,msg,System.currentTimeMillis());
    }

    public static <T> ApiResult<T> buildError(Integer code,T data,String msg){
        return new ApiResult<>(code,data,msg,System.currentTimeMillis());
    }

    public static <T> ApiResult<T> buildError(String msg){
        return new ApiResult<>(-1,null,msg,System.currentTimeMillis());
    }

}
