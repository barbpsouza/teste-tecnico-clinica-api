package com.example.teste.controller;

import com.example.teste.model.Agendamento;
import com.example.teste.model.StatusAgendamento;
import com.example.teste.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // permite que o front acesso a API sem erro
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

    // Rota para cancelar: localhost:8080/agendamentos/1/cancelar
    @PutMapping("/{id}/cancelar")
    public Agendamento cancelar(@PathVariable Long id, @RequestBody java.util.Map<String, String> body) {
        String motivo = body.get("motivo");
        return service.cancelar(id, motivo);
    }

}