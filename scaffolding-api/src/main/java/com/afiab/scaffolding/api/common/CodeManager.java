package com.afiab.scaffolding.api.common;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:10
 * @Description:
 */
public class CodeManager {
    /**
     * 系统前缀码
     */
    public interface SystemCode{
        /**
         * 数据研发系统
         */
        String CODE_RD = "01";
    }

    /**
     * 子系统编码
     */
    public interface SubSystemCode{
        /**
         * 默认为00
         */
        String CODE_RD_SUB = "00";

        /**
         * 其他系统
         */
        String CODE_AUDIT_SUB = "01";
    }

    /**
     * 通用返回码
     */
    public interface CommonCode {


        /**
         * 操作成功
         */
        String CODE_0000000 = "0000000";

        /**
         * 参数为空
         */
        String CODE_0000001 = "0000001";

        /**
         * 参数不足
         */

        String CODE_0000002 = "0000002";

        /**
         * 数据已存在
         */
        String CODE_0000003 = "0000003";

        /**
         * 数据不存在
         */
        String CODE_0000004 = "0000004";

        /**
         * 数据库异常
         */
        String CODE_0000005 = "0000005";

    }

}
