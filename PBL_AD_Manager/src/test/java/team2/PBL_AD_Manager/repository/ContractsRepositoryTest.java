package team2.PBL_AD_Manager.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import team2.PBL_AD_Manager.domain.Contracts;

@SpringBootTest
@Transactional
class ContractsRepositoryTest {
	@Autowired
	ContractsRepository contractsRepository;

	@Test
	void 테스트() {
		Contracts con = new Contracts();

		con.setPrice(100);
		contractsRepository.saveContract(con);
		Contracts 조회 = contractsRepository.findContract(con.getId());
		// System.out.println("조회 = " + 조회);
		Assertions.assertThat(con.getId()).isEqualTo(조회.getId());
	}
}
