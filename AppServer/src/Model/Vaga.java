package Model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class Vaga {

    private List<Pessoa> candidatos;
    private int id;
    private String descricao;

    public Vaga(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        candidatos = new ArrayList<>();
    }

    public List<Pessoa> getCandidatos() {
        return candidatos;
    }

    public void setCandidato(Pessoa candidato) {
        this.candidatos.add(candidato);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {        
        return "Vaga{" + "id=" + id + ", descricao=" + descricao + "}";
    }
    
    public String toStringCompleto(Vaga vaga){
        String texto = vaga.toString()+ ";";
        String candid = "";
        if(vaga.candidatos != null){
            candid = "Candidatos:;";
            for (Pessoa candidato : vaga.candidatos) {
                candid = candid + candidato.toString()+";";
            }        
        }
        return texto + candid;
    }
    
}
