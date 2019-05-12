package com.llt.recruit.web.controller;

import com.llt.recruit.util.CheckCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
@RequestMapping("check")
public class CheckCodeController {
    /**
     * 验证码
     * @param request
     * @param response
     */
    @RequestMapping("checkCode")
    public void checkCode(HttpServletRequest request , HttpServletResponse response){

        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 在内存中创建图象
        int width = 60, height = 25;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics g = image.getGraphics();
        CheckCodeUtil code=new CheckCodeUtil();
        String sRand=code.creatCode(image);

        // 将认证码存入SESSION
        request.getSession().setAttribute("checkCode", sRand);

        // 图象生效
        g.dispose();

        // 输出图象到页面
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
