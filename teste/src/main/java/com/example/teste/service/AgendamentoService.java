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
        if(agendamento.getDataHora().isBefore(LocalDateTime.now())){
            throw new RuntimeException(("ERRO! Não é possível agendar para uma data neste horário exato."));
        }

        //regra2: profissional não pode ter dois agendamentos no mesmo horário
        var ocupado = repository.findByProfissionalAndDataHora(agendamento.getProfissional(),agendamento.getDataHora()
        );

        //regra 3: todo agendamento novo nasce com status agendado
        agendamento.setStatus(StatusAgendamento.AGENDADO);
        return repository.save(agendamento);
    }

    //metodo para listar
    public List<Agendamento>listarTodos(){
        return repository.findAll();
    }

    //metodo para cancelar
    public Agendamento cancelar(Long id, String motivo){
        Agendamento agendamento = repository.findById(id).orElseThrow(() -> new RuntimeException("ERRO! Agendamento não encontrado"));

        //regra 4: mudar status para cancelado e registrar o motivo
        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamento.setMotivoCancelamento(motivo);
        return repository.save(agendamento);
    }
}
