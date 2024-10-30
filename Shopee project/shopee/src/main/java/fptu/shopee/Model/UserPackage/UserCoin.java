package fptu.shopee.Model.UserPackage;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_Coin")
public class UserCoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_coin")
    private int id;

    @NotNull
    @Column(name = "coin_wallet", nullable = false)
    private int coinWallet = 0;

    @OneToOne
    @MapsId // Maps khóa ngoại thành khóa chính
    @JoinColumn(name = "id_user")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoinWallet() {
        return coinWallet;
    }

    public void setCoinWallet(Integer coinWallet) {
        this.coinWallet = coinWallet;
    }
}
