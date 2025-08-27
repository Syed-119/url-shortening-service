package org.syed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.syed.data.entity.Request;
import org.syed.data.entity.Response;
import org.syed.service.UrlService;

@RestController
@RequestMapping("/shorten")
public class UrlController {

    @Autowired
    UrlService urlService;


    @PostMapping
    public ResponseEntity<Response> saveShortUrl(@RequestBody Request request){
        if (request!= null){
            return new ResponseEntity<>(urlService.saveShortUrl(request),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Response> getOriginalUrl(@PathVariable(value = "shortCode", required = false) String shortCode){
        if (urlService.getOriginalUrl(shortCode) != null){
            return new ResponseEntity<>(urlService.getOriginalUrl(shortCode), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{shortCode}")
    public ResponseEntity<Response> updateOriginalUrl(@PathVariable(value = "shortCode", required = false) String shortCode, @RequestBody Request request){
        if (urlService.updateOriginalUrl(shortCode, request) != null){
            return new ResponseEntity<>(urlService.updateOriginalUrl(shortCode, request), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity deleteOriginalUrl(@PathVariable(value = "shortCode", required = false) String shortCode){
        if (urlService.deleteShortUrl(shortCode)){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
