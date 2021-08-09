package br.com.weliton.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.weliton.webflux.document.PlayList;
import br.com.weliton.webflux.service.PlayListService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/playlist")
public class PlayListController {
	
	private final PlayListService playListService;

	@GetMapping
	public Flux<PlayList> findtPlayList() {
		return this.playListService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<PlayList> findPlayListId(@PathVariable String id) {
		return this.playListService.findById(id);
	}
	
	@PostMapping
	public Mono<PlayList> save(@RequestBody PlayList playlist) {
		return this.playListService.save(playlist);
	}
}
