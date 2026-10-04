package com.example.gestao.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestao.Model.Professor;


@Repository 
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByNomeContainingIgnoreCase(String nome);

    List<Professor> findByAreaContainingIgnoreCase(String area);

}
