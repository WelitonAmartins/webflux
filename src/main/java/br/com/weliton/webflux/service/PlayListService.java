package br.com.weliton.webflux.service;

import br.com.weliton.webflux.document.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {

	Flux<PlayList> findAll();
	
	Mono<PlayList> findById (String id);
	
	Mono<PlayList> save(PlayList playlsit);
}
