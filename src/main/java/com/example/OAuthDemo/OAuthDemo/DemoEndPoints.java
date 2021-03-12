package com.example.OAuthDemo.OAuthDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoEndPoints {

    @GetMapping("/restricted")
    public ResponseEntity<?> HelloWorldRestricted() {
        return new ResponseEntity<>("Hello World from restricted end point" , HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> HelloWorld() {
        return new ResponseEntity<>("Hello World !!" , HttpStatus.OK);
    }

}
