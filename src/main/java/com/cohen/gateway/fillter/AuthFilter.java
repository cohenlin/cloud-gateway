package com.cohen.gateway.fillter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object token = request.getParameter("token");
        //校验token
        if (token == null) {
            System.out.println("// TODO token为空，禁止访问!");
            HttpServletResponse response = ctx.getResponse();
            response.setCharacterEncoding("utf-8");  //设置字符集
            response.setContentType("text/html; charset=utf-8"); //设置相应格式
            // 过滤请求
            ctx.setSendZuulResponse(false);
            // 设置返回状态码
            ctx.setResponseStatusCode(401);
            try {
                response.getWriter().write("token为空，禁止访问!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ctx.setResponse(response);
            return null;
        } else {
            System.out.println("// TODO 根据token获取相应的登录信息，进行校验（略）!");
        }
        //添加Basic Auth认证信息
//        ctx.addZuulRequestHeader("Authorization", "Basic " + getBase64Credentials("app01", "*****"));
        return null;
    }

    @Override
    public String filterType() {
        // 过滤器类型
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 过滤器的优先级，越大越靠后执行
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 判断是否需要过滤
        return true;
    }
}