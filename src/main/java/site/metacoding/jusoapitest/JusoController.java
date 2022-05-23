package site.metacoding.jusoapitest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JusoController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/juso/callback")
    public void jusoCallback(String roadFullAddr) {
        System.out.println(roadFullAddr);
    }

    @RequestMapping(value = "/juso/popup", method = { RequestMethod.GET, RequestMethod.POST })
    public String jusoPopup(Model model, String roadFullAddr) {

        String jusoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do";
        String confmKey = "devU01TX0FVVEgyMDIyMDUyMzEwNDgzNTExMjYwMDA=";
        String resultType = "4";
        String returnUrl = "http://localhost:8080/juso/popup";

        if (roadFullAddr == null) {
            roadFullAddr = "N";
        }

        model.addAttribute("jusoUrl", jusoUrl);
        model.addAttribute("confmKey", confmKey);
        model.addAttribute("resultType", resultType);
        model.addAttribute("returnUrl", returnUrl);
        model.addAttribute("roadFullAddr", roadFullAddr);
        return "jusoPopup";
    }

}
