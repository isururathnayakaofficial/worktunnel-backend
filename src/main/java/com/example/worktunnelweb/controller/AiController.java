package com.example.worktunnelweb.controller;


import com.example.worktunnelweb.dto.UserAiDTO;
import com.example.worktunnelweb.service.AnonymousAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class AiController {
    private final AnonymousAiService anonimasAiService;
    @PostMapping("/search")
    public void getSearchAi(@RequestBody UserAiDTO userAiDTO) {
        anonimasAiService.promptSave(userAiDTO);
    }


}
