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
public class item30 {
    /*
       item30 : 이왕이묜 제네릭 메서드로 만들어라
            * https://jyami.tistory.com/94
    */

    @RequestMapping(method = RequestMethod.GET, value="/item30")
    public String print_result(Model model) throws InterruptedException {

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        this.union(set1,set2);

        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        this.union(set1,set2);

        return "";
    }

    public <E> Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}

abstract class PayCard {
    public enum Benefit {
        POINT("포인트"), SALE("할인"), SUPPORT("연회비지원");
        Benefit(String benefit) {
        }
    }

    final Set<Benefit> benefits;

    abstract static class Builder<T extends Builder<T>> { // 재귀적 타입한정
        EnumSet<Benefit> benefits = EnumSet.noneOf(Benefit.class);

        public T addBenefit(Benefit benefit) {
            this.benefits.add(benefit);
            return self();
        }

        abstract PayCard build();

        protected abstract T self();
    }

    PayCard(Builder<?> builder) {
        benefits = builder.benefits.clone();
    }
}