package com.bigpappasmurfsarchitecture.cleanonion.client.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonCreateResource {
    private String firstName;
    private String lastName;
    private String sex;
}
