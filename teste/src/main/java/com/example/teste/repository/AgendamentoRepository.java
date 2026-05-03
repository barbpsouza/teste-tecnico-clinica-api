package com.example.teste.repository;

import com.example.teste.model.Agendamento;
import com.example.teste.model.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    //esse metodo vai procurar se ja existe um agendamento para aquele medico naquele horario
    //o spring data jpa cria a logica sozinho so pelo nome do metodo
    Optional<Agendamento> findByProfissionalAndDataHora(String profissional, LocalDateTime dataHora);
    boolean existsByProfissionalAndDataHora(String profissional, LocalDateTime dataHora);
    //filtros
    @Query("SELECT a FROM Agendamento a WHERE " +
            "(:paciente is null or LOWER(a.paciente.nome) LIKE LOWER(CONCAT('%', :paciente, '%'))) AND " +
            "(:profissional is null or LOWER(a.profissional) LIKE LOWER(CONCAT('%', :profissional, '%'))) AND " +
            "(:status is null or a.status = :status)")
    List<Agendamento> buscarComFiltros(
            @Param("paciente") String paciente,
            @Param("profissional") String profissional,
            @Param("status") StatusAgendamento status);}
