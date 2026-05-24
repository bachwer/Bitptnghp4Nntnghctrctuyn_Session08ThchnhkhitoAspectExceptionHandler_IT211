package org.example.ex4.controller;


import jakarta.validation.constraints.Min;

import org.example.ex4.service.LessonService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
@Validated
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/watch")
    public String watchLesson(

            @RequestParam
            @Min(value = 1,
                    message = "lessonId must be greater than 0")
            Long lessonId,

            @RequestHeader("X-User")
            String username
    ) {

        return lessonService.watchLesson(
                lessonId,
                username
        );
    }
}