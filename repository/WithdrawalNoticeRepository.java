package com.enviro.assessment.grad001.siyathandazamqhamane.repository;


import com.enviro.assessment.grad001.siyathandazamqhamane.entity.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {
        WithdrawalNotice findByWithdrawalId(Long withdrawalId);
        List<WithdrawalNotice> findByInvestorIdAndWithdrawalDateIsBetween(Long investorId, LocalDate startDate, LocalDate endDate);



}
