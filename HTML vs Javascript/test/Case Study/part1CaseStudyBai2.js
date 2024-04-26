function part1CaseStudyBai2() {
    let h = +prompt("Nhập vào đây chiều cao của tam giác vuông cân rỗng");
    let print_To_The_Screen = "";
    for (let i = 0; i < h; i++) {
        for (let j = 0; j <= i; j++) {
            if (j === 0 || j === i || i === h - 1) {
                print_To_The_Screen += "* ";
            } else {
                print_To_The_Screen += "&nbsp;&nbsp;&nbsp";
            }
        }
        print_To_The_Screen += "<br>";
    }
    document.write(print_To_The_Screen);
}