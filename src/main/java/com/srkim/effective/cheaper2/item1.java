package com.srkim.effective.cheaper2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheaper2/*")
public class item1 {
    //규칙 1 : 생성자 대신 정적 팩터리 메서드를 사용할수 없는지 생각해 보라
    public item1() {}

    @RequestMapping(method = RequestMethod.GET, value="/item1")
    public String print_result(Model model){

        item1_super type1 = item1_super.createItemType1();
        item1_super type2 = item1_super.createItemType2("수박", 5500);
        item1_super type_nono = new item1_super("칸쵸", 4455);

        return "OK";
    }
}
class item1_super {
    String item_name;
    int item_price;

    public item1_super(String item_name, int item_price) {
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public static item1_super createItemType1()
    {
        return new item1_type1("토비의스프링", 300);
    }

    public static item1_super createItemType2(String item_name, int item_price)
    {
        return new item1_type2(item_name, item_price);
    }

}

class item1_type1 extends item1_super{
    String item_type;
    public item1_type1(String item_name, int item_price) {
        super(item_name, item_price);
        item_type = "book";
    }
}

class item1_type2 extends item1_super{
    String item_type;
    public item1_type2(String item_name, int item_price) {
        super(item_name, item_price);
        item_type = "food";
    }
}