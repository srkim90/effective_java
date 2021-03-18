package com.srkim.effective.cheaper5;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/cheaper5/*")
public class item28 {
    /*
       item28 : 배열보다는 리스트를 사용하라
          장점 : 타입 안정성과 상호 운용성이 좋아진다.
          단점 : 코드가 조금 복잡해지고 성능이 살짝 나빠질 수도 있다.
            * https://jyami.tistory.com/92
    */
    @RequestMapping(method = RequestMethod.GET, value="/item28")
    public String print_result(Model model) throws InterruptedException {

        Object[] objectArray = new Long[1];
        objectArray[0] = "타입이 달라 넣을 수 없다," +
                         "근대 오브젝트로 담기때문에 컴파일 타임 에러가 아니다. (ArrayStoreException)" +
                         "C/C++ 에서는 그냥 안되는건데 자바에선 이게 빌드가 된다.";

        //List<Object> ol = new ArrayList<Long>(); // 이건 아예 되지도 않는다.
        List<Long> ol = new ArrayList<Long>();    // 호환되지 않는 타입이다.
        //ol.add("타입이 달라 넣을 수 없다.")

        List<String> myList = new ArrayList<>();

        Chooser e = new Chooser(myList);
        
        return "";
    }
}

class Chooser<T>{
    private final List<T> choiceList;

    public Chooser(Collection<T> choices){
        choiceList = new ArrayList<>(choices);
    }

    public T choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt() % choiceList.size());
    }
}