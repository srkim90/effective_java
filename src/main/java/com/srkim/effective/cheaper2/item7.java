package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.EmptyStackException;

@RestController
@RequestMapping("/cheaper2/*")
public class item7 {
    // item7 : 다 쓴 객체는 참조를 해제 하라

    @RequestMapping(method = RequestMethod.GET, value="/item7")
    public String print_result(Model model) throws InterruptedException {

        Stack stack = new Stack();
        String[] args = new String[10];
        args[0]="Kim";
        args[1]="Park";
        args[2]="Yi";

        for (String arg : args)
            stack.push(arg);

        stack.pop();
        stack.pop();
        stack.pop();


        return "";
    }
}
class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size]; // 스택이 줄어들어도 elements 값은 유효하기에 누수 발생
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

//    // 코드 7-2 제대로 구현한 pop 메서드 (37쪽)
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // 다 쓴 참조 해제
//        return result;
//    }

}