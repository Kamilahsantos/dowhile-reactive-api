package com.rocketseat.projeto.controller;

import com.rocketseat.projeto.model.Devs;
import com.rocketseat.projeto.repository.DevsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class DevsController {

    @Autowired
    private DevsRepository devsRepository;

    @PostMapping("/dev")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Devs> createDev (@Valid  @RequestBody Devs devs){
        return  devsRepository.save(devs);
    }

    @GetMapping("/dev")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Devs> getAllDev (){
        return  devsRepository.findAll();
    }

    @GetMapping("/dev/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Devs>> getDevById (@PathVariable (value = "id") String devId){
        return  devsRepository.findById(devId)
                .map(savedDev -> ResponseEntity.ok(savedDev))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/dev/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Devs>> updateDev (@PathVariable (value = "id") String devId,
                                                  @Valid @RequestBody Devs devs){
        return  devsRepository.findById(devId)
                .flatMap(existingDev -> {
                    existingDev.setName(devs.getName());
                    return  devsRepository.save(existingDev);

                }).map(updateDev -> new ResponseEntity<>(updateDev, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/devs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteDev(@PathVariable(value = "id") String devId) {

        return devsRepository.findById(devId)
                .flatMap(existingDiva ->
                        devsRepository.delete(existingDiva)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/stream/devs", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Devs> streamAllDevs() {
        return devsRepository.findAll();
    }






}
