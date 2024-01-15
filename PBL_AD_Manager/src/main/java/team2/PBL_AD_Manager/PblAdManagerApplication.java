package team2.PBL_AD_Manager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class PblAdManagerApplication {

	@Autowired
	private TestRepository testRepository;

	public static void main(String[] args) {
		SpringApplication.run(PblAdManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TestRepository repository) {
		return (args) -> {
			// 테스트 엔티티 생성 및 저장
			Test newTest = new Test("안녕 세상아!");
			repository.save(newTest);
			// 저장된 엔티티 조회 및 출력
			repository.findAll().forEach(System.out::println);
		};
	}
}

