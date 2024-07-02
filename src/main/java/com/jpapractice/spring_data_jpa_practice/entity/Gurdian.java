package com.jpapractice.spring_data_jpa_practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "gurdian_name")
        ),

        @AttributeOverride(
                name = "email",
                column = @Column(name = "gurdian_email")
        ),
        @AttributeOverride(
                name = "phone",
                column = @Column(name = "gurdian_phone")
        ),
})
public class Gurdian {
    private String name;
    private String email;
    private String phone;
}
