package net.zhuruyi.bbs.mybatis.pojo;

import java.io.Serializable;

/**
 * @Author :zhuruyi
 * @Description:
 * @Date:Create in 0:36 2017/11/19
 * @Modified By:
 */
public class User implements Serializable {

    private int id;
    private String username;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
