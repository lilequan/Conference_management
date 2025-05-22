package org.example.conference_management.dto;

import lombok.Data;

@Data
public class PageQueryDTO {
     private String name;
     private int page;
     private int pageSize;
}
