package Model;


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
        return "Vaga{" + "id=" + id + ", descricao=" + descricao + "}\n";
    }
    
    public String toStringCompleto(){
        String texto = "Vaga{" + "id=" + id + ", descricao=" + descricao + "}\n";
        for (Pessoa candidato : candidatos) {
            texto = texto + candidato.toString()+"\n";
        }
        texto = texto + "\n";
        return texto;
    }
    
}
