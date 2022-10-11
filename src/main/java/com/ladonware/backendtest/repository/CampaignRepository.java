package com.ladonware.backendtest.repository;

import com.ladonware.backendtest.entity.Campaign;
import com.ladonware.backendtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    List<Campaign> findAllByUserOrderByDateCreatedDesc(User user);

//    @Query(value = "SELECT SUM(c.number_of_recipients) FROM campaign c " +
//            "WHERE c.user LIKE %:user% AND c.status = 1", nativeQuery = true)
//    public int countEmailByUser(User user);

    List<Campaign> findCampaignsByUserAndStatus(User user, boolean status);

}
