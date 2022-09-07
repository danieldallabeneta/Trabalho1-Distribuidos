package Dao;

import Model.Pessoa;
import Model.Vaga;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class VagaDao {

    private List<Vaga> vagas;
    private PessoaDao dadosPessoa;

    public VagaDao() {
        vagas = new ArrayList<>();
    }

    public String addVaga(Vaga vaga) {
        vagas.add(vaga);
        return "Vaga inserida com Sucesso!";
    }

    public String InserirCandidato(int vaga, Pessoa pessoa) {
        int buscaVaga = vaga;
        Pessoa candidato = pessoa;

        for (Vaga vaga1 : vagas) {
            if (vaga1.getId() == vaga) {
                vaga1.setCandidato(candidato);
                return "Candidato inserido com Sucesso!";
            }
        }
        return "Vaga não encontrada";
    }

    public List<Vaga> getAll() {
        return vagas;
    }

    public String removeCandidatoTodasVagas(Pessoa candidato) {
        for (Vaga vaga : getAll()) {
            for(Pessoa pes : vaga.getCandidatos()){
                if(pes.equals(candidato)){
                    vaga.getCandidatos().remove(pes);
                    break;
                }
            }
        }
        return "Candidato removido de Todas as Vagas.";
    }
    
    public String deleteVaga(int codigo){
        if(vagas != null){
            for (Vaga vaga : vagas) {
                if(vaga.getId() == codigo){
                    vagas.remove(vaga);
                    return "Vaga Excluída com Sucesso.";
                }
            }
        }
        return "Vaga não encontrada";
    }

    public String getAllVagas(){
        String dados = "";
        for (Vaga vaga : vagas) {            
            dados = dados + vaga.toStringCompleto(vaga);            
        }
        return dados;
    }
    
    public String alterVaga(String[] dados){
        int codigo = Integer.parseInt(dados[2]);
        String descricao = dados[3];
        for (Vaga vaga : vagas) {
            if(vaga.getId() == codigo){
                vaga.setDescricao(descricao);
                return "Vaga Alterada com Sucesso";
            }
        }
        return "Vaga não encontrada";
        
    }
    
    public Vaga buscaVaga(int codigo){
        for (Vaga vaga : vagas) {
            if(vaga.getId() == codigo){
                return vaga;
            }
        }
        return null;
    }
    
}
