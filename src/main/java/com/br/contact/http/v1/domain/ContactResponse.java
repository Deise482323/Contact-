package com.br.contact.http.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContactResponse {

    private String name;
    private String email;
    private String phone;
}
