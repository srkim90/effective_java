package com.srkim.effective.cheaper6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/cheaper6/*")
public class item34 {
    /*
       item34 : int 상수 대신 열거 타입을 사용하라
            * https://jyami.tistory.com/102
            * 열거타입의 장점
               - 컴파일 타입 안전성 제공 : Apple 열거타입 인수에 Orange를 넘길 수 없음
               - 이름 같은 상수 공존 : 각자의 이름공간이 있기 때문! 공개 되는 것이 필드의 이름이라 상수 값이 클라이언트에 컴파일 되어 각인되지 않기 때문이다.
               - 임의의 메서드나 필드를 추가할 수 있고 임의의 인터페이스를 구현하게 할 수 있다.
               - 상수를 하나 제거했을 때 : 제거한 상수를 참조하지 않는 클라이언트에 아무 영향이 없다.
               - 참조를 한 클라이언트에서는 컴파일(런타임-다시 컴파일 X일 때) 오류가 발생할 것! (정수 열거 패턴에서는 기대할 수 없는 대응)
    */


    @RequestMapping(method = RequestMethod.GET, value="/item34")
    public String print_result(Model model) throws InterruptedException {

        double radius1  = Planet.MERCURY.radius();
        double mass1    = Planet.MERCURY.mass();


        for(Planet e : Planet.values()) {
            System.out.println("e : " + e + " " + e.name() + e.mass() + e.radius() + e.surfaceGravity() + "  : " + Planet.valueOf(e.name()) );
        }

        double val = Operation.TIMES.apply(11,2);
        System.out.println("val : " + val);

        return "";
    }
}


enum Planet { //자바에서는 enum에 생성자도 넣을수 있다!! C/C++ 에서는 안되는데 신기하다.
    // * 열거 타입은 근본적으로 불변이라 모든 필드는 final이야 한다.
    // * 필드를 private으로 두고 별도의 public 접근자 메서드를 두자
    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;           // 질량(단위: 킬로그램)
    private final double radius;         // 반지름(단위: 미터)
    private final double surfaceGravity; // 표면중력(단위: m / s^2)

    // 중력상수(단위: m^3 / kg s^2)
    private static final double G = 6.67300E-11;

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()           { return mass; }
    public double radius()         { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }
}

enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    },
    DIVIDE2("?") {
        @Override
        public double apply(double x, double y) {
            return 0;
        }
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    public abstract double apply(double x, double y); // 이렇게 추상 메서드를 하나 만들어두면.. 생성자에서 반드시 호출 해주어야 하도록 강제 할 수 있다.
}



enum PayrollDay { // 어렵다..
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) { this.payType = payType; }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                        (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

    public static void main(String[] args) {
        for (PayrollDay day : values())
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
    }
}











