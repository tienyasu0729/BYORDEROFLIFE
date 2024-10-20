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

    @Email(message = "Email không hợp lệ.")
    @NotNull(message = "Email không được để trống.")
    @Column(name = "email", nullable = false)
    private String email;

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