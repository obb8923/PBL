package team2.PBL_AD_Manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Advertiser;
import team2.PBL_AD_Manager.repository.AdvertiserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdvertiserService {
	private final AdvertiserRepository advertiserRepository;

	public List<Advertiser> findAdvertisers(){
		return advertiserRepository.findAll();
	}
}
