package net.zhuruyi.bbs.CoderCnocker;

import net.zhuruyi.bbs.mybatis.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoderCnockerApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    @Test
    public void contextLoads() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getUsername());
        msg.setSubject("测试邮件发送");
        msg.setTo("478848707@qq.com");
        msg.setText("测试邮件发送成功");
        mailSender.send(msg);
       /* System.out.println(userDao.selectAll());*/
    }

}
