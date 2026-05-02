package com.example.teste.controller;

import com.example.teste.model.Agendamento;
import com.example.teste.model.StatusAgendamento;
import com.example.teste.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController{

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public List<Agendamento> listar(
            @RequestParam(required = false) String paciente,
            @RequestParam(required = false) String profissional,
            @RequestParam(required = false) StatusAgendamento status) {

        return service.listarComFiltros(paciente, profissional, status);
    }

    @PostMapping
    public Agendamento agendar (@RequestBody Agendamento agendamento){
        return service.agendar(agendamento);
    }

    //rota para cancelar: localhost:8080/agendamentos/1/cancelar?motivo=Desisti
    @PutMapping("/{id}/cancelar")
    public Agendamento cancelar(@PathVariable Long id, @RequestParam String motivo){
        return service.cancelar(id,motivo);
    }
}