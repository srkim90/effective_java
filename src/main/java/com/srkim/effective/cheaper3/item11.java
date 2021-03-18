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
public class item11 {
    /*
       item10 : equals를 재정의한 클래스 모두에서 hashCode도 재정의해야한다.
          * equals true 일 경우, hash값도 같아야 한다는 말이다.
    */
    @RequestMapping(method = RequestMethod.GET, value="/item11")
    public String print_result(Model model) throws InterruptedException {

        PhoneNumber2 phone1 = new PhoneNumber2(82, 2093, 8806);
        PhoneNumber2 phone2 = new PhoneNumber2(82, 2094, 8806);

        int hash1 =  phone1.hashCode();
        int hash2 =  phone2.hashCode();
        boolean result = phone2.equals(phone1);

        System.out.println("equals result : " + result);

        System.out.println("hash1 : " + hash1);
        System.out.println("hash2 : " + hash2);

        PhoneNumber phone3 = new PhoneNumber(82, 2093, 8806);
        PhoneNumber phone4 = new PhoneNumber(82, 2093, 8806);
        Map<PhoneNumber, String> map1 = new HashMap<>();
        map1.put(phone3, "srkim");
        String name = map1.get(phone4);

        System.out.println("name1 : " + name);

        PhoneNumber2 phone5 = new PhoneNumber2(82, 2093, 8806);
        PhoneNumber2 phone6 = new PhoneNumber2(82, 2093, 8806);
        Map<PhoneNumber2, String> map2 = new HashMap<>();
        map2.put(phone5, "srkim");
        String name2 = map2.get(phone5);

        System.out.println("name2 : " + name2);


        return "";
    }
}


//가장 전형적인 equals 메서드의 예
class PhoneNumber2 {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber2(int areaCode, int prefix, int lineNum) {
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
    public int hashCode(){
        // hash는 중복되도 상관은 없지만, 최대한 중복 안되도록 설계해야 한다.
        // hash계산에 빠지는 필드가 있어서는 안된다.
        return (this.areaCode * 1024 + this.prefix * 8888 + this.lineNum * 9887) % 100000;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true; // 반사성
        }

        if(!(o instanceof PhoneNumber2)) {
            //입력 자료형의 type이 PhoneNumber가 아니면
            return false;
        }

        PhoneNumber2 pn = (PhoneNumber2) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }
}