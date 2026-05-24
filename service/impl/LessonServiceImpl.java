package org.example.ex4.service.impl;

import org.example.ex4.entity.LessonVideo;
import org.example.ex4.exception.AccessDeniedException;
import org.example.ex4.exception.ResourceNotFoundException;
import org.example.ex4.repository.LessonVideoRepository;
import org.example.ex4.service.LessonService;

import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonVideoRepository lessonVideoRepository;

    public LessonServiceImpl(
            LessonVideoRepository lessonVideoRepository
    ) {
        this.lessonVideoRepository = lessonVideoRepository;
    }

    @Override
    public String watchLesson(Long lessonId, String username) {

        LessonVideo video =
                lessonVideoRepository.findById(lessonId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Lesson video not found with id: "
                                                + lessonId));

        // Fake business logic
        boolean purchased =
                username.equals("admin");

        if (!video.isFree() && !purchased) {

            throw new AccessDeniedException(
                    "You have not purchased this course yet.");
        }

        return video.getVideoUrl();
    }
}