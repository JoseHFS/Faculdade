Aluno: José Henrique Fernandes e Silva


Endpoints do professor 

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

Service professor

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
        return professorRepository.findByNomeContainingIgnoreCase(area);
    }

    public Professor atualizar(Long id, Professor professor) {

    Professor professorExistente = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado"));

    professorExistente.nome = professor.nome;
    professorExistente.email = professor.email;
    professorExistente.telefone = professor.telefone;
    professorExistente.area = professor.area;

    return professorRepository.save(professorExistente);
}

Isomaniac

Testar adicionar um novo professor

POST http://localhost:8080/professores

body
{
    "nome": "post test 1",
    "email": "email teste.com",
    "telefone": "8822",
    "area": "boneco de teste de colisão"
}

{
	"area": "boneco de teste de colisão",
	"email": "email teste.com",
	"id": 5,
	"nome": "post test 1",
	"telefone": "8822"
}

Testar Listar todos os professores

GET http://localhost:8080/professores/listar

[
	{
		"area": "Matemática",
		"email": "carlos.silva@email.com",
		"id": 1,
		"nome": "Carlos Eduardo Silva",
		"telefone": "86999990001"
	},
	{
		"area": "Português",
		"email": "ana.souza@email.com",
		"id": 2,
		"nome": "Ana Paula Souza",
		"telefone": "86999990002"
	},
	{
		"area": "História",
		"email": "marcos.oliveira@email.com",
		"id": 3,
		"nome": "Marcos Antônio Oliveira",
		"telefone": "86999990003"
	},
	{
		"area": "Banco de Dados",
		"email": "camila.nunes@email.com",
		"id": 4,
		"nome": "Camila Ferreira Nunes",
		"telefone": "86999990010"
	},
	{
		"area": "boneco de teste de colisão",
		"email": "email teste.com",
		"id": 5,
		"nome": "post test 1",
		"telefone": "8822"
	}
]


Buscar por id funciona

Get http://localhost:8080/professores/1


Deletar professor

http://localhost:8080/professores/2

Buscar professor por nome ignorando maiuscula e minuscula e só um pedaço do nome

GET http://localhost:8080/professores/nome/Carlos 

Buscar por area ignorando case, mas não ignora o acento

http://localhost:8080/professores/area/matemática


Editar professor

Put http://localhost:8080/professores/5

body

{
	"area": "boneco de teste atômico",
	"email": "email teste2.com",
	"id": 5,
	"nome": "put test 1",
	"telefone": "88228"
}
