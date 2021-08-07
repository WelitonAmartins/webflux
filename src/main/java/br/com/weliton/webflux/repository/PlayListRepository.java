package br.com.weliton.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.weliton.webflux.document.PlayList;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {

}
