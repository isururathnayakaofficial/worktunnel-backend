package com.example.worktunnelweb.controller;


import com.example.worktunnelweb.dto.UserAiDTO;
import com.example.worktunnelweb.repository.AiRepo;
import com.example.worktunnelweb.service.AnonymousAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class AiController {
    private final AnonymousAiService anonimasAiService;


    @PostMapping("/search")
    public String getSearchAi(@RequestBody UserAiDTO userAiDTO) {
        // Call service and return AI response directly
        return anonimasAiService.promptSave(userAiDTO);
    }
    @GetMapping("/getCount")
    public ResponseEntity<?> getCount(){
        //request count
        return ResponseEntity.ok(anonimasAiService.getCount());
    }
}
