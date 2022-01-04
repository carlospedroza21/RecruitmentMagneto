package xmen.recruit.detector.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"xmen.recruit.detector"})
public class RecruitmentMagnetoWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentMagnetoWsApplication.class, args);
	}

}
