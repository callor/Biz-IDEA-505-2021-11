package com.callor.student.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "tbl_score")
public class ScoreVO {

    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sc_seq;

    @Column
    private String sc_stnum;

    @Column
    private String sc_subject;

    @Column
    private String sc_score;
}
