package com.srkim.effective.cheaper2;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheaper2/*")
public class item4 {
    //규칙 4 : 객체 생성을 막을 때는 private 생성자를 사용하라

    @RequestMapping(method = RequestMethod.GET, value="/item4")
    public String print_result(Model model){

        //privateConstructor e = new privateConstructor(); --> 안됨
        //e.staticMathod_1()

        /* class를 통한 참조만 가능하다 */
        privateConstructor.staticMathod_1();
        privateConstructor.staticMathod_2();
        privateConstructor.staticMathod_3();
        
        return "";
    }
}

class privateConstructor
{
    private privateConstructor(){}

    static String staticMathod_1() {
        return "staticMathod_1";
    }
    static String staticMathod_2() {
        return "staticMathod_2";
    }
    static String staticMathod_3() {
        return "staticMathod_3";
    }
}