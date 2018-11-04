package com.cohen.gateway.fillter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
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