package com.movementscredit.app.services;

import com.movementscredit.app.models.documents.MovementsPay;
import com.movementscredit.app.models.dto.Card;
import com.movementscredit.app.models.dto.CreditsBusiness;
import com.movementscredit.app.models.dto.CreditsPersonal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementsPayService {
    public Flux<MovementsPay> findAll();
    public Mono< MovementsPay> findById(String id);
    public Flux< MovementsPay> findByCard(Card card);
    public Mono< MovementsPay> save( MovementsPay  movementsPay);
    public Flux<CreditsPersonal> cardCredit(Card card);
    public Mono<CreditsPersonal> saldoCard( MovementsPay movementsPay);
    public Flux<CreditsBusiness> cardCreditBusiness(Card card);
    public Mono<CreditsBusiness> saldoCardBusines( MovementsPay  movementsPay);
}
