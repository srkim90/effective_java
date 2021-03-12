package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheaper2/*")
public class item3 {
    //규칙 3 : private 생성자나 enum 자료형은 싱글턴 패턴을 따르도록 설계하라

    @RequestMapping(method = RequestMethod.GET, value="/item3")
    public String print_result(Model model){

        CarFactory car = new CarFactory.Builder("쏘나타").manufacturer("현대").price(30000000).weight(1000000).build();

        return car.print_info();
    }
}

class singletonStatic{
    private singletonStatic(){} // setAccecessible() 을 통해서 private 생성자를 만들수 있다.
    public static final singletonStatic instance = new singletonStatic();
}

class singletonGetter{
    private singletonGetter(){}
    private static final singletonGetter instance = new singletonGetter();
    singletonGetter getInstance() {
        return instance;
    }
}

enum EnumSingleton  {
    INSTANCE("Initial class info");

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
    }

    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}