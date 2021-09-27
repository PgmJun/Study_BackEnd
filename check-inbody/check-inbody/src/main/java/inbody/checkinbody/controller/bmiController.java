package inbody.checkinbody.controller;

import inbody.checkinbody.domain.Member;
import inbody.checkinbody.repository.MemberRepository;
import inbody.checkinbody.repository.MemoryMemberRepository;
import inbody.checkinbody.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class bmiController {

    private final MemberService memberService;

    @Autowired
    public bmiController(MemberService memberService){
        this.memberService = memberService;
    }



    SimpleDateFormat format = new SimpleDateFormat( "yyyy년 MM월 dd일");


    @GetMapping("/")
    public String checkKcal(){
        return "checkKcal";
    }

    @PostMapping("calculate")
    public String bmi(bmiForm form, Model model){

        Member member = new Member();

        double cal = 0;

        if(form.getGender().equals("male")){
            cal = 66.47 + 13.75*form.getWeight();
            cal += 5 * form.getHeight();
            cal -= 6.76 * form.getAge();
        }else if(form.getGender().equals("female")){
            cal = 655.1 + 9.56 * form.getWeight();
            cal += 1.85 * form.getHeight();
            cal -= 4.68 * form.getAge();
        }
        double result = Double.parseDouble(String.format("%.1f",cal));
        model.addAttribute("name", form.getName());
        model.addAttribute("kcal", result);

        Date time = new Date();
        String TIME = format.format(time);

        member.setDate(TIME);
        member.setGender(form.getGender());
        member.setName(form.getName());
        member.setAge(form.getAge());
        member.setHeight(form.getHeight());
        member.setWeight(form.getWeight());
        member.setRmr(result);

        memberService.join(member);

        return "myKcal";
    }
    @GetMapping("record")
    public String list(Model model){
        List<Member> records = memberService.findRecords();
        model.addAttribute("records", records);
        return "record";
    }

}
