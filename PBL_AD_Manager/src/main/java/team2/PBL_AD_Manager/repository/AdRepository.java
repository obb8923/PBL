package team2.PBL_AD_Manager.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.controller.Form.SearchForm;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.SlotPosition;
import team2.PBL_AD_Manager.domain.adType.Ad;

@Repository
@RequiredArgsConstructor
@Transactional
public class AdRepository {

	private final EntityManager em;

	public void saveAd(Ad ad) {
		em.persist(ad);
	}

	public Ad findOne(Long id) {
		return em.find(Ad.class, id);
	}

	public List<Ad> findAds() {
		return em.createQuery("select a from Ad a", Ad.class).getResultList();
	}

	// AdRepository.java
	public Long findTotalNumber(SearchForm searchForm) {
		String jpql = "SELECT COUNT(a) FROM Ad a";
		return em.createQuery(jpql, Long.class).getSingleResult();
	}

	public List<Ad> findAllWithPagination(int startIdx, int endIdx, SearchForm searchForm) {
		// String jpql = "SELECT a FROM Ad a WHERE a.id >= :startIdx AND a.id <= :endIdx ORDER BY a.id DESC"; // 내림차순 정렬

		String jpql = "SELECT a FROM Ad a WHERE a.id >= :startIdx AND a.id <= :endIdx";
		if(searchForm.getIsActive() != null){
			jpql += " AND a.contracts.isActive = :status";
		}

		if(!Objects.equals(searchForm.getSearchText(), "")){
			jpql += " AND a.text = :text";
		}

		jpql += " ORDER BY a.id DESC";

		TypedQuery<Ad> query = em.createQuery(jpql, Ad.class);

		if(searchForm.getIsActive() != null){
			query.setParameter("status", searchForm.getIsActive());
		}

		if(!Objects.equals(searchForm.getSearchText(), "")){
			query.setParameter("text", searchForm.getSearchText());
		}

		return query
			.setParameter("startIdx", startIdx)
			.setParameter("endIdx", endIdx)
			.getResultList();
	}

	/**
	 * 타겟 광고 찾는 코드
	 */
	public List<Ad> findTargetAdByTargetId(Long targetId, String slotPosition){
		return em.createQuery("select ad from Ad ad where ad.contracts.targetId = :targetId and ad.contracts.slotPosition = :slotPosition and ad.contracts.isActive", Ad.class)
			.setParameter("targetId", targetId)
			.setParameter("slotPosition", Objects.equals(slotPosition, "top") ? SlotPosition.top : SlotPosition.bottom)
			.getResultList();
	}

	public List<Ad> findActiveAllAd(){
		return em.createQuery("select ad from Ad ad where ad.contracts.isActive", Ad.class).getResultList();
	}

	// public List<Ad> findTargetAdByGender(Gender gender){}
	// public List<Ad> findTargetAdByAge(int age){}
}

