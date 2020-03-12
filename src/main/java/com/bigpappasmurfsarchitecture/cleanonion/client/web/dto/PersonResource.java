package com.bigpappasmurfsarchitecture.cleanonion.client.web.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonResource {
    private UUID id;
    private String firstName;
    private String lastName;
    private String sex;
}
