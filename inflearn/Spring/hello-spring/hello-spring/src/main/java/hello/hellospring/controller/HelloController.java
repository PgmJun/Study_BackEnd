package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //general 방식
    @GetMapping("hello") //web환경에서 /hello 입력시 호출됌
    public String hello(Model model){
        model.addAttribute("data", "하 왤캐 어려워");
        return "hello";  //templates에 있는 hello.html로 보낸다는 뜻
    }

    //MVC 방식
    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello hello(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    public class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}