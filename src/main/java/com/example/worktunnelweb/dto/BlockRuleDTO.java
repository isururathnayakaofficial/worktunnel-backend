package com.example.worktunnelweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockRuleDTO {
    private String url;
    private String startTime;
    private String endTime;
}
