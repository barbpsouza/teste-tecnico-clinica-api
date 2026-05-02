package com.example.teste.service;

import com.example.teste.model.Agendamento;
import com.example.teste.repository.AgendamentoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AgendamentoServiceTest {

    @InjectMocks
    private AgendamentoService service;

    @Mock
    private AgendamentoRepository repository;

    @Test
    @DisplayName("Deve dar erro ao tentar agendar em uma data no passado.")
    void erroAoAgendarNoPassado(){
        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(LocalDateTime.now().minusDays(1));
        agendamento.setProfissional("Dr Marcelo");

        assertThrows(RuntimeException.class, () ->{
            service.agendar(agendamento);
        });
    }

}
