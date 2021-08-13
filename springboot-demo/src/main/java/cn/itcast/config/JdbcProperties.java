package cn.itcast.config;


import lombok.Data;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/4/12
 */
@Data
public class JdbcProperties {

    String url;
    String driverClassName;
    String username;
    String password;
    User user = new User();


    static class User {
        String name;
        int age;
        List<String> language;
    }
}
