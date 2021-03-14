package com.srkim.effective.cheaper3;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cheaper3/*")
public class item12 {
    /*
       item12 : toString을 항상 재정의하라
         1) 간결하면서 사람이 읽기 쉬운 형태의 유익한 정보
         2) 모든 하위 클래스에서 이 메서드를 재정의하라
    */
    @RequestMapping(method = RequestMethod.GET, value="/item12")
    public String print_result(Model model) throws InterruptedException {

        PhoneNumber3 phone1 = new PhoneNumber3(82, 2093, 8806);

        System.out.println(phone1.toString());

        return phone1.toString();
    }
}

class PhoneNumber3 {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber3(int areaCode, int prefix, int lineNum) {
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
    public String toString() {
        String objStr;
        objStr = "" + this.areaCode + this.prefix + this.prefix;
        return objStr;
    }

}