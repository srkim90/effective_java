package com.srkim.effective.cheaper3;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/cheaper3/*")
public class item13 {
    /*
       item13 : clone 재정의는 주의해서 진행하라
         * 이거 말고 복사 생성자나 복사팩토리가 권장 됨
         * 물론 여기서도 깊은복사/얕은복사를 신경써줘야 한다.

    */
    @RequestMapping(method = RequestMethod.GET, value="/item13")
    public String print_result(Model model) throws InterruptedException {

        PhoneNumber4 phone2 = null;
        PhoneNumber4 phone1 = new PhoneNumber4();
        phone1.addNumber("srkim", "82010", "2093", "8806");
        try {
            phone2 = phone1.clone();
            phone2.addNumber("srkim2", "82010", "2093", "8807");
            phone2.addNumber("srkim3", "82010", "2093", "8808");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("phone1 : " + phone1.toString());
        System.out.println("phone2 : " + phone2.toString());

        return phone1.toString();
    }
}

class PhoneNumber4 implements Cloneable{
    //private int nIdx = 0; //<배열에서는 clone 을 해도 잘 복사가 된다.>
    //private String[] arrays = new String[1024];

    HashMap<String, String> map = new HashMap<>();


    public PhoneNumber4() {

        System.out.println("생성자 호출 됨!!");
    }

    public int addNumber(String name, String areaCode, String prefix, String lineNum){
        String fullnum = areaCode + prefix + lineNum;
        //arrays[nIdx] = fullnum;
        //return nIdx++;
        map.put(fullnum, name);

        return map.size();
    }

    public PhoneNumber4 clone() throws CloneNotSupportedException {
        PhoneNumber4 obj =  (PhoneNumber4)super.clone();

        //<깊은 복사를 한다.>
        HashMap<String, String> putMap = new HashMap<String, String>();
        putMap.putAll(map);
        obj.map = putMap;
        return obj;
    }

    @Override
    public String toString() {
        String lsResult = "";

        //for(int i=0;i < nIdx;i++) {
        //    lsResult += arrays[i] + "\n";
        //}
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = map.get(key);
            lsResult += key + ":" + value + "\n";
        }
        return lsResult;
    }

}