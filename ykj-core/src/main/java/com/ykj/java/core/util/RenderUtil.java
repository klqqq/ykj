package com.ykj.java.core.util;

import com.alibaba.fastjson.JSON;
import com.ykj.java.core.exception.YkjException;
import com.ykj.java.core.exception.YkjExceptionEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 渲染工具类
 *
 * @author ykj
 * @date 2018-5-25 14:13
 */
public class RenderUtil {

    /**
     * 渲染json对象
     */
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(jsonObject));
        } catch (IOException e) {
            throw new YkjException(YkjExceptionEnum.WRITE_ERROR);
        }
    }
}
