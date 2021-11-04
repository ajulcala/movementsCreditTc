package com.movementscredit.app.models.documents;

import com.movementscredit.app.models.dto.Card;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@Document(collection="movem_consumo")
public class MovementsConsume {
    @Id
    private String id;
    private String type; //tipo consume
    private String description;
    private Double amount;
    private Integer condition;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    private Card card;
}
