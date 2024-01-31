package team2.PBL_AD_Manager.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import team2.PBL_AD_Manager.domain.Advertiser;

@SpringBootTest
@Transactional
class AdvertiserRepositoryTest {
	@Autowired
	AdvertiserRepository advertiserRepository;

	@Test
	void 광고주_등록_테스트() {
		Advertiser adv = new Advertiser();

		adv.setName("회사3");
		advertiserRepository.saveAdvertiser(adv);
		Advertiser 조회 = advertiserRepository.findAdvertiser(adv.getId());
		System.out.println("조회 = " + 조회);
		Assertions.assertThat(adv.getId()).isEqualTo(조회.getId());
	}
}
