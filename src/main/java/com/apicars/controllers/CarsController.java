package com.apicars.controllers;

import java.util.List;

import com.apicars.entities.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apicars.repositories.CarsRepository;

@RestController
@RequestMapping(value = "/carros")
public class CarsController {

    @Autowired
    private CarsRepository repository;

    @GetMapping
    public List<Cars> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Cars findAll(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Cars insert(@RequestBody Cars user) {
        return repository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Cars update(@RequestBody Cars cars, @PathVariable Long id) {
        Cars carsUpdate = repository.getById(id);
        carsUpdate.setBrand(cars.getBrand());
        carsUpdate.setName(cars.getName());
        carsUpdate.setCor(cars.getCor());
        carsUpdate.setYear(cars.getYear());

        return repository.save(carsUpdate);

    }
}
