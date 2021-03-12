package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheaper2/*")
public class item2 {
    //규칙 2 : 생성자 인자가 많을때는 Builder 패턴 적용을 고려하라

    @RequestMapping(method = RequestMethod.GET, value="/item2")
    public String print_result(Model model){

        CarFactory car = new CarFactory.Builder("쏘나타").manufacturer("현대").price(30000000).weight(1000000).build();

        return car.print_info();
    }
}

class CarFactory {
    private final String name;
    private final String manufacturer;
    private final int price;
    private final int weight;

    public static class Builder {
        private String name;
        private String manufacturer;
        private int price;
        private int weight;
        public Builder(String name) {
            this.name = name;
        }
        Builder manufacturer(String val) {
            manufacturer = val;
            return this;
        }
        Builder price(int val) {
            price = val;
            return this;
        }
        Builder weight(int val) {
            weight = val;
            return this;
        }
        public CarFactory build() {
            return new CarFactory(this);
        }
    }
    private CarFactory(Builder builder) {
        this.name = builder.name;
        this.manufacturer = builder.manufacturer;
        this.price = builder.price;
        this.weight = builder.weight;
    }

    public String print_info() {
        String report = "";
        report += String.format("name : %s\r\n", name);
        report += String.format("manufacturer : %s\r\n", manufacturer);
        report += String.format("price : %d\r\n", price);
        report += String.format("weight : %d\r\n", weight);
        return report;
    }
}