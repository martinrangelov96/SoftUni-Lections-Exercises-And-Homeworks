package app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/softuni/{username}")
    public String index(Model model, @PathVariable("username") String username) {
        List<String> users = Arrays.asList("pesho","gosho","maria");
        model.addAttribute("username", username);
        model.addAttribute("fullName", "Pesho Petrov");
        model.addAttribute("allUsers",users);
        return "users";
    }

}
