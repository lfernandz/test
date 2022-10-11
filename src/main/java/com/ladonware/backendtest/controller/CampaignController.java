package com.ladonware.backendtest.controller;

import com.ladonware.backendtest.entity.Campaign;
import com.ladonware.backendtest.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping("")
    public ResponseEntity<List<Campaign>> findAll(){
        List<Campaign> campaigns = campaignService.findAllCampaign();
        if(campaigns.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(campaigns);
        }
    }

    @GetMapping("history/{userId}")
    public ResponseEntity<List<Campaign>> campaignHistory(@PathVariable("userId")UUID userID){
        List<Campaign> campaigns = new ArrayList<>();
        if(userID == null){
            campaigns = campaignService.findAllCampaign();
            if(campaigns.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else {
            campaigns = campaignService.campaignHistory(userID);
            if(campaigns.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("count-email/{userId}")
    public int countEmail(@PathVariable("userId") UUID userId){
        return campaignService.emailSended(userId);
    }

    @PostMapping
    public ResponseEntity<Campaign> createCampign(@RequestBody Campaign campaign){
        Campaign campaignCreate = campaignService.createCampaign(campaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(campaignCreate);
    }

    @PutMapping("updatestatus/{campaignId}")
    public ResponseEntity<Campaign> updateStatusCampaign(@PathVariable("campaignId") int campaignId){
        Campaign campaign = campaignService.updateStatusCampaign(campaignId);
        if(campaign == null){
            return ResponseEntity.notFound().build();
            HttpStatus.
            ResponseEntity.
        }
        return ResponseEntity.ok(campaign);
    }
}
