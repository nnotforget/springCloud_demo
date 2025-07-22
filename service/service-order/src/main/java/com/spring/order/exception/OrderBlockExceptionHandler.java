package com.spring.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.springframework.stereotype.Component;

@Component
public class OrderBlockExceptionHandler implements BlockExceptionHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       String resourceName, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        R r = R.error(500, resourceName + "被Sentinel限流了，原因：" + e.getClass());
        String json = objectMapper.writeValueAsString(r);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
