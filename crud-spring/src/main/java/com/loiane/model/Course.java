package com.loiane.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity

@SQLDelete(sql = "UPDATE Course SET  status = 'inativo' WHERE id = ?")

@Where(clause = "staus = 'Ativo'")

public class Course {
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 1 , max = 20)
    @Column(length = 20 , nullable = false)
    private String name;


    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Back-end | Front-end")
    @Column(length = 200 , nullable = false)
    private String category;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo | Inativo")
    @Column(length = 10 , nullable = false)
    private String status = "ativo";

}
