package org.syed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syed.data.entity.Request;
import org.syed.data.entity.Response;

public interface UrlRepository extends JpaRepository<Response,Long> {

    Response findByShortUrl(String shortUrl);

    Response saveShortUrl(Request request);

}
