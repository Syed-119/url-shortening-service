package org.syed.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "url")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String shortCode;

    private Date createdAt;

    private Date updatedAt;
}
