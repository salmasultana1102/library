package com.library.digitallibrary.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private Integer bookId;
    private String name;
    private String title;
    private String author;
    private Genre genre;
    private Double cost;
    private Double rating;
    private LocalDate year;
    private String authorEmail;


}
