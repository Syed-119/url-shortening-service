package org.syed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syed.data.entity.Request;
import org.syed.data.entity.Response;
import org.syed.repository.UrlRepository;
import org.syed.utils.ServiceUtil;

import java.util.Date;


@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Response saveShortUrl(Request request){
        String uniqueShortCode = ServiceUtil.generatingShortCodeUrl();
        Response response = new Response();
        response.setUrl(request.getUrl());
        response.setShortCode(uniqueShortCode);
        response.setCreatedAt(new Date());
        response.setUpdatedAt(new Date());
        urlRepository.save(response);
        return response;
    }

    public Response getOriginalUrl(String shortCode){
        return urlRepository.findByShortCode(shortCode);
    }

    public Response updateOriginalUrl(String shortCode, Request request){
        Response response = urlRepository.findByShortCode(shortCode);
        if (response != null) {
            response.setUpdatedAt(new Date());
            response.setUrl(request.getUrl());
            urlRepository.save(response);
            return response;
        }
        return null;
    }

}
