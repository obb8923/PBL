package team2.PBL_AD_Manager.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.controller.Form.AdForm;
import team2.PBL_AD_Manager.controller.Form.UserForm;
import team2.PBL_AD_Manager.domain.Advertiser;
import team2.PBL_AD_Manager.domain.Contracts;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.SlotPosition;
import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.domain.adType.Image;
import team2.PBL_AD_Manager.domain.adType.Video;
import team2.PBL_AD_Manager.repository.AdRepository;
import team2.PBL_AD_Manager.repository.AdvertiserRepository;
import team2.PBL_AD_Manager.repository.ContractsRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdService {
	private final AdRepository adRepository;
	private final AdvertiserRepository advertiserRepository;
	private final ContractsRepository contractsRepository;
	private final TargetService targetService;

	@Transactional
	public void saveAd(Ad ad) {
		adRepository.saveAd(ad);
	}

	@Transactional
	/**
	 * 수정할때 수정할 정보를 추가 매개변수로 넣어주면 됨
	 */
	public void update(Long adId) {
		Ad findAd = adRepository.findOne(adId);
		/*
		findAd.set,,을 통해 수정할 정보 수정
		 */
	}

	/**
	 * 해당 ad 를 DB 에서 삭
	 * @param adId
	 */
	@Transactional
	public void delete(Long adId) {
		Contracts contracts = contractsRepository.findContractByAdId(adId);
		contracts.setIsActive(false);
	}

	public List<Ad> findAds() {
		return adRepository.findAds();
	}

	public Ad findOne(Long id) {
		return adRepository.findOne(id);
	}

	// AdService.java

	public List<Ad> findAdsByPage(int pageNum) throws Exception {
		int unitNum = 5; // 각 페이지에 표시할 광고 수
		Long totalNum = adRepository.findTotalNumber(); // 전체 광고 수 조회

		// 에러 처리
		if (totalNum > Integer.MAX_VALUE) {
			throw new Exception("totalNum exceeds Integer.MAX_VALUE in findAdsByPage");
		}
		if (totalNum == 0) {
			throw new Exception("No ads data in the database");
		}

		// DB 조회 범위 정하기
		int startIdx, endIdx;
		if (totalNum < pageNum) {
			startIdx = 1;
			endIdx = totalNum.intValue();
		} else {
			startIdx = totalNum.intValue() - unitNum * pageNum + 1;
			endIdx = totalNum.intValue() - unitNum * (pageNum - 1);
		}
		System.out.println(startIdx + " " + endIdx);
		return adRepository.findAllWithPagination(startIdx, endIdx);
	}

	public Gender checkGender(String gender) {
		if(gender.equals("male"))
			return Gender.male;
		else if (gender.equals("female"))
			return Gender.female;
		 else
			return Gender.all;
	}

	@Transactional
	public void createAdContract(AdForm adForm){
		String type = adForm.getType();
		Ad ad;
		if(Objects.equals(type, "video")){
			ad = Video.createVideo(adForm.getUrl(), adForm.getPrice(), adForm.getTitle());
		}
		else{
			ad = Image.createImage(adForm.getUrl(), adForm.getPrice(), adForm.getTitle());
		}
		Gender gender = checkGender(adForm.getGender());
		SlotPosition slotPosition = (adForm.getSlotPosition().equals("top")) ? SlotPosition.top : SlotPosition.bottom;
		String startDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		adRepository.saveAd(ad);
		Advertiser advertiser = advertiserRepository.findAdvertiser(adForm.getCompanyId());
		Contracts contracts = Contracts.createContracts(adForm.getPrice(), slotPosition, ad, targetService.findId(adForm.getAge(),gender), advertiser, startDate,
			adForm.getEndDate());

		contractsRepository.saveContract(contracts);
	}

	@Transactional
	public void editAdContract(AdForm adForm){
		Ad ad = adRepository.findOne(adForm.getAdId());
		ad.setPrice(adForm.getPrice());
		ad.setText(adForm.getTitle());
		ad.setUrl(adForm.getUrl());

		Gender gender = checkGender(adForm.getGender());
		SlotPosition slotPosition = (adForm.getSlotPosition().equals("top")) ? SlotPosition.top : SlotPosition.bottom;

		Contracts.updateContracts(contractsRepository.findContractByAdId(adForm.getAdId()),adForm.getPrice(), slotPosition, ad, targetService.findId(adForm.getAge(),gender),
			adForm.getEndDate());
	}

	public Ad findTargetAd(UserForm userForm, String slotPosition){
		Gender gender = checkGender(userForm.getGender());
		Long targetId = targetService.findId(userForm.getAge(), gender);
		List<Ad> targetAd = adRepository.findTargetAdByTargetId(targetId, slotPosition);
		if(targetAd.isEmpty()){
			targetAd = adRepository.findActiveAllAd();
		}
		Collections.shuffle(targetAd);

		return targetAd.get(0);
	}

}
