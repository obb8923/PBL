package team2.PBL_AD_Manager.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Advertiser;
import team2.PBL_AD_Manager.domain.Contracts;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.SlotPosition;
import team2.PBL_AD_Manager.domain.TargetInf;
import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.domain.adType.Image;
import team2.PBL_AD_Manager.domain.adType.Video;
import team2.PBL_AD_Manager.repository.AdRepository;
import team2.PBL_AD_Manager.repository.AdvertiserRepository;
import team2.PBL_AD_Manager.repository.ContractsRepository;
import team2.PBL_AD_Manager.service.AdService;
import team2.PBL_AD_Manager.service.TargetService;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final AdvertiserRepository advertiserRepository;
	private final AdService adService;
	private final ContractsRepository contractsRepository;
	private final AdRepository adRepository;
	private final TargetService targetService;

	@Getter
	static class AdList {
		private List<Ad> adList = new ArrayList<>();
	}

	@GetMapping("/")
	public String getAdApi(Model model) {
		if (adRepository.findTotalNumber() == 0) {
			model.addAttribute("advertisers", advertiserRepository.findAll());
			AdForm adForm = new AdForm(); // AdForm 클래스의 인스턴스 생성
			model.addAttribute("adForm", adForm);
			return "main";
		} else {
			return "redirect:/1";
		}
	}

	@PostMapping("/contract/create")
	public String create(AdForm adForm, BindingResult result) {

 		adService.createAdContract(adForm);

		return "redirect:/";
	}

	@GetMapping("/{pageNum}")
	public String pagination(@PathVariable("pageNum") int pageNum, Model model) throws Exception {
		Long totalNum = adRepository.findTotalNumber();
		List<Ad> adList = adService.findAdsByPage(pageNum);

		// adForm 객체를 모델에 추가
		AdForm adForm = new AdForm(); // AdForm 클래스의 인스턴스 생성
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalNum", totalNum);
		model.addAttribute("ads", adList);
		model.addAttribute("advertisers", advertiserRepository.findAll());
		model.addAttribute("adForm", adForm);
		return "main";
	}

	@GetMapping("/detail/{adId}")
	public String ADdetail(@PathVariable("adId") Long adId, Model model) throws Exception {
		Ad ad = adRepository.findOne(adId);
		AdForm adForm = new AdForm(); // AdForm 클래스의 인스턴스 생성

		// ad 객체로 contracts, target info 가져오기
		Contracts contract = ad.getContracts();
		Advertiser advertiser = contract.getAdvertiser();
		TargetInf targetInf = new TargetInf();
		int[] targetArr = targetInf.TargetToStr(contract.getTargetId());

		model.addAttribute("ad", ad);
		model.addAttribute("contract", contract);
		model.addAttribute("advertiser", advertiser);
		model.addAttribute("adForm", adForm);

		return "detail";
	}

	@PostMapping("/ad/edit")
	public String update(Model model, AdForm adForm) {
		// Long adId = adForm.getAdId();
		// System.out.println("adId = " + adId);
		// Image findImage = (Image)adService.findOne(adId);

		adService.editAdContract(adForm);

		// Gender gender = (inputGender == "male") ? Gender.male : Gender.female;
		// int age = adForm.getAge();
		// int price = adForm.getPrice();
		// String title = adForm.getTitle();
		// String url = adForm.getUrl();
		// String content = adForm.getContent();
		// SlotPosition slotPosition = (slot == "top") ? SlotPosition.top : SlotPosition.bottom;
		// String startDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// String endDate = adForm.getEndDate();
		//
		// Video videoAd = Video.createVideo(url, price, title);
		// Long targetId = targetService.findId(age, gender);
		// adRepository.saveAd(videoAd);
		// Advertiser advertiser = advertiserRepository.findAdvertiser(id);
		// Contracts contracts = Contracts.createContracts(price, slotPosition, videoAd, targetId, advertiser, startDate,
		// 	endDate);
		//
		// contractsRepository.saveContract(contracts);

		return "redirect:/";
	}


}
