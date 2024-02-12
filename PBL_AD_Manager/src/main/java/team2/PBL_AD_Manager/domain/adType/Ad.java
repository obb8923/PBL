package team2.PBL_AD_Manager.domain.adType;

import static jakarta.persistence.FetchType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import team2.PBL_AD_Manager.domain.Contracts;

@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorColumn
@Getter
@Setter
public abstract class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ad_id")
	private Long id;

	private long size;

	private long width;

	private long height;

	private String text;

	private String url;

	private int clickCount;

	private int price;

	@OneToOne(mappedBy = "ad", fetch = LAZY)
	private Contracts contracts;

}
