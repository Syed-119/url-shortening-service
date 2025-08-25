package org.syed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syed.data.entity.Request;
import org.syed.data.entity.Response;
import org.syed.service.UrlService;

@RestController
@RequestMapping("/shorten")
public class UrlController {

    @Autowired
    UrlService urlService;

    @GetMapping
    public Response findByShortUrl(@RequestParam("shortUrl") String shortUrl) {
        return urlService.getOriginalUrl(shortUrl);
    }

    @PostMapping
    public Response saveShortUrl(@RequestBody Request request){
        return urlService.saveShortUrl(request);
    }
}
