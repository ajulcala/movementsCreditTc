package com.movementscredit.app.services;

import com.movementscredit.app.models.dao.MovementsConsumeDao;
import com.movementscredit.app.models.documents.MovementsConsume;
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
public class MovementsConsumeServiceImpl implements MovementsConsumeService{
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
    private MovementsConsumeDao dao;
    @Override
    public Flux<MovementsConsume> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<MovementsConsume> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<MovementsConsume> findByCard(Card card) {
        return dao.findByCard(card);
    }

    @Override
    public Mono<MovementsConsume> save(MovementsConsume movementsConsume) {
        return dao.save(movementsConsume);
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
    public Mono<CreditsPersonal> saldoCard(MovementsConsume movementsConsume) {
        if(movementsConsume.getCreateAt()==null){
            movementsConsume.setCreateAt(new Date());
        }
        movementsConsume.setType("Consume Personal");
        movementsConsume.setCondition(0);
        Flux<CreditsPersonal> credit = webClientBuilder.build().put()
                .uri(urls)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsConsume),Card.class)
                .retrieve()
                .bodyToFlux(CreditsPersonal.class);
        dao.save(movementsConsume).subscribe();
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
    public Mono<CreditsBusiness> saldoCardBusines(MovementsConsume movementsConsume) {
        if(movementsConsume.getCreateAt()==null){
            movementsConsume.setCreateAt(new Date());
        }
        movementsConsume.setType("Consume Business");
        movementsConsume.setCondition(0);
        Flux<CreditsBusiness> credit = webClientBuilder.build().put()
                .uri(urlbs)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsConsume),Card.class)
                .retrieve()
                .bodyToFlux(CreditsBusiness.class);
        dao.save(movementsConsume).subscribe();
        return credit.next();
    }
}
