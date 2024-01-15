package team2.PBL_AD_Manager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "test")
@Getter
@AllArgsConstructor // Lombok으로 전체 생성자 추가
@ToString
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "textText", nullable = false)
    private String textText;

    public Test() {
        // 기본 생성자 없으면 에러남
    }

    public Test(String textText) {
        this.textText = textText;
    }
}


