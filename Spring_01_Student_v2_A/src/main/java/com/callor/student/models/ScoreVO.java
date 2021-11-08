package com.callor.student.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ScoreVO {
    private Long sc_seq;
    private String sc_stnum;
    private String sc_subject;
    private String sc_score;
}
