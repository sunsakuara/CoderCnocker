package net.zhuruyi.bbs.web.ServiceImpl;

import com.alibaba.druid.util.StringUtils;
import net.zhuruyi.bbs.mybatis.dao.UserDao;
import net.zhuruyi.bbs.mybatis.pojo.User;
import net.zhuruyi.bbs.web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 22:38 2017/11/23
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public int addUser(User user, String verificationCode) {
        BoundValueOperations<String, String> verificationEmail = redisTemplate
                .boundValueOps("verificationEmail-" + user.getEmail());
        String redisVerficationCode = verificationEmail.get();
        if (!StringUtils.isEmpty(redisVerficationCode)) {
            if (redisVerficationCode.equals(verificationCode)) {
                return userDao.addUser(user);
            }
        }
        return 0;
    }

}
