package inbody.checkinbody.controller;

import inbody.checkinbody.domain.Diary;
import inbody.checkinbody.domain.Record;
import inbody.checkinbody.domain.Registry;
import inbody.checkinbody.service.DiaryService;
import inbody.checkinbody.service.RecordService;
import inbody.checkinbody.service.RegistryService;
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

    private final DiaryService diaryService;
    private final RegistryService registryService;
    private final RecordService recordService;

    @Autowired
    public bmiController(RegistryService registryService, RecordService recordService, DiaryService diaryService) {
        this.diaryService = diaryService;
        this.registryService = registryService;
        this.recordService = recordService;
    }

    SimpleDateFormat format = new SimpleDateFormat( "yyyy년 MM월 dd일");



    //index페이지
    @GetMapping("/")
    public String checkKcal(){
        return "index";
    }

    //회원가입 버튼 클릭시
    @GetMapping("registry")
    public String registry() { return "registry";}

    //!!!로그인버튼 클릭시!!!
    //입력한 아이디로 계정을 찾고 그 계정의 pw가 입력받은 pw와 같을 때 "checkKcal"로 넘어간다.
    //아닐시 redirect
    @PostMapping("login")
    public String mainHtml(defaultForm form, Model model){

        Registry validate = registryService.findById(form.getId()).get();

        if((validate.getId() + validate.getPw()).equals(form.getId() + form.getPw())){
            model.addAttribute("id", form.getId());
            return "main";
        }
        return "index";
    }

    //main.html -> checkKcal.html
    @PostMapping("checkKcal")
    public String CheckKcal(defaultForm form, Model model){
        model.addAttribute("id", form.getId());
        return "checkKcal";
    }

    //main.html -> cuttingFat.html
//    @PostMapping("")
//    public String cuttingFat(defaultForm form, Model model){
//        model.addAttribute("id", form.getId());
//        return "cuttingFat";
//    }


    //!!!registry.html에서 회원가입 버튼 클릭시!!!
    //id가 비어있을 시 다시 registry.html로 리턴
    //id가 이미 있을 시 다시 registry.html로 리턴
    //새로운 id여서 findById값이 Empty일때 join시키고 index로 리턴
    @PostMapping("registry")
    public String turnMainPage(registryForm form){
        String registryID = form.getId();

        if(registryID.isEmpty()){
            return "registry";
        }
        else if(!(registryService.findById(registryID).isEmpty())){
            return "registry";
        }
        else if(registryService.findById(form.getId()).isEmpty()){
            Registry registry = new Registry();
            registry.setId(form.getId());
            registry.setPw(form.getPw());
            registryService.join(registry);

            return "index";
        }
        else return "registry";
    }

//=========================================================================




    //checkKcal -> myKcal
    @PostMapping("calculate")
    public String bmi(bmiForm form, Model model){

        Record record = new Record();

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
        model.addAttribute("id", form.getId());
        Date time = new Date();
        String TIME = format.format(time);

        record.setId(form.getId());
        record.setDate(TIME);
        record.setGender(form.getGender());
        record.setName(form.getName());
        record.setAge(form.getAge());
        record.setHeight(form.getHeight());
        record.setWeight(form.getWeight());
        record.setRmr(result);

        recordService.join(record);

        return "myKcal";
    }

    //checkKcal -> Kcalrecord
    @PostMapping("checkKcal-record")
    public String list(recordForm form,Model model){
        List<Record> records = recordService.findRecords(form.getId());
        model.addAttribute("records", records);

        model.addAttribute("id",form.getId());

        return "Kcalrecord";
    }

    // Kcalrecord -> checkKcal
    @PostMapping("backCheckKcal")
    public String backCheckKcal(recordForm form, Model model){
        model.addAttribute("id",form.getId());
        return "checkKcal";
    }

//=========================================================================

    //main -> diary
    @PostMapping("diary")
    public String diary(defaultForm form,Model model){
        model.addAttribute("id", form.getId());

        return "diary";
    }

    //diary -> DBsave -> diary
    @PostMapping("recordDiary")
    public String diaryRecord(diaryForm form,Model model){
        Date time = new Date();
        String TIME = format.format(time);

        Diary diary = new Diary();

        diary.setDate(TIME);
        diary.setId(form.getId());
        diary.setWeight(form.getWeight());
        diary.setText(form.getText());
        diary.setCardio(form.getCardio());
        diary.setTarget(form.getChest() + form.getBack() + form.getShoulder() + form.getLegs() + form.getBiceps() + form.getTriceps());

        diaryService.join(diary);

        model.addAttribute("id", form.getId());

        return "diary";
    }

    //diary -> diaryRecord
    @PostMapping("diaryList")
    public String diaryList(defaultForm form,Model model){
        List<Diary> diarys = diaryService.findDiary(form.getId());
        model.addAttribute("diarys", diarys);

        model.addAttribute("id", form.getId());
        return "diaryRecord";
    }

    //diaryRecord -> diary
    @PostMapping("backDiary")
    public String backDiary(recordForm form, Model model){
        model.addAttribute("id",form.getId());
        return "diary";
    }

//=========================================================================

    //backToMainPage
    @PostMapping("home")
    public String backMain(recordForm form, Model model){
        model.addAttribute("id",form.getId());
        return "main";
    }

    //logout
    @PostMapping("logout")
    public String logout(){
        return "index";
    }

}
