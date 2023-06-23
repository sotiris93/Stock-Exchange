package com.sotiris.stockexchange.controllers;

import com.sotiris.stockexchange.model.SocialSentiment;
import com.sotiris.stockexchange.rest_services.RestSocialSentimentService;
import com.sotiris.stockexchange.services.SocialSentimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("social-sentiments")
public class SocialSentimentController {
    private final RestSocialSentimentService restSocialSentimentService;
    private final SocialSentimentService socialSentimentService;


    @GetMapping
    public ResponseEntity<List<SocialSentiment>> getAllSocialSentiments() {
        return ResponseEntity.ok(socialSentimentService.getSocialSentiments());
    }



//    @GetMapping
//    public ResponseEntity<List<SocialSentiment>> findTimeWithPositiveScore() {
//        return ResponseEntity.ok()
//    }
}
