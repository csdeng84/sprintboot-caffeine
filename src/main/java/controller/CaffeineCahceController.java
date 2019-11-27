package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.FooService;

@RestController
public class CaffeineCahceController {
    @Autowired
    private FooService fooService;

    @RequestMapping("/cache")
    @ResponseBody
    public String getCache(@RequestParam(value = "fooname", required = true) String fooname){
        System.out.println("call foo....3333");
        return fooService.foo(fooname);
    }

    @RequestMapping("/getcache")
    @ResponseBody
    public String getCachevalue(){
        return fooService.getCache("foo","dengcs");
    }
}
