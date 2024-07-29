package com.javier.acount_service.api.controllers;

import com.javier.acount_service.application.dto.report.StatusAccountReportRequestDto;
import com.javier.acount_service.application.dto.report.StatusAccountReportResponseDto;
import com.javier.acount_service.application.services.ReporteService;
import com.javier.acount_service.domain.entities.Movimiento;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/reportes")
public class ReporteController {
    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ResponseEntity<StatusAccountReportResponseDto> getStatusAccountReport(
            @RequestBody StatusAccountReportRequestDto requestDto,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate to) {

        return ResponseEntity.ok(this.reporteService.getAccountStatusReport(requestDto, from, to));
    }
}
