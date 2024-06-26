package com.library.digitallibrary.domain;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequest {

    @NotBlank(message = "Comment cannot be blank")
    private String comment;

    @Min(value = 0,message = "rating cannot be less than 0")
    @Max(value = 5, message = "rating cannot be greater than 5")
    private Double rating;

    @NotNull(message = "BookId must be provided")
    private Integer bookId;

    public Review getReview(){
        return  new Review().builder()
                .comment(this.comment)
                .rating(this.rating)
                .bookId(this.bookId)
                .build();
    }

}
