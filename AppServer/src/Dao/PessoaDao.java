package Dao;

import Model.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class PessoaDao {
    
    private List<Pessoa> pessoas;

    public PessoaDao() {
        pessoas = new ArrayList<>();
    }
    
    public String addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
        return "Pessoa inserida com Sucesso!";
    }
    
    public Pessoa buscaPessoa(String cpf){
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }
    
    public String deletePessoa(Pessoa pes){
        pessoas.remove(pes);
        return "Pessoa removida com Sucesso";
    }
    
    public String getAllPessoas(){
        String dados = "";
        for (Pessoa pessoa : pessoas) {
            dados = dados + pessoa.toString()+";";
        }
        return dados;
    }
    
    public String alterPessoa(String[] dados){
        String nome = dados[2];
        String cpf = dados[3];
        String endereco = dados[4];
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getCpf().equals(cpf)){
                pessoa.setNome(nome);
                pessoa.setEndereco(endereco);
                return "Pessoa Alterada com Sucesso";
            }
        }
        return "Pessoa não encontrada";
        
    }
    
}
