package com.library.digitallibrary.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {

    @NotBlank(message="Book Name cannot be blank")
    private String name;
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @NonNull
    private Genre genre;
    @Min(value = 0,message = "Cost cannot be less than 0")
    private Double cost;
    @PastOrPresent
    private LocalDate year;
    @Email(message = "Please provide valid Email")
    private String authorEmail;

    public Book getBook(){
        return  new Book().builder().name(this.name)
                .title(this.title)
                .author(this.author)
                .genre(this.genre)
                .cost(this.cost)
                .year(this.year)
                .authorEmail(this.authorEmail)
                .build();
    }
}
