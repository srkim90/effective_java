package com.srkim.effective.cheaper5;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/cheaper5/*")
public class item27 {
    /*
       item27 : 비검사 경고를 제거하라
          * https://jyami.tistory.com/91
    */
    @RequestMapping(method = RequestMethod.GET, value="/item27")
    public String print_result(Model model) throws InterruptedException {

        return "";
    }
}
