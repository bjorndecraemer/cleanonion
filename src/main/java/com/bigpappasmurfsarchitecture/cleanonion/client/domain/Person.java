package com.bigpappasmurfsarchitecture.cleanonion.client.domain;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    private UUID id;
    private String firstName;
    private String lastName;
    private Sex sex;
}
