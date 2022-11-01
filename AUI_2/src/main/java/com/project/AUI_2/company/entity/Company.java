package com.project.AUI_2.company.entity;

import com.project.AUI_2.worker.entity.Worker;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "companies")
@ToString
@Getter
@Setter
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Worker> workers;
}
