package com.example.worktunnelweb.controller;

import com.example.worktunnelweb.dto.AnonymousAiDTO;
import com.example.worktunnelweb.service.AnonymousAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class AnonymousAiController {
    private final AnonymousAiService anonimasAiService;
    @PostMapping("/search")
    public void getSearchAi(@RequestBody AnonymousAiDTO anonimasAiDTO) {
        anonimasAiService.keywordFilter(anonimasAiDTO);
    }
}
