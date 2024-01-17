package team2.PBL_AD_Manager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import team2.PBL_AD_Manager.domain.adType.Ad;

import java.time.LocalDateTime;

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
        ad.setContracts(this);
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
