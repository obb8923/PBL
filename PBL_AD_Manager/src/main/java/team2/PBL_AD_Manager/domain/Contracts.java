package team2.PBL_AD_Manager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Contracts {
    @Id @GeneratedValue
    @Column(name = "contract_id")
    private Long id;
    @ManyToOne
    private Advertiser advertiser;

    private int price;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToOne
    private Slot slot;

}
