package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Cleaner;

@RestController
@RequestMapping("/cheaper2/*")
public class item8 {
    /*
      item8 : finalizer와 cleaner 사용을 피해라
        * a. 즉시 수행된다는 보장이 없다.
        * b. 수행 여부도 보장하지 않는다
        * c. finalizer 동작중 발생한 예외가 무시되며, 처리할 작업이 남았어도 그 순간 종료된다.
        * d. finalizer와 cleaner는 심각한 성능문제도 동반한다.
        * e. finalizer 공격에 노출되어 심각한 보안 문제를 일으킬 수도 있다.
    */
    @RequestMapping(method = RequestMethod.GET, value="/item8")
    public String print_result(Model model) throws InterruptedException {
        System.out.println("make object exampleClass");
        exampleClass e = new exampleClass();
        e = null;
        System.gc(); // gc 해줘야 finalize 동작, 심지어 gc 해줘도 안동작할수도 있다고 한다. 흠좀무.
        return "";
    }
}

class exampleClass
{

    exampleClass() {
        System.out.println("call constructor");
    }
    @Override
    public void finalize() {
        System.out.println("call finalize");
    }
    /* JAVA9 부터 추가 되었다.
    private static final Cleaner cleaner = Cleaner.create();
    @Override
    public void close() {
        cleanable.clean();
    }
    */
}

