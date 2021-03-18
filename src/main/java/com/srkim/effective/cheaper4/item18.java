package com.srkim.effective.cheaper4;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/cheaper4/*")
public class item18 {
    /*
       item18 : 상속보다는 컴포지션을 사용하라
          * https://jyami.tistory.com/80
          상속이 안전 할 때
             * 상위 클래스와 하위클래스를 모두 같은 프로그래머가 통제하는 패키지 안에서 사용한다.
             * 확장할 목적으로 설계되었고 문서화도 잘되었다.
          상속이 안전하지 않을때
             * 다른 패키지의 구체 클래스를 상속하는 것은 위험하다.
    */
    @RequestMapping(method = RequestMethod.GET, value="/item18")
    public String print_result(Model model) throws InterruptedException {

        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        //s.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(s.getAddCount());

        return "";
    }
}


class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;
    public ForwardingSet(Set<E> s) { this.s = s; }

    public void clear()               { s.clear();            }
    public boolean contains(Object o) { return s.contains(o); }
    public boolean isEmpty()          { return s.isEmpty();   }
    public int size()                 { return s.size();      }
    public Iterator<E> iterator()     { return s.iterator();  }
    public boolean add(E e)           { return s.add(e);      }
    public boolean remove(Object o)   { return s.remove(o);   }
    public boolean containsAll(Collection<?> c)
    { return s.containsAll(c); }
    public boolean addAll(Collection<? extends E> c)
    { return s.addAll(c);      }
    public boolean removeAll(Collection<?> c)
    { return s.removeAll(c);   }
    public boolean retainAll(Collection<?> c)
    { return s.retainAll(c);   }
    public Object[] toArray()          { return s.toArray();  }
    public <T> T[] toArray(T[] a)      { return s.toArray(a); }
    @Override public boolean equals(Object o)
    { return s.equals(o);  }
    @Override public int hashCode()    { return s.hashCode(); }
    @Override public String toString() { return s.toString(); }
}

class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }

}