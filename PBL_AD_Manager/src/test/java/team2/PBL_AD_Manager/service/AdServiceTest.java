package team2.PBL_AD_Manager.service;

import static org.aspectj.runtime.internal.Conversions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import team2.PBL_AD_Manager.domain.adType.Ad;
import team2.PBL_AD_Manager.domain.adType.Image;
import team2.PBL_AD_Manager.domain.adType.Video;
import team2.PBL_AD_Manager.repository.AdRepository;

@SpringBootTest
@Transactional
class AdServiceTest {
	@Autowired
	AdService adService;
	@Autowired
	AdRepository adRepository;

	@Test
	void AD_등록_조회() {
		Image imageAd = new Image();
		Video videoAd = new Video();

		adService.saveAd(imageAd);
		adService.saveAd(videoAd);

		Ad findImageAd = adService.findOne(imageAd.getId());
		Ad findVideoAd = adService.findOne(videoAd.getId());

		assertThat(findImageAd.getId()).isEqualTo(imageAd.getId());
		assertThat(findVideoAd.getId()).isEqualTo(videoAd.getId());

	}

	@Test
	void AD_count() {
		Long totalNumber = adRepository.findTotalNumber();
		assertThat(intValue(totalNumber)).isEqualTo(3);
	}

	@Test
	void AD_idx() {
		List<Ad> li = adRepository.findAllWithPagination(1, 3);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getId());
		}
	}

	@Test
	void AD_page() throws Exception {
		List<Ad> li = adService.findAdsByPage(1);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getId());
		}
	}
}
