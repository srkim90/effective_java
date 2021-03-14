package com.srkim.effective.cheaper4;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/cheaper4/*")
public class item15 {
    /*
       item15 : 클래스와 멤버의 접근 권한을 최소화하라 (private/final 적극 활용 하라)
          * 정보은닉의 일반적인 개념을 설명함으로 test code 작성하지 않음
    */
    @RequestMapping(method = RequestMethod.GET, value="/item15")
    public String print_result(Model model) throws InterruptedException {
        return "";
    }
}