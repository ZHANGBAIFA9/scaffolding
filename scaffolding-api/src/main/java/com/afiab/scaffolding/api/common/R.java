package com.afiab.scaffolding.api.common;


import com.afiab.scaffolding.api.constants.SysConstants;
import com.afiab.scaffolding.api.enums.BusinessEnumCode;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:06
 * @Description:
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = -460549334438152993L;

    private String code;
    private String message;
    /**
     * 如果返回对象是一个map或者list，为空时建议设置data为 new HashMap / new ArrayList() ，而不是返回null。
     */
    private T data;

    private Date now = new Date();

    /**
     * 业务端返回的响应编码
     */
    private String bizCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }


    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public R() {

    }

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public R(BusinessEnumCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public R(BusinessEnumCode code, T data) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
    }

    /**
     * 成功
     * @return
     */
    public static R success(){
        return new R(CodeManager.CommonCode.CODE_0000000,"");
    }

    public static<T> R<T> success(Object data){
        return new R(CodeManager.CommonCode.CODE_0000000,"",data);
    }

    public static<T> R<T> success(String message, Object data){
        return new R(CodeManager.CommonCode.CODE_0000000,message,data);
    }


    /**
     * 失败
     * @return
     */
    public static<T> R<T> error(String code, String message){
        if(BusinessEnumCode.UNKNOW_ERROR.getCode().equals(code) && StringUtils.isEmpty(message)){
            message = "空异常";
        }
        return new R<T>(code,message);
    }

    public static<T> R<T> error(R r){
        return new R<T>(r.getCode(), r.getMessage());
    }

    public static<T> R<T> error(BusinessEnumCode code){
        return new R<T>(code);
    }

    public static<T> R<T> error(BusinessEnumCode code, boolean insertTip, String insertWord){
        String newMessage = code.getMessage().replace(SysConstants.MESSAGE_INSERT_INDICATE, insertWord);//CommonConstants
        return new R<T>(code.getCode(),newMessage);
    }

    public static<T> R<T> error(BusinessEnumCode code, Object data){
        return new R(code,data);
    }
    public static<T> R<T> error(BusinessEnumCode code, String msg){
        return new R<T>(code.getCode(),code.getMessage() + decorateMsg(msg));
    }

    public boolean isSuccess(){
        return Objects.deepEquals(CodeManager.CommonCode.CODE_0000000,code);
    }

    public boolean isSuccessAndData(){
        return Objects.deepEquals(CodeManager.CommonCode.CODE_0000000,code) && !isSuccessAndEmpty();
    }

    public boolean isSuccessAndEmpty(){
        return Objects.deepEquals(CodeManager.CommonCode.CODE_0000000,code) &&
                (Objects.isNull(data) ||
                        (data instanceof Collection && CollectionUtils.isEmpty((Collection)data)) ||
                        (data instanceof Map && CollectionUtils.isEmpty((Map)data))
                );
    }

    private static String decorateMsg(String msg){
        if(StringUtils.isEmpty(msg)){
            msg = "";
        }else{
            msg = "[" + msg + "]";
        }
        return msg;
    }

    @Override
    public String toString() {
        return "R{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", now=" + now +
                '}';
    }
}
