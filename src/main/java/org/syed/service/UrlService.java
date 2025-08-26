package org.syed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syed.data.entity.Request;
import org.syed.data.entity.Response;
import org.syed.repository.UrlRepository;

import java.util.Date;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Response saveShortUrl(Request request){
        Response response = new Response();
        response.setUrl(request.getUrl());
        response.setShortCode(request.getUrl());
        response.setCreatedAt(new Date());
        response.setUpdatedAt(new Date());
        urlRepository.save(response);
        return response;
    }

}
