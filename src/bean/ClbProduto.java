package bean;
// Generated 14/09/2023 08:05:16 by Hibernate Tools 4.3.1



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClbProduto generated by hbm2java
 */
@Entity
@Table(name="clb_produto"
    ,catalog="db_camilly_barrios"
)
public class ClbProduto  implements java.io.Serializable {


     private int clbIdproduto;
     private String clbNomeProduto;
     private String clbAssunto;
     private String clbAutor;
     private String clbEditora;
     private double clbPreco;
     

    public ClbProduto() {
    }

	
    public ClbProduto(String clbNomeProduto, String clbAssunto, String clbAutor, String clbEditora, double clbPreco) {
        this.clbNomeProduto = clbNomeProduto;
        this.clbAssunto = clbAssunto;
        this.clbAutor = clbAutor;
        this.clbEditora = clbEditora;
        this.clbPreco = clbPreco;
    }

   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="clb_idproduto", unique=true, nullable=false)
    public int getClbIdproduto() {
        return this.clbIdproduto;
    }
    
    public void setClbIdproduto(int clbIdproduto) {
        this.clbIdproduto = clbIdproduto;
    }

    
    @Column(name="clb_nomeProduto", nullable=false, length=60)
    public String getClbNomeProduto() {
        return this.clbNomeProduto;
    }
    
    public void setClbNomeProduto(String clbNomeProduto) {
        this.clbNomeProduto = clbNomeProduto;
    }

    
    @Column(name="clb_assunto", nullable=false, length=45)
    public String getClbAssunto() {
        return this.clbAssunto;
    }
    
    public void setClbAssunto(String clbAssunto) {
        this.clbAssunto = clbAssunto;
    }

    
    @Column(name="clb_autor", nullable=false, length=100)
    public String getClbAutor() {
        return this.clbAutor;
    }
    
    public void setClbAutor(String clbAutor) {
        this.clbAutor = clbAutor;
    }

    
    @Column(name="clb_editora", nullable=false, length=100)
    public String getClbEditora() {
        return this.clbEditora;
    }
    
    public void setClbEditora(String clbEditora) {
        this.clbEditora = clbEditora;
    }

    
    @Column(name="clb_preco", nullable=false, precision=10)
    public double getClbPreco() {
        return this.clbPreco;
    }
    
    public void setClbPreco(double clbPreco) {
        this.clbPreco = clbPreco;
    }
    
 @Override
    public String toString(){
        return this.clbNomeProduto;
    }
    
    
    @Override
    public boolean equals(Object object){
        if(object instanceof ClbProduto){
            ClbProduto clbProduto = (ClbProduto) object;
            if(this.getClbIdproduto()== clbProduto.getClbIdproduto()){
                return true;
            }
        }
        return false;
    }




}


