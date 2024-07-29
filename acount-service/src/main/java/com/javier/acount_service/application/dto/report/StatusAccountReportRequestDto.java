package com.javier.acount_service.application.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusAccountReportRequestDto {
    public Long accountId;
    public Long clientId;
}
