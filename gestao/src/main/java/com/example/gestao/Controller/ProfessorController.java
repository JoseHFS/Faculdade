package com.example.gestao.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.gestao.Model.Professor;
import com.example.gestao.Repository.ProfessorRepository;
import com.example.gestao.Service.ProfessorService;


import java.util.List;

@RestController 
@RequestMapping ("/professores")

public class ProfessorController {

    
    private final ProfessorRepository professorRepository;
    private final ProfessorService professorService;

    

    public ProfessorController(ProfessorRepository professorRepository,ProfessorService professorService) {
        this.professorRepository = professorRepository;
        this.professorService=professorService;
    }

    @GetMapping("/listar")
    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor buscarProfessor(@PathVariable  Long id){
        return professorService.buscarProfessor(id);
    }

    @DeleteMapping("/{id}")
        public String excluirProfessor(@PathVariable Long id){
            professorService.excluir(id);
            return "Professor excluido";
        }
        
    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor){
        return professorService.cadastrarProfessor(professor);
    }

    @GetMapping("/nome/{nome}")
    public List<Professor> buscarNome(@PathVariable String nome){
        return professorService.buscarNome(nome);
    }

    @GetMapping("/area/{area}")
    public List<Professor> buscarArea(@PathVariable String area){
        return professorService.buscarArea(area);
    }

     @PutMapping("/{id}")
    public Professor atualizarProfessor(
            @PathVariable Long id,
            @RequestBody Professor professor) {

        return professorService.atualizar(id, professor);
    }

}
