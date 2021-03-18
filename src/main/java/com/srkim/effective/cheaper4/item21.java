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
public class item21 {
    /*
       item21 : 인터페이스는 구현하는 쪽을 생각해 설계하라
          * https://jyami.tistory.com/83
    */
    @RequestMapping(method = RequestMethod.GET, value="/item21")
    public String print_result(Model model) throws InterruptedException {
        item21Class obj = new item21Class();

        String result = obj.mathod3();

        return "" + result;
    }
}

interface item21Intrface
{
    void mathod1();
    void mathod2();
    default String mathod3()
    {
        return "I am default method";
    }
}

class item21Class implements item21Intrface
{
    public void mathod1() {

    }
    public void mathod2(){

    }
}