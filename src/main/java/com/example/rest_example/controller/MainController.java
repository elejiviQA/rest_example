package com.example.rest_example.controller;

import com.example.rest_example.DTO.CatDTO;
import com.example.rest_example.entity.Cat;
import com.example.rest_example.repository.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;

    @Operation(
            summary = "добавляет новую кису в базу",
            description = "получает DTO кисы и билдером собирает и сохраняет сущность в базу"
    )
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO catDTO) {
        log.info("New row: {}", catRepo.save(
                Cat.builder()
                        .name(catDTO.getName())
                        .age(catDTO.getAge())
                        .weight(catDTO.getWeight())
                        .build()));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAllCats() {

        return catRepo.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {

        return catRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {

        catRepo.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId())) {
            return "No such row";
        }
        return catRepo.save(cat).toString();
    }
}