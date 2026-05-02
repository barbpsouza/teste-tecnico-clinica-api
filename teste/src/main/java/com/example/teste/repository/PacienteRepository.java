package com.example.teste.repository;

//o repository é a ponte entre o código java e os dados guardados
import com.example.teste.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
