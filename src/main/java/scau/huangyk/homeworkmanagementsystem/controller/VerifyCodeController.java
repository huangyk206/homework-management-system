package scau.huangyk.homeworkmanagementsystem.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码控制器
 * @author huangyk
 * @since 2019-02-24
 */
@Controller
@RequestMapping("/code")
@Slf4j
public class VerifyCodeController {

    //自定义图片宽度
    private int width=80;
    //自定义图片高度
    private int height=38;
    //验证码长度
    private int codeCount=4;
    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    @RequestMapping("/get")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random=new Random();
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics=image.createGraphics();
        //增加下面的代码使得背景透明
        image=graphics.getDeviceConfiguration().createCompatibleImage(width,height,Transparency.OPAQUE);
        graphics=image.createGraphics();
        //背景透明代码结束
        //将图像填充为白色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,width,height);
        //字体样式
        graphics.setFont(new Font("Times New Roman",Font.PLAIN,28));
        // 画边框。
        graphics.setColor(Color.lightGray);
        graphics.drawRect(0, 0, width - 1, height - 1);
        //生成图像内部的干扰线条
        for(int i=0;i<10;i++){
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int xl=random.nextInt(12);
            int yl=random.nextInt(12);
            graphics.drawLine(x,y,x+xl,y+yl);
            graphics.setColor(getRandColor());
        }
        //保存验证码
        StringBuffer randomCode=new StringBuffer();
        for(int i=0;i<codeCount;i++){
            //获取随机字符
            String code=String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            graphics.setColor(getRandColor());
            graphics.drawString(code,13 * i + 12, 32);
            //将随机字符缓存
            randomCode.append(code);
        }
        log.debug("生成的验证码：{}",randomCode.toString());
        //将验证码保存到session中
        HttpSession session=request.getSession();
        session.setAttribute("vercode",randomCode.toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(image, "jpeg", sos);
        sos.close();
    }

    private Color getRandColor(){
        Random random=new Random();
        int r=random.nextInt(255);
        int g=random.nextInt(255);
        int b=random.nextInt(255);
        return new Color(r,g,b);
    }



}
