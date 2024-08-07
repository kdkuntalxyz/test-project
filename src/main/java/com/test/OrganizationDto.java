package com.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrganizationDto implements Serializable {
    private String orgId;
    private String orgName;
    private String orgEmail;
    private boolean isActive;
    private Long contact;
}
