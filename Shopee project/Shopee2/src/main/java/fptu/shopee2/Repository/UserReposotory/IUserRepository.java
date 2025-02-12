package fptu.shopee2.Repository.UserReposotory;


import fptu.shopee.Model.UserPackage.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    // Tìm kiếm người dùng theo email hoặc số điện thoại
    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
