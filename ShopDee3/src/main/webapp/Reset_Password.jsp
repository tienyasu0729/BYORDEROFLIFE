<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên M?t Kh?u</title>
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
    background: linear-gradient(135deg, #74ebd5, #ACB6E5);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    font-family: 'Poppins', sans-serif;
}

.login-container {
    background: #ffffff;
    padding: 30px 40px;
    border-radius: 12px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
    width: 350px;
    text-align: center;
    animation: fadeIn 1s ease-in-out;
}

@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(-20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

.login-form h2 {
    margin-bottom: 20px;
    color: #333;
    font-size: 24px;
}

.input-group {
    margin-bottom: 20px;
    text-align: left;
}

.input-group label {
    display: block;
    margin-bottom: 8px;
    color: #555;
    font-weight: 500;
}

.input-group input {
    width: 100%;
    padding: 12px 15px;
    border: 1px solid #ddd;
    border-radius: 8px;
    font-size: 16px;
    transition: all 0.3s ease;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
}

.input-group.focused input {
    border-color: #74ebd5;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

button {
    width: 100%;
    padding: 15px;
    background: linear-gradient(135deg, #74ebd5, #ACB6E5);
    border: none;
    border-radius: 8px;
    color: white;
    font-size: 18px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

button:hover {
    background: linear-gradient(135deg, #ACB6E5, #74ebd5);
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
}

.footer {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
}

.footer a {
    color: #4a9285;
    text-decoration: none;
    font-weight: 500;
    transition: color 0.3s ease;
}

.footer a:hover {
    color: #ACB6E5;
    text-decoration: underline;
}
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-form">
            <h2>Reset password</h2>
            <form action="/forgot-password" method="POST">
                <div class="input-group">
                    <label for="email">New password </label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="input-group">
                    <label for="email">Password again </label>
                    <input type="email" id="email" name="email" required>
                </div>
                <button type="submit">Change</button>
            </form>
            <div class="footer">
                <a href="login.jsp">Login</a>
                <a href="register.jsp">Register</a>
            </div>
        </div>
    </div>
    <script src="script.js"></script>
</body>
</html>
