package com.movementscredit.app.services;

import com.movementscredit.app.models.dao.MovementsPayDao;
import com.movementscredit.app.models.documents.MovementsPay;
import com.movementscredit.app.models.dto.Card;
import com.movementscredit.app.models.dto.CreditsBusiness;
import com.movementscredit.app.models.dto.CreditsPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class MovementsPayServiceImpl implements MovementsPayService{
    @Value("${config.base.creditpersonal}")
    private String url;

    @Value("${config.base.creditpersonalsaldo}")
    private String urls;

    @Value("${config.base.creditbusiness}")
    private String urlbc;

    @Value("${config.base.creditbusinesssaldo}")
    private String urlbs;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MovementsPayDao dao;

    @Override
    public Flux<MovementsPay> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<MovementsPay> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<MovementsPay> findByCard(Card card) {
        return dao.findByCard(card);
    }

    @Override
    public Mono<MovementsPay> save(MovementsPay movementsPay) {
        return dao.save(movementsPay);
    }

    @Override
    public Flux<CreditsPersonal> cardCredit(Card card) {
        Flux<CreditsPersonal> credit = webClientBuilder.build().post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(card),Card.class)
                .retrieve()
                .bodyToFlux(CreditsPersonal.class);
        return credit;
    }

    @Override
    public Mono<CreditsPersonal> saldoCard(MovementsPay movementsPay) {
        if(movementsPay.getCreateAt()==null){
            movementsPay.setCreateAt(new Date());
        }
        movementsPay.setType("Pay Personal");
        movementsPay.setCondition(1);
        Flux<CreditsPersonal> credit = webClientBuilder.build().put()
                .uri(urls)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsPay),Card.class)
                .retrieve()
                .bodyToFlux(CreditsPersonal.class);
        dao.save(movementsPay).subscribe();
        return credit.next();
    }

    @Override
    public Flux<CreditsBusiness> cardCreditBusiness(Card card) {
        Flux<CreditsBusiness> credit = webClientBuilder.build().post()
                .uri(urlbc)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(card),Card.class)
                .retrieve()
                .bodyToFlux(CreditsBusiness.class);
        return credit;
    }

    @Override
    public Mono<CreditsBusiness> saldoCardBusines(MovementsPay movementsPay) {
        if(movementsPay.getCreateAt()==null){
            movementsPay.setCreateAt(new Date());
        }
        movementsPay.setType("Pay Business");
        movementsPay.setCondition(1);
        Flux<CreditsBusiness> credit = webClientBuilder.build().put()
                .uri(urlbs)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsPay),Card.class)
                .retrieve()
                .bodyToFlux(CreditsBusiness.class);
        dao.save(movementsPay).subscribe();
        return credit.next();
    }
}
