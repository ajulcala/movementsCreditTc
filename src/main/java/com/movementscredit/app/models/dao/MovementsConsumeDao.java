package com.movementscredit.app.models.dao;

import com.movementscredit.app.models.documents.MovementsConsume;
import com.movementscredit.app.models.dto.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementsConsumeDao extends ReactiveMongoRepository<MovementsConsume,String> {
    Flux<MovementsConsume> findByCard(Card card);
}
