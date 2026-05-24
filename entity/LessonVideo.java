package org.example.ex4.entity;


import jakarta.persistence.*;

@Entity
public class LessonVideo {

    @Id
    private Long id;

    private Long courseId;

    private String videoUrl;

    private boolean isFree;

    public LessonVideo() {
    }

    public LessonVideo(Long id,
                       Long courseId,
                       String videoUrl,
                       boolean isFree) {

        this.id = id;
        this.courseId = courseId;
        this.videoUrl = videoUrl;
        this.isFree = isFree;
    }

    public Long getId() {
        return id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public boolean isFree() {
        return isFree;
    }
}