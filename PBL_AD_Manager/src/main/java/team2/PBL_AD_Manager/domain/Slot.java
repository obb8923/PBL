package team2.PBL_AD_Manager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Slot {
    @Id @GeneratedValue
    @Column(name = "slot_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SlotPosition slotPosition;
/**
 * 보여준 자료에서는 굳이 필요없는거 같음
 */
//    @Enumerated(EnumType.STRING)
//    private ServiceEnv serviceEnv;
}
