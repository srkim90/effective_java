package com.srkim.effective.cheaper3;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/cheaper3/*")
public class item10 {
    /*
      item10 : equals는 일반 규약을 지켜 재 정의하라
         * 반사성(reflexivity) : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true이다.
         * 대칭성(symmetry) : null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)가 true이면 y.equals(x)도 true이다.
         * 추이성(transitivity) : null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이면 y.equals(z)도 true면, x.equals(z)도 true이다.
         * 일관성(consistency) : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
         * null - 아님 : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false이다.
    */
    @RequestMapping(method = RequestMethod.GET, value="/item10")
    public String print_result(Model model) throws InterruptedException {

        PhoneNumber phone1 = new PhoneNumber(82, 2093, 8806);
        PhoneNumber phone2 = new PhoneNumber(82, 2094, 8806);

        boolean result = phone2.equals(phone1);

        System.out.println("result : " + result);

        return "";
    }
}

//가장 전형적인 equals 메서드의 예
class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 9999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if(val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true; // 반사성
        }

        if(!(o instanceof PhoneNumber)) {
            //입력 자료형의 type이 PhoneNumber가 아니면
            return false;
        }

        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }
}