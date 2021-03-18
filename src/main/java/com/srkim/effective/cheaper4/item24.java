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
public class item24 {
    /*
       item24. 태그 달린 클래스보다는 클래스 계층 구조를 활용하라하라
          * https://jyami.tistory.com/86
    */
    @RequestMapping(method = RequestMethod.GET, value="/item24")
    public String print_result(Model model) throws InterruptedException {
        NestedNonStaticExample exp = new NestedNonStaticExample("Test");
        String val = exp.getName();

        System.out.println("val : " + val);
        return "";
    }
}

class NestedNonStaticExample {
    private final String name;

    public NestedNonStaticExample(String name) {
        this.name = name;
    }

    public String getName() {
        // 비정적 멤버 클래스와 바깥 클래스의 관계가 확립되는 부분
        NonStaticClass nonStaticClass = new NonStaticClass("nonStatic : ");
        return nonStaticClass.getNameWithOuter();
    }

    private class NonStaticClass {
        private final String nonStaticName;

        public NonStaticClass(String nonStaticName) {
            this.nonStaticName = nonStaticName;
        }

        public String getNameWithOuter() {
            // 정규화된 this 를 이용해서 바깥 클래스의 인스턴스 메서드를 사용할 수 있다.
            return nonStaticName + NestedNonStaticExample.this.getName();
        }
    }
}



class AnonymousExample {
    private double x;
    private double y;
//4. 익명 클래스
//        이름이 없다!
//        바깥 클래스의 멤버도 아니다.
//        쓰이는 시점에 선언과 동시에 인스턴스가 만들어진다.
//        비정적인 문맥에서 사용될 때만 바깥 클래스의 인스턴스 참조가 가능하다
//        상수 정적변수 (static final) 외에는 정적 변수를 가질 수 없다.

    public double operate() {
        Operator operator = new Operator() {
            @Override
            public double plus() {
                System.out.printf("%f + %f = %f\n", x, y, x + y);
                return x + y;
            }
            @Override
            public double minus() {
                System.out.printf("%f - %f = %f\n", x, y, x - y);
                return x - y;
            }
        };
        return operator.plus();
    }
}

interface Operator {
    double plus();
    double minus();
}