package com.llt.recruit.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.llt.recruit.model.ResultInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUtil {

    public static void setJson(ResultInfo resultInfo , HttpServletResponse response) {
        //将数据json序列化
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);
            //将json数据写回客户端
            //设置content-type
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
