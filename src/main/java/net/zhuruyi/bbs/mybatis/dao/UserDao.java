package net.zhuruyi.bbs.mybatis.dao;

import java.util.List;
import net.zhuruyi.bbs.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 1:07 2017/11/19
 * @Modified By:
 */
@Repository
public class UserDao {

    private final SqlSession sqlSession;


    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectAll() {
        return sqlSession.selectList("selectAll");
    }

    public int addUser(User user) {
        return sqlSession.insert("addUser");
    }
}
