package ci.smilecheck.cc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenceController {

	
	
	
	@GetMapping("/hello")
    public String hello2() {
        return "Hello there! I'm running.";
    }
}
