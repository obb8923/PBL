package team2.PBL_AD_Manager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.controller.AdForm;
import team2.PBL_AD_Manager.repository.AdRepository;
import team2.PBL_AD_Manager.repository.AdvertiserRepository;

@Service
@RequiredArgsConstructor
public class CheckService {
	private final AdRepository adRepository;
	private final AdvertiserRepository advertiserRepository;

	public String checkDB(Model model){
		if (adRepository.findTotalNumber() == 0) {
			model.addAttribute("advertisers", advertiserRepository.findAll());
			AdForm adForm = new AdForm(); // AdForm 클래스의 인스턴스 생성
			model.addAttribute("adForm", adForm);
			return "main";
		}
		return "";
	}
}
