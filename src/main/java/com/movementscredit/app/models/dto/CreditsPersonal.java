package com.movementscredit.app.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class CreditsPersonal {
    private String id;
    private String dni; //dni o ruc
    private String naccount;//numero de cuneta
    private String currency; // tipo de moneda
    private String name; //nombre
    private String apep;//apellido paterno
    private String apem;// apellido materno
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth_date; //fecha nacimiento
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    private Integer status;
    private Double limit;
    private Double amount;
}
