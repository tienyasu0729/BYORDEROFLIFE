function part1CaseStudyBai1() {
    let n = +prompt("Nhập vào đây chiều dài của hình chữ nhật"); // hàng
    let m = +prompt("Nhập vào đây chiều rộng của hình chữ nhật");// cột
    let print_To_The_Screen = "";
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i === 0 || j === 0 || j === n - 1 || i === m - 1) {
                print_To_The_Screen += "* ";
            } else {
                print_To_The_Screen += "&nbsp;&nbsp;&nbsp";
            }
        }
        print_To_The_Screen += "<br>";
    }
    document.write(print_To_The_Screen);
}