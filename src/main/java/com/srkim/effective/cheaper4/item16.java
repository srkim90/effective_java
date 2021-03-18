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
public class item16 {
    /*
       item16 : public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라
          * 정보은닉의 일반적인 개념을 설명함으로 test code 작성하지 않음
          * https://jyami.tistory.com/77
    */
    @RequestMapping(method = RequestMethod.GET, value="/item16")
    public String print_result(Model model) throws InterruptedException {

//        절대 가변 필드를 public으로 노출하면 안된다.
//
//        캡슐화의 이점을 제공하지 못한다.
//        API를 수정하지 않고는 내부 표현을 바꿀 수 없다.
//        불변식을 보장할 수 없다.
//        외부에서 필드에 접근할 때 부수 작업을 수행할 수도 없다.

        return "";
    }
}
