package team2.PBL_AD_Manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class Test {

    @GetMapping("/")
    public String start(){
        return "main";
    }
}
