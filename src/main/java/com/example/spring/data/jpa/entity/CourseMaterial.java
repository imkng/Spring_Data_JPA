package com.example.spring.data.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "",
            sequenceName = "",
            allocationSize = 1
    )
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;


}
