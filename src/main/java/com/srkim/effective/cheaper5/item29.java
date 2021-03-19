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
public class item29 {
    /*
       item29 : 이왕이묜 제네릭타입으로 만들어라
            * https://jyami.tistory.com/93
    */



    @RequestMapping(method = RequestMethod.GET, value="/item29")
    public String print_result(Model model) throws InterruptedException {
        Item29_Stack stack = new Item29_Stack();
        stack.push(1);
        stack.push("str");
        return "";
    }
}

class Item29_Stack<E>
{
    @SuppressWarnings("unchecked")
    private E[] elements = (E[])new Object[100];

    public void push(E e) {//이렇게하면 아무자료형이나 담을수 있다. 근데 이걸 실전에서 쓸진 모르겠다.. (한소리 듣지 않을끼? ㅎㅎ)
        elements[0] = e;
    }
}