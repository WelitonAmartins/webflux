package br.com.weliton.webflux.service;

import org.springframework.stereotype.Service;

import br.com.weliton.webflux.document.PlayList;
import br.com.weliton.webflux.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PlayListServiceImpl implements PlayListService {
	
	private final PlayListRepository playListRepository;

	@Override
	public Flux<PlayList> findAll() {
		return playListRepository.findAll();
	}

	@Override
	public Mono<PlayList> findById(String id) {
		return playListRepository.findById(id);
	}

	@Override
	public Mono<PlayList> save(PlayList playlsit) {
		return playListRepository.save(playlsit);
	}

}
