package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cheaper2/*")
public class item5 {
    // item5 : 자원을 직접 명시하지 말고 의존 객체로 주입 하라

    @RequestMapping(method = RequestMethod.GET, value="/item5")
    public String print_result(Model model){

        Lexicon dict = new myDictionary_1();
        //Lexicon dict = new myDictionary_2();

        SpellChecker checker = new SpellChecker(dict); // 인터페이스로 받아준다.
        checker.isVaild("검사할문자열");
        
        return "";
    }
}

class SpellChecker {
    private final Lexicon dictionary;

    // 여기서 의존성 주입을!
    public SpellChecker(Lexicon dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isVaild(String word) {
        return dictionary.checker(word);
    }
}

// 인터페이스
interface Lexicon {
    boolean checker(String input);
}

// Lexicon을 상속 받아서 구현
class myDictionary_1 implements Lexicon {

    @Override
    public boolean checker(String input) {
        /* do check */
        return true;
    }
}

class myDictionary_2 implements Lexicon {

    @Override
    public boolean checker(String input) {
        /* do check */
        return true;
    }
}
