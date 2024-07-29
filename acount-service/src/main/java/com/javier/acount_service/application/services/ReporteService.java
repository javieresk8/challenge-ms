package com.javier.acount_service.application.services;

import com.javier.acount_service.application.dto.report.StatusAccountReportRequestDto;
import com.javier.acount_service.application.dto.report.StatusAccountReportResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ReporteService {
    StatusAccountReportResponseDto getAccountStatusReport(StatusAccountReportRequestDto requestDto, LocalDate from, LocalDate to);
}
