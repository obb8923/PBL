package team2.PBL_AD_Manager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TargetInf {
	@Id
	@GeneratedValue
	@Column(name = "targetInf_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private int age;

	//Target ID 해독 //TargetId 는 1~20이 있으며, 1~10은 남자, 11~20은 여자이다.
	public int[] TargetToStr(Long targetId) {
		if (targetId == null || targetId < 1 || targetId > 20) {
			throw new IllegalArgumentException("targetId must be between 1 and 20");
		}
		int gender;
		int ageStart;

		if (targetId <= 10) {
			gender = 0;
			ageStart = (int)(targetId - 1) * 10;
		} else {
			gender = 1;
			ageStart = (int)(targetId - 11) * 10;
		}
		return new int[] {gender, ageStart}; //gender 0: 남자, 1: 여자
	}
}
