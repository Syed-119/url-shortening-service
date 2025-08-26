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

    @Column(name = "url", unique = true)
    private String url;

    @Column(name = "shortCode")
    private String shortCode;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}
