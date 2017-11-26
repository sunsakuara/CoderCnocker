package net.zhuruyi.bbs.web.Service;

import net.zhuruyi.bbs.mybatis.pojo.User;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 22:37 2017/11/23
 * @Modified By:
 */

public interface UserService {

    int addUser(User user, String verificationCode);
}
