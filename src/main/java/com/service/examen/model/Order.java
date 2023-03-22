package com.service.examen.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ord")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_id")
    private String clientId;

    private String ordnum;
    @Column(name="wh_id")
    private String whId;
    private String btcust;
    private String stcust;
    private String rtcust;
    private String ordtyp;

}
