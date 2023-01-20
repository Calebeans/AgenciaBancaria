package programa;

import utilitarios.Utils;

import java.util.Date;
public class Pessoa {

    private static int counter = 1;

    private int numeroPessoa;
    private String name;
    private String CPF;
    private String email;
    private Date accountCreationDate;

    public Pessoa(String name, String CPF, String email) {
        this.numeroPessoa = Pessoa.counter;
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.accountCreationDate = new Date();
        Pessoa.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public String toString(){
        return "\nNome: " + this.getName() +
                "\nCPF: " + this.getCPF() +
                "\nEmail: " + this.getEmail() +
                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
    }
}
