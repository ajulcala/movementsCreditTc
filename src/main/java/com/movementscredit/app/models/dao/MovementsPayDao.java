package com.movementscredit.app.models.dao;

import com.movementscredit.app.models.documents.MovementsPay;
import com.movementscredit.app.models.dto.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementsPayDao extends ReactiveMongoRepository<MovementsPay, String> {
    Flux<MovementsPay> findByCard(Card card);
}
