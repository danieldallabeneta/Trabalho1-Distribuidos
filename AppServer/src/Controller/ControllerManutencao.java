package Controller;

import Dao.PessoaDao;
import Dao.VagaDao;
import Model.Pessoa;
import Model.Vaga;

/**
 *
 * @author danie
 */
public class ControllerManutencao {

    private PessoaDao dadosPessoa;
    private VagaDao dadosVaga;

    public ControllerManutencao() {
        dadosPessoa = new PessoaDao();
        dadosVaga = new VagaDao();
    }

    public String processaDadosRecebidos(String dadosProcess) {
        String[] dados = dadosProcess.split(";");
        switch (dados[0]) {
            case "INSERT":
                if(dados[1].equals("PESSOA")){
                    return inserePessoa(dados);
                }
                if(dados[1].equals("VAGA")){
                    return insereVaga(dados);
                }
                if(dados[1].equals("CANDIDATO")){
                    return insereCandidato(dados);
                }
                
            case "DELETE":
                if(dados[1].equals("PESSOA")){
                    return deletePessoa(dados);
                }
                if(dados[1].equals("VAGA")){
                    return deleteVaga(dados);
                }
            case "LIST":
                if(dados[1].equals("PESSOA")){
                    return listPessoas();
                }
                if(dados[1].equals("VAGA")){
                    return listVagas();
                }
            case "GET":
                if(dados[1].equals("PESSOA")){
                    return buscaPessoa(dados);
                }
                if(dados[1].equals("VAGA")){
                    return buscaVaga(dados);
                }
            case "ALTER":
                if(dados[1].equals("PESSOA")){
                    return alteraPessoa(dados);
                }
                if(dados[1].equals("VAGA")){
                    return alteraVaga(dados);
                }
            
        }
        return "Ação não encontrada";
    }

    private String inserePessoa(String[] dados) {
        String nome = dados[2];
        String cpf = dados[3];
        String endereco = dados[4];
        
        Pessoa novaPessoa = new Pessoa(nome, cpf, endereco);
        return dadosPessoa.addPessoa(novaPessoa);
    }

    private String insereVaga(String[] dados) {
        int codigo = Integer.parseInt(dados[2]);
        String descricao = dados[3];
        Vaga novaVaga = new Vaga(codigo, descricao);
        return dadosVaga.addVaga(novaVaga);

    }

    private String insereCandidato(String[] dados) {
        int codVaga = Integer.parseInt(dados[2]);
        String cpf = dados[3];
        Pessoa candidato = dadosPessoa.buscaPessoa(cpf);
        if (candidato == null) {
            return "Candidato não encontrado";
        }
        return dadosVaga.InserirCandidato(codVaga, candidato);
    }
    
    private String deletePessoa(String[] dados) {
        String cpf = dados[2];
        Pessoa pessoa = dadosPessoa.buscaPessoa(cpf);
        String removeCandidato = deleteCandidato(dados);
        String retorno = dadosPessoa.deletePessoa(pessoa);
        
        return removeCandidato+";"+retorno;
    }
    
    private String deleteCandidato(String[] dados){
        String cpf = dados[2];
        Pessoa pessoa = dadosPessoa.buscaPessoa(cpf);
        return dadosVaga.removeCandidatoTodasVagas(pessoa);
    }
    
    private String deleteVaga(String[] dados){
        String codigo = dados[2];
        return dadosVaga.deleteVaga(Integer.parseInt(codigo));
    }
    
    private String listPessoas(){
        return dadosPessoa.getAllPessoas();
    }
    
    private String listVagas(){
        return dadosVaga.getAllVagas();
    }
    
    private String buscaPessoa(String[] dados){
        String cpf = dados[2];
        Pessoa pessoa = dadosPessoa.buscaPessoa(cpf);
        return pessoa.getNome()+";"+pessoa.getCpf()+";"+pessoa.getEndereco();
    }
    
    private String buscaVaga(String[] dados){
        int codigo = Integer.parseInt(dados[2]);
        Vaga vaga = dadosVaga.buscaVaga(codigo);
        return vaga.getId()+";"+vaga.getDescricao();
    }

    private String alteraPessoa(String[] dados){
        return dadosPessoa.alterPessoa(dados);
    }

    private String alteraVaga(String[] dados){
        return dadosVaga.alterVaga(dados);
    }
    
}
