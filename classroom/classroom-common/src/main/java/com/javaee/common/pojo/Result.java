package com.javaee.common.pojo;

import com.javaee.common.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result(ResultType resultType, String msg) {
        this(resultType.getCode(), msg, null);
    }

    public Result(ResultType resultType, String msg, T data) {
        this(resultType.getCode(), msg, data);
    }


    public static<T> Result<T> resp(ResultType resultType,String msg,T data){
        return new Result<>(resultType,msg,data);
    }

    public static Result<Void> resp(ResultType resultType,String msg){
        return new Result<>(resultType,msg);
    }

    public static Result<Void> resp(int status,String msg){
        return new Result<>(status,msg,null);
    }


}
