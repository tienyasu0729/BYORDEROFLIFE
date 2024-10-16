package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_Coin")
public class UserCoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "coin_wallet", nullable = false)
    private int coinWallet = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCoinWallet() {
        return coinWallet;
    }

    public void setCoinWallet(Integer coinWallet) {
        this.coinWallet = coinWallet;
    }
}
