package pg.edu.pg.eti.kask.AUI.worker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import pg.edu.pg.eti.kask.AUI.company.entity.Company;

import javax.persistence.*;


@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "workers")
@ToString
@Getter
@Setter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
