package com.example.gestao.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.gestao.Model.Professor;
import com.example.gestao.Repository.ProfessorRepository;


@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository=professorRepository;
    }

    
    public Professor buscarProfessor(long id){
        Professor professor = professorRepository.findById(id).orElseThrow();
        return professor;
    }

    public void excluir(long id){
        Professor professor = buscarProfessor(id);
        if(professor!= null){
            professorRepository.deleteById(id);
        }
    }

    public Professor cadastrarProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> buscarNome (String nome){
        if(nome==null || nome.isBlank()){
            return professorRepository.findAll();
        }
        return professorRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Professor> buscarArea (String area){
        if(area==null || area.isBlank()){
            return professorRepository.findAll();
        }
        return professorRepository.findByAreaContainingIgnoreCase(area);
    }

    public Professor atualizar(Long id, Professor professor) {

    Professor professorExistente = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado"));

    professorExistente.nome = professor.nome;
    professorExistente.email = professor.email;
    professorExistente.telefone = professor.telefone;
    professorExistente.area = professor.area;

    return professorRepository.save(professorExistente);
}


    

    }

    



