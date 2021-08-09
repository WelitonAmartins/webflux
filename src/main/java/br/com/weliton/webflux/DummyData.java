package br.com.weliton.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.weliton.webflux.document.PlayList;
import br.com.weliton.webflux.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class DummyData  implements CommandLineRunner{
	
	private final PlayListRepository playlistRepository;
	

  @Override
  public void run(String... args) throws Exception {

  	playlistRepository.deleteAll()
              .thenMany(
                      Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
                              "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
                              .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
                              .flatMap(playlistRepository::save))
              .subscribe(System.out::println);
  }


}