package cn.wyh.dm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Stan on 2015/8/29.
 */
@Entity
@Table(name = "user")
public class User extends IdEntity {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("ÓÃ»§Ãû£º%s£»ÃÜÂë£º%s", username, password);
    }
}
