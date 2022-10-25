package com.project.AUI_2.worker.entity;

import com.project.AUI_2.company.entity.Company;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;


@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "workers")
@ToString
@Getter

public class Worker{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;
}