package team2.PBL_AD_Manager.service;

import static org.assertj.core.api.Assertions.*;

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
}
