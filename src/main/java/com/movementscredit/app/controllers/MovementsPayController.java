package com.movementscredit.app.controllers;

import com.movementscredit.app.models.documents.MovementsPay;
import com.movementscredit.app.models.dto.Card;
import com.movementscredit.app.models.dto.CreditsBusiness;
import com.movementscredit.app.models.dto.CreditsPersonal;
import com.movementscredit.app.services.MovementsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pay")
public class MovementsPayController {
    @Autowired
    private MovementsPayService service;

    @GetMapping
    public Flux<MovementsPay> list(){
        return service.findAll();
    }

    @PostMapping("/checkbalance/personal")
    public Flux<CreditsPersonal> cardPersonal(@Valid @RequestBody Card card){
        return service.cardCredit(card);
    }

    @PostMapping("/checkbalance/business")
    public Flux<CreditsBusiness> cardBusiness(@Valid @RequestBody Card card){
        return service.cardCreditBusiness(card);
    }

    @PostMapping("/creditpersonal/setcredit")
    public Mono<CreditsPersonal> saveCurrentPersonal(@Valid @RequestBody MovementsPay movementsPay){
        return service.saldoCard(movementsPay);
    }

    @PostMapping("/creditbusiness/setcredit")
    public Mono<CreditsBusiness> saveCurrentBusiness(@Valid @RequestBody MovementsPay movementsPay){
        return service.saldoCardBusines(movementsPay);
    }
}
