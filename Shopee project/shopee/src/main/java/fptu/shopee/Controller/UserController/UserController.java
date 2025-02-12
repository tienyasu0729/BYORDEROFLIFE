package fptu.shopee.Controller.UserController;

import fptu.shopee.Model.UserPackage.User;
import fptu.shopee.Repository.UserReposotory.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/shop")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/")
    public String showPage() {
        return "index";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String identifier, @RequestParam String password) {
        // Tìm người dùng theo email hoặc số điện thoại
        Optional<User> userOptional = userRepository.findByEmailOrPhoneNumber(identifier, identifier);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Kiểm tra mật khẩu có trùng khớp không
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok("Đăng nhập thành công!");
            } else {
                return ResponseEntity.status(401).body("Mật khẩu không chính xác!");
            }
        } else {
            return ResponseEntity.status(404).body("Không tìm thấy tài khoản!");
        }
    }
}