package org.example.ex4.repository;


import org.example.ex4.entity.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonVideoRepository
        extends JpaRepository<LessonVideo, Long> {
}