package com.srkim.effective.cheaper3;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/cheaper3/*")
public class item14 {
    /*
       item14 : Comparable을 구현할지 고려하라
            * '차이'를 반환
    */
    @RequestMapping(method = RequestMethod.GET, value="/item14")
    public String print_result(Model model) throws InterruptedException {

        PhoneNumber5 phone2 = new PhoneNumber5("srkim2", "82010", "2093", "8807");
        PhoneNumber5 phone1 = new PhoneNumber5("srkim", "82010", "2093", "8806");

        System.out.println("phone1/2 compareTo: " + phone1.compareTo(phone2));

        return "";
    }
}

class PhoneNumber5 implements Comparable<PhoneNumber5>{
    String fullNumber;

    public PhoneNumber5(String name, String areaCode, String prefix, String lineNum){
        addNumber(name, areaCode, prefix, lineNum);
    }

    public int addNumber(String name, String areaCode, String prefix, String lineNum){
        String fullNumber = prefix + lineNum;
        this.fullNumber = fullNumber;
        return 0;
    }

    @Override
    public int compareTo(PhoneNumber5 o) {
        return Integer.parseInt(this.fullNumber) - Integer.parseInt(o.fullNumber);
    }
}