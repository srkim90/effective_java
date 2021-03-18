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
public class item17 {
    /*
       item17 : 변경가능성을 최소화하라
          * https://jyami.tistory.com/79
    */
    @RequestMapping(method = RequestMethod.GET, value="/item17")
    public String print_result(Model model) throws InterruptedException {

//        1. 불변 클래스 5가지 규칙
//        ㄱ. 객체의 상태를 변경하는 메서드(변경자)를 제공하지 않는다. (setter)
//                ㄴ. 클래스를 확장할 수 없게 한다. (extend X)
//        ㄷ. 모든 필드를 final로 선언한다
//        ㄹ. 모든 필드를 private으로 선언한다.

        return "";
    }
}

final class immutableClass
{
    final int value = 0;
}
