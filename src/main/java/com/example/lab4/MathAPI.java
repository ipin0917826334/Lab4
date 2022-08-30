package com.example.lab4;
import org.springframework.web.bind.annotation.*;

//@RestController
//public class demoService {
//        @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
//        public String helloWorld() {
//            return "Hello World";
//        }
//    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
//    public String test(@PathVariable("name") String name) {
//        return name;
//    }
//    }
@RestController
public class MathAPI{
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        double out = num1+num2;
        return out+"";
    }
    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        double out = num1-num2;
        return out+"";
    }
    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        double out = num1*num2;
        return out+"";
    }
    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        double out = num1/num2;
        return out+"";
    }
    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        double out = num1%num2;
        return out+"";
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String max(@RequestBody MyNumber n){
        if (n.getN1() > n.getN2()) {
            return n.getN1()+"";
        }
        else{
            return n.getN2()+"";
        }
    }
}