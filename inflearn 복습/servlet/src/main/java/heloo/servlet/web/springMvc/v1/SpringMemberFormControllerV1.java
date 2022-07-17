package heloo.servlet.web.springMvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc")
public class SpringMemberFormControllerV1 {

    @RequestMapping("/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
