package team2.PBL_AD_Manager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Advertiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertiser_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "advertiser")
    /**
     * 만약 검색을 추가하면 회사명으로 DB 전체 조회
     */
    private List<Contracts> contracts = new ArrayList<>();
}
