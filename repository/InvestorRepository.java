package com.enviro.assessment.grad001.siyathandazamqhamane.repository;
import com.enviro.assessment.grad001.siyathandazamqhamane.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvestorRepository  extends JpaRepository<Investor, Long> {

   Investor findByInvestorId(Long investorId);

}
