function part2CaseStudyBai1() {
    let salary;
    do {
        salary = +prompt("Nhập vào đây mức lương của bạn ");
    } while (salary < 0);
    let tax;
    if (salary < 7000000) {
        tax = salary / 100 * 5;
        alert("Thuế bạn cần phải đóng là :" + tax + "vnd");
        alert("lương của bạn sau khi trừ thuế là :" + (salary - tax) + "vnd");
    } else {
        if (7000 <= salary < 15000000) {
            tax = salary / 100 * 10;
            alert("Thuế bạn cần phải đóng là :" + tax + "vnd");
            alert("lương của bạn sau khi trừ thuế là :" + (salary - tax) + "vnd");
        } else {
            if (salary >= 15000000) {
                tax = salary / 100 * 20;
                alert("Thuế bạn cần phải đóng là :" + tax + "vnd");
                alert("lương của bạn sau khi trừ thuế là :" + (salary - tax) + "vnd");
            }
        }
    }
}