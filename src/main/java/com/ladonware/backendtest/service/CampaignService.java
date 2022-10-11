package com.ladonware.backendtest.service;

import com.ladonware.backendtest.entity.Campaign;

import java.util.List;
import java.util.UUID;

public interface CampaignService {

    public List<Campaign> findAllCampaign();

    public List<Campaign> campaignHistory(UUID idUser);

    public int emailSended (UUID idUser);

    public Campaign createCampaign(Campaign campaign);

    public Campaign updateStatusCampaign(int idCampaign);

}
