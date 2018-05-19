/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Luiz
 */
@Entity(name = "usuario")
public class Usuario extends Pessoa implements Serializable {

    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emailUsuario", nullable = false)
    private String emailUsuario;

    private boolean ativo;

    private String nacionalidade;

    private Date dataNasc;

    @Transient
    private static Usuario getInstance;

    public Usuario() {
    }

    public static Usuario getInstance() {
        if (getInstance == null) {
            getInstance = new Usuario();
        }
        return getInstance;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public static Usuario getGetInstance() {
        return getInstance;
    }

    public static void setGetInstance(Usuario getInstance) {
        Usuario.getInstance = getInstance;
    }

}
