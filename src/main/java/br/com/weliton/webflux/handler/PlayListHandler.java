package br.com.weliton.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.weliton.webflux.document.PlayList;
import br.com.weliton.webflux.service.PlayListService;
import reactor.core.publisher.Mono;

//@Component
public class PlayListHandler {

	@Autowired
	PlayListService playListService;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.playListService.findAll(), PlayList.class);
	}
	
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.playListService.findById(id), PlayList.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<PlayList> playlist = request.bodyToMono(PlayList.class);
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(playlist.flatMap(playListService::save), PlayList.class));
	}
}
