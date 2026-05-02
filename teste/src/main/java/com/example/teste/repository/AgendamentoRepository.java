package com.example.teste.repository;

import com.example.teste.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    //esse metodo vai procurar se ja existe um agendamento para aquele medico naquele horario
    //o spring data jpa cria a logica sozinho so pelo nome do metodo
    Optional<Agendamento> findByProfissionalAndDataHora(String profissional, LocalDateTime dataHora);
}
