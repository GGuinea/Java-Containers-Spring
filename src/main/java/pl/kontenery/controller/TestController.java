package pl.kontenery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connection")
public class TestController {
    @GetMapping(value = "/test", produces = "application/json")
    public String test() {
        return "Server is UP and READY!";
    }
}
