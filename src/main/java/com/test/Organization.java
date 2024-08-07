package com.test;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organization implements Serializable {

    @Id
    private String orgId;
    private String orgName;
    private String orgEmail;
    private Long contact;
    private boolean isActive;


}
