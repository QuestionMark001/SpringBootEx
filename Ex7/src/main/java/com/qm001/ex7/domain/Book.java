package com.qm001.ex7.domain;

import lombok.Data;

@Data  // Lombok 自动生成 Getter 与 Setter 方法，以及 toString 方法 等等
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
