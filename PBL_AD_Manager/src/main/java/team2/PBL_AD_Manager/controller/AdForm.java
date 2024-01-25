package team2.PBL_AD_Manager.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdForm {

	private Long adId;

	private String title;

	private int age;

	private int price;

	private String url;

	private String content;

	private String endDate;

	private String type;

	private Long companyId;

	private String slotPosition;

	private String gender;
}
