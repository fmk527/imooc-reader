package com.mklg.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller

public class KaptchaController {
    @Resource
    private Producer producer;

    @GetMapping("/api/verify_code")
    public void createVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //响应过期时间
        response.setDateHeader("Expires", 0);
        //不缓存任何图片
        response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
        response.setHeader("Cache-Control", "post-check=0,pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/png");
        //生成验证码图片
        String text = producer.createText();
        request.getSession().setAttribute("kaptchaVerifyCode", text);
        BufferedImage image = producer.createImage(text);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
