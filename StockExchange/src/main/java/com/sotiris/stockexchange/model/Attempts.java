package com.sotiris.stockexchange.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="attempts")
@Getter
@Setter
public class Attempts { 
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String username; 
   private int attempts;
}