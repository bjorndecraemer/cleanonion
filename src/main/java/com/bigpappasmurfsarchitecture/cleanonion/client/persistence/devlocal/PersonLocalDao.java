package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.devlocal;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonLocalDao {
    private UUID id;
    private String firstName;
    private String lastName;
    private String sex;
}
