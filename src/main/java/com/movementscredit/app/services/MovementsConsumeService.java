package com.movementscredit.app.services;

import com.movementscredit.app.models.documents.MovementsConsume;
import com.movementscredit.app.models.dto.Card;
import com.movementscredit.app.models.dto.CreditsBusiness;
import com.movementscredit.app.models.dto.CreditsPersonal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementsConsumeService {
    public Flux<MovementsConsume> findAll();
    public Mono<MovementsConsume> findById(String id);
    public Flux<MovementsConsume> findByCard(Card card);
    public Mono<MovementsConsume> save(MovementsConsume movementsConsume);
    public Flux<CreditsPersonal> cardCredit(Card card);
    public Mono<CreditsPersonal> saldoCard(MovementsConsume movementsConsume);
    public Flux<CreditsBusiness> cardCreditBusiness(Card card);
    public Mono<CreditsBusiness> saldoCardBusines(MovementsConsume movementsConsume);
}
