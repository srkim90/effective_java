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

        return "";
    }
}