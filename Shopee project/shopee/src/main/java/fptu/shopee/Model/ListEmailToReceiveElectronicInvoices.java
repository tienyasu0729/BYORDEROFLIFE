package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_email_to_receive_electronic_invoices")
public class ListEmailToReceiveElectronicInvoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_List_Email_To_Receive_Electronic_Invoices")
    private int idListEmailToReceiveElectronicInvoices;

    @Email(message = Message.messEmail)
    @NotNull(message = Message.messNotNullEmail)
    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_shop", nullable = false)
    private Shop shop;

    public int getIdListEmailToReceiveElectronicInvoices() {
        return idListEmailToReceiveElectronicInvoices;
    }

    public void setIdListEmailToReceiveElectronicInvoices(int idListEmailToReceiveElectronicInvoices) {
        this.idListEmailToReceiveElectronicInvoices = idListEmailToReceiveElectronicInvoices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}