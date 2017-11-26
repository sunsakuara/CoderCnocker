package net.zhuruyi.bbs.web.controller;

import java.util.UUID;
import net.zhuruyi.bbs.mybatis.pojo.User;
import net.zhuruyi.bbs.response.Response;
import net.zhuruyi.bbs.web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 21:08 2017/11/22
 * @Modified By:
 */
@Controller
public class indexController {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, @RequestParam("verificationCode") String verificationCode) {
        userService.addUser(user, verificationCode);
        return "refirect:/";
    }

    @ResponseBody
    @PostMapping("/sendEmail")
    public Response sendEmail(@RequestParam("email") String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getUsername());
        msg.setSubject("注册邮件验证");
        msg.setTo(email);
        String verificationCode = UUID.randomUUID().toString().replace("-", "");
        msg.setText("您的验证码是 " + verificationCode);
        BoundValueOperations<String, String> verificationEmail = redisTemplate
                .boundValueOps("verificationEmail");
        verificationEmail.set(verificationCode);

        mailSender.send(msg);
        return new Response(1, "发送成功", msg);
    }
}
