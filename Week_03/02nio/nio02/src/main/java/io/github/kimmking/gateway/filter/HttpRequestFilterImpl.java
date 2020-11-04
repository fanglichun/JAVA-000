package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @ClassName HttpRequestFilterHander
 * @Description
 * @Author fanglichun
 * @Date 2020/11/4 11:13 PM
 * @Version 1.0
 **/
public class HttpRequestFilterImpl implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {

        if(null != fullRequest && null!= fullRequest.headers()){
            HttpHeaders httpHeaders = fullRequest.headers();
            httpHeaders.set("header_key", "response时过滤");
        }
    }
}
