package com.srkim.effective.cheaper5;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/cheaper5/*")
public class item26 {
    /*
       item26 : 로타입은 사용하지 말라
          * https://jyami.tistory.com/90
    */
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static <T> void safeAdd(List<T> list, T o) { // 제네릭 선언, T 끼리는 같다는 말.
        list.add(o);
    }

    @RequestMapping(method = RequestMethod.GET, value="/item26")
    public String print_result(Model model) throws InterruptedException {

        List<String> strings = new ArrayList<String>();
        //unsafeAdd(strings, 42);// 문자열이 드가야 하는데, 엉뚱한게 들어갈수도 있음 "1111");//
        safeAdd(strings, "42");
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.

        return "";
    }
}
