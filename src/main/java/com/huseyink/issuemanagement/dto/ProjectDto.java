package com.huseyink.issuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private  Long id;
    @NotNull
    private String projectName;
    private String projectCode;
}
