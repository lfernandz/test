package com.ladonware.backendtest.campaignTest;

import com.ladonware.backendtest.entity.Campaign;
import com.ladonware.backendtest.entity.User;
import com.ladonware.backendtest.repository.CampaignRepository;
import com.ladonware.backendtest.service.CampaignService;
import com.ladonware.backendtest.service.Impl.CamaignServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class CampaignServiceMockTest {

    @Mock
    private CampaignRepository campaignRepository;

    private CampaignService campaignService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        campaignService = new CamaignServiceImpl(campaignRepository);
        Campaign campaign = Campaign.builder()
                .user(User.builder().idUser(UUID.randomUUID()).build())
                .subject("Subject Test")
                .numberOfRecipients(10)
                .status(true)
                .build();

        Mockito.when(campaignRepository.findById(1))
                .thenReturn(Optional.of(campaign));
    }

    @Test
    public void getCampaignsByUser(){
        List<Campaign> found = campaignService.findAllCampaign();
        Assertions.assertThat(found.size() == 1);
    }

}
