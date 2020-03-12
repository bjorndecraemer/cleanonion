package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.jpa;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "person")
public class PersonJpaEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;
    @Column(name = "fName")
    private String firstName;
    @Column(name = "lName")
    private String lastName;
    @Column(name = "sex")
    private String sex;
}
