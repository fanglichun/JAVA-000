package io.kimmking.rpcfx.api;

import lombok.Builder;
import lombok.Data;

/**
 * @creator fanglc@anchnet.com
 * @createdTime 2020/12/17 17:23
 * @desc
 */

@Data
@Builder
public class RpcfxException extends RuntimeException {

    private String errorCode;
    private String errorMsg;
    private Object errorMsgMap;
}
