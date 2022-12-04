package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor  @NoArgsConstructor
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private  String  cne  ;
    private  String  nom;
    private  String prenom ;
    private  String email ;
    private  String  tel ;


}
