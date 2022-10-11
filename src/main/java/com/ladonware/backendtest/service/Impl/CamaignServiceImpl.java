package com.ladonware.backendtest.service.Impl;

import com.ladonware.backendtest.entity.Campaign;
import com.ladonware.backendtest.repository.CampaignRepository;
import com.ladonware.backendtest.repository.UserRepository;
import com.ladonware.backendtest.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CamaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Campaign> findAllCampaign() {
        return campaignRepository.findAll();
    }

    @Override
    public List<Campaign> campaignHistory(UUID idUser) {
        return campaignRepository.findAllByUserOrderByDateCreatedDesc(userRepository.findById(idUser).get());
    }

    @Override
    public int emailSended(UUID idUser) {
        List<Campaign> campaigns = campaignRepository.findCampaignsByUserAndStatus(userRepository.findById(idUser).get(), true);
        int sum = 0;
        for (Campaign c:campaigns) {
            sum+=c.getNumberOfRecipients();
        }
        return sum;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        campaign.setDateCreated(new Date());
        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign updateStatusCampaign(int idCampaign) {
        Campaign campaign = campaignRepository.findById(idCampaign).get();
        campaign.setStatus(!campaign.isStatus());
        campaignRepository.save(campaign);
        return campaign;
    }
}
