package com.example.teste.service;

import com.example.teste.model.Agendamento;
import com.example.teste.model.StatusAgendamento;
import com.example.teste.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento agendar(Agendamento agendamento){
        //regra 1: não permitir data no passado
        if (agendamento.getDataHora().isBefore(LocalDateTime.now().minusMinutes(1))) {
            throw new RuntimeException("ERRO! Data no passado.");
        }

        //regra2: profissional não pode ter dois agendamentos no mesmo horário
        boolean jaOcupado = repository.existsByProfissionalAndDataHora(
                agendamento.getProfissional(),
                agendamento.getDataHora()
        );
        if (jaOcupado) {
            throw new RuntimeException("O profissional " + agendamento.getProfissional() + " já está ocupado!");
        }

        //regra 3: todo agendamento novo nasce com status agendado
        agendamento.setStatus(StatusAgendamento.AGENDADO);
        return repository.save(agendamento);
    }

    //metodo para listar
    public List<Agendamento>listarTodos(){
        return repository.findAll();
    }
    public List<Agendamento> listarComFiltros(String paciente, String profissional, StatusAgendamento status) {
        return repository.buscarComFiltros(paciente, profissional, status);
    }

    //metodo para cancelar
    public Agendamento cancelar(Long id, String motivo) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ERRO! Agendamento não encontrado"));

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamento.setMotivoCancelamento(motivo);
        return repository.save(agendamento);
    }
}