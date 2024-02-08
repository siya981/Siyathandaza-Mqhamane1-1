package com.enviro.assessment.grad001.siyathandazamqhamane.controller;


import com.enviro.assessment.grad001.siyathandazamqhamane.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.WithdrawalNoticeRequest;
import com.enviro.assessment.grad001.siyathandazamqhamane.model.WithdrawalNoticeResponse;
import com.enviro.assessment.grad001.siyathandazamqhamane.service.WithdrawalNoticeService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalNoticeController {
    @Autowired
    private WithdrawalNoticeService withdrawalNoticeService;

    @PostMapping("/withdwawalNotice_creation")
            WithdrawalNoticeResponse createWithdrawalNotice( @Valid  @RequestBody WithdrawalNoticeRequest withdrawalNoticeRequest){
        return withdrawalNoticeService.createWithdrawalNotice(withdrawalNoticeRequest);
    }

    @GetMapping("/{investorid}")
    List<WithdrawalNotice> getByInvestorId(@PathVariable Long investorid) {
        return withdrawalNoticeService.getNoticesByInvestorId(investorid);

    }

    @GetMapping("/statement")
    public ResponseEntity<Void> downloadStatementCSV(
            @RequestParam Long investorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            HttpServletResponse response) throws IOException {

        List<WithdrawalNotice> withdrawalNoticeList =
                withdrawalNoticeService.getStatementInvestorIdAndDateRange(investorId, startDate, endDate);

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=statement.csv");

        try (CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(response.getOutputStream()))) {
            // Write CSV headers
            String[] headers = {" ID  ","  Creation Date", "   Amount " , " InvestorProduct Name"};
            csvWriter.writeNext(headers);
            // Write CSV data
                for (WithdrawalNotice withdrawalNotice : withdrawalNoticeList) {
                    csvWriter.writeNext(new String[]{withdrawalNotice.getWithdrawalId().toString()
                            , withdrawalNotice.getWithdrawalDate().toString()
                            , withdrawalNotice.getWithdrawalAmount().toString()
                            , withdrawalNotice.getProductType().toString()});
                }
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).build();
    }


}
