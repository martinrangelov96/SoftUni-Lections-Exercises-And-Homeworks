package SpringCalculator.SpringCalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    private List<String> students;

    public DemoController() {
        this.students = new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");



        return modelAndView;
    }

    @GetMapping("/add-student")
    public ModelAndView addStudent(ModelAndView modelAndView) {
        modelAndView.setViewName("add-student");
        modelAndView.addObject("students", this.students);

        return modelAndView;
    }

    @PostMapping("/add-student")
    public ModelAndView addStudentConfirm(@RequestParam("name") String name,
    ModelAndView modelAndView) {

        this.students.add(name);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
