package org.syed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syed.data.entity.Request;
import org.syed.data.entity.Response;
import org.syed.repository.UrlRepository;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Response getOriginalUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    public Response saveShortUrl(Request request ) {
        return urlRepository.saveShortUrl(request);
    }


}
