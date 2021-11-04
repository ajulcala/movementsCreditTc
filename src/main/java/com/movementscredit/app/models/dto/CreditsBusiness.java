package com.movementscredit.app.models.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CreditsBusiness {
    private String id;
    private String naccount;//numero de cuneta
    private String currency; // tipo de moneda
    private String ruc; //dni o ruc
    private String business_name; //nombre
    private String address;//direccion
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    private Integer status; // estado
    private String type; // tipo de cuenta
    private Double limit;
    private Double amount;
    private Integer condition;
    private Card card;
    private List<Owners> owners; //titulares
    private List<Signatories> signatories; //firmantes
}
