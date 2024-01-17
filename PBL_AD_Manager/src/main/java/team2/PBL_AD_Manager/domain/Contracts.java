package team2.PBL_AD_Manager.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import team2.PBL_AD_Manager.domain.adType.Ad;

@Entity
@Getter
@Setter
public class Contracts {
	@Id
	@GeneratedValue
	@Column(name = "contract_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "advertiser_id")
	private Advertiser advertiser;

	private int price;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	@OneToOne
	@JoinColumn(name = "slot_id")
	private Slot slot;

	@OneToOne
	@JoinColumn(name = "ad_id")
	private Ad ad;

	@OneToOne
	@JoinColumn(name = "targetInf_id")
	private TargetInf targetInf;

	public void SetAd(Ad ad) {
		this.ad = ad;
	}

	public void SetAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
		advertiser.getContracts().add(this);
	}

	public void SetTragetInf(TargetInf targetInf) {
		this.targetInf = targetInf;
		targetInf.setContracts(this);
	}
}
