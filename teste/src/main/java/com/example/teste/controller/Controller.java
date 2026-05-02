package com.example.teste.controller;

import com.example.teste.model.Paciente;
import com.example.teste.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //diz que essa classe é uma API e deve ser enviado diretamente como JSON
@RequestMapping("/pacientes") //define a URL base: localhost:8080/pacientes
public class Controller {
    @Autowired //faz a ponte com o repository
    private PacienteRepository repository;

    //metodo para listar todos (GET)
    @GetMapping //para buscas
    public List<Paciente> listarTodos(){
        return repository.findAll();
    }

    //metodo para salvar um novo (POST)
    @PostMapping
    public Paciente criar(@RequestBody Paciente paciente){
        //o RequestBody diz para o spring pegar os dados que o usuário enviou
        //e transforma em um objeto Paciente.
        return repository.save(paciente);
    }

}
