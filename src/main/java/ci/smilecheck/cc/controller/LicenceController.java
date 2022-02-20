package ci.smilecheck.cc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenceController {

	
	
	@GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
	
	@GetMapping("/hello")
    public String hello() {
        return "Hello there! I'm running.";
    }
}
