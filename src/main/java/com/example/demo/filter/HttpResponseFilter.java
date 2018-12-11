package com.example.demo.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.example.demo.util.JsonTools;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.LOWEST_PRECEDENCE - 1)
@WebFilter(urlPatterns = {"/toDoServer/*"},filterName = "httpResponseFilter")
public class HttpResponseFilter extends OncePerRequestFilter {
    @SuppressWarnings("deprecation")
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	ResponseWrapper wrapper = new ResponseWrapper(response);
        try {
            filterChain.doFilter(request, wrapper);

            String responseStr = new String(wrapper.toByteArray(), response.getCharacterEncoding());
            JsonNode resp = JsonTools.fromString(responseStr);

            ObjectNode json;
            if (resp.has("errCode") &&
                resp.has("errMsg") &&
                resp.has("rtnCode") &&
                resp.has("rtnMsg")) {
                json = (ObjectNode) resp;
            } else {
                json = JsonTools.newNode();
                json.put("errCode", 0);
                json.put("errMsg", "ok");
                json.put("rtnCode", 0);
                json.put("rtnMsg", "ok");
                json.put("rsp", resp);
            }

            response.setContentLength(JsonTools.toBytes(json).length);
            response.setContentType("application/json;charset=utf-8");
            response.getOutputStream().write(JsonTools.toBytes(json));
        } catch (Exception e) {
        }
    }
}
