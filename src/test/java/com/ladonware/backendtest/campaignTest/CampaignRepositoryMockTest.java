package com.ladonware.backendtest.campaignTest;

import com.ladonware.backendtest.entity.Campaign;
import com.ladonware.backendtest.entity.User;
import com.ladonware.backendtest.repository.CampaignRepository;
import com.ladonware.backendtest.service.CampaignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.UUID;

@DataJpaTest
public class CampaignRepositoryMockTest {

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    public void testCreateCampaign(){
        Campaign campaign = Campaign.builder()
                .user(User.builder().idUser(UUID.randomUUID()).build())
                .subject("Subject Test")
                .numberOfRecipients(10)
                .status(true)
                .dateCreated(new Date())
                .build();
        campaignRepository.save(campaign);
    }

}
