package eu.ludimus.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/logout")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "logout";
    }
    @RequestMapping("/error")
    public String error() {
        return "error";
    }
    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
