package com.srkim.effective.cheaper6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/cheaper6/*")
public class item36 {
    /*
       item36 : 비트 필드 대신 EnumSet을 사용하라
            * https://jyami.tistory.com/104
    */


    @RequestMapping(method = RequestMethod.GET, value="/item36")
    public String print_result(Model model) throws InterruptedException {


        return "";
    }
}
