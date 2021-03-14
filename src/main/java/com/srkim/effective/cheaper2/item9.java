package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/cheaper2/*")
public class item9 {
    /*
      item9 : try-finally 보다는 try-with-resources를 사용하라
    */
    @RequestMapping(method = RequestMethod.GET, value="/item9")
    public String print_result(Model model) throws InterruptedException {
        try(tryWithResources res = new tryWithResources()) {
            System.out.println("1");
            res.raiseException();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Exception!");
        }
        System.out.println("2");
        return "";
    }


}

class tryWithResources implements AutoCloseable{
    @Override
    public void close(){
        System.out.println("tryWithResources::close call"); // try 블럭이 끝나는시점에 자동호출, finally로 지저분하게 안받아도 된다!
    }

    void raiseException() throws Exception {
        System.out.println("throw new Exception");
        throw new Exception();
    }
}