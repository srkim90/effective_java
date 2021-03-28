package com.srkim.effective.cheaper6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/cheaper6/*")
public class item35 {
    /*
       item35 : ordinal 메서드 대신 인스턴스 필드를 사용하라
            * https://jyami.tistory.com/103
    */


    @RequestMapping(method = RequestMethod.GET, value="/item35")
    public String print_result(Model model) throws InterruptedException {

        int val = Ensemble.VAL1.getMaxOfVal();

        System.out.println("val : " + val);

        return "";
    }
}

enum Ensemble {
    VAL1,
    VAL2,
    VAL3,
    VAL4,
    VAL5,
    VAL6,
    VAL7;

    public int getMaxOfVal() {
        return ordinal() + 1; //ordinal 안쓰는거 추천
    }
}

enum Ensemble_ok {
    VAL1(1), // 차라리 값을 넣어라.. 근데 java enum은 중복을 허용하네??
    VAL2(2),
    VAL3(3),
    VAL4(4),
    VAL5(5),
    VAL6(6),
    VAL7(7);

    Ensemble_ok(int i) {
    }
}