package cn.itcast.web;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ssqswyf
 * @Date 2021/4/12
 */
@Slf4j
@RestController
@RequestMapping("user")
public class HelloController {



    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("hello.do")
    public String hello() {
        log.debug("hello method is running");
        return "Hello, spring boot !";
    }

    @GetMapping("{id}")
    public User hell(@PathVariable("id") Long id) {

        return userService.queryById(id);
    }
}
