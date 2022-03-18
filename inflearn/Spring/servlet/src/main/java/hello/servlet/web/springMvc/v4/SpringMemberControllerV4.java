package hello.servlet.web.springMvc.v4;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpringMemberControllerV4 {

    @Controller
    @RequestMapping("/springmvc/v3/members")
    public class SpringMemberControllerV2 {

        private MemberRepository memberRepository = MemberRepository.getInstance();


        @GetMapping("/new-form")
        public String newform() {
            return "new-form";
        }

        @PostMapping("/save")
        public String save(
                @RequestParam("username") String username,
                @RequestParam("age") int age,
                Model model) {

            Member member = new Member(username, age);
            memberRepository.save(member);

            model.addAttribute("member", member);
            return "save-result";
        }

        @GetMapping
        public String members(Model model) {
            List<Member> members = memberRepository.findAll();
            model.addAttribute("members", members);
            return "members";
        }
    }
}
