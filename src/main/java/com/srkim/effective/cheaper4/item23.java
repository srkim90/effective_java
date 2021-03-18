package com.srkim.effective.cheaper4;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/cheaper4/*")
public class item23 {
    /*
       item23. 태그 달린 클래스보다는 클래스 계층 구조를 활용하라하라
          * https://jyami.tistory.com/85
    */
    @RequestMapping(method = RequestMethod.GET, value="/item23")
    public String print_result(Model model) throws InterruptedException {
        item21Class obj = new item21Class();

        Rectangle rect = new Rectangle(1,2);
        Circle circle = new Circle(1);
        Square square = new Square(1);

        return "";
    }
}

abstract class Figure {
    abstract double area();
}

class Rectangle extends Figure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width  = width;
    }
    @Override double area() { return length * width; }
}

class Circle extends Figure {
    final double radius;

    Circle(double radius) { this.radius = radius; }

    @Override double area() { return Math.PI * (radius * radius); }
}

class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}