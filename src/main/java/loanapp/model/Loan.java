package loanapp.model;

import javax.persistence.*;

@Entity
@Table(name = "Loans")
@NamedQuery(name="Voting.Print",query = "Select l From Loan as l")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "edrpou", nullable = false)
    private String edrpou;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "sum", nullable = false)
    private String sum;
    @Column(name = "documents", columnDefinition = "text", nullable = false)
    private String documents;
    @Column(name = "status", columnDefinition = "varchar(255) default 'на розгляді'",updatable = true)
    private String status = "на розгляді";

//    @Column(name = "pib")
//    private String pib;
//    @Column(name = "birth")
//    private String birth;
/*    @Column(name = "entrydate")
    @CreationTimestamp
    private Date entrydate;*/

    public Loan() {
    }

    public Loan(int id, String edrpou, String name, String sum, String documents, String status) {
        this.id = id;
        this.edrpou = edrpou;
        this.name = name;
        this.sum = sum;
        this.documents = documents;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", edrpou='" + edrpou + '\'' +
                ", name='" + name + '\'' +
                ", sum='" + sum + '\'' +
                ", documents='" + documents + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}