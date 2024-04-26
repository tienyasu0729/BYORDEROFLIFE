function part1CaseStudyBai4() {
    let h = +prompt("Nhập vào đây chiều cao của tam giác cân rỗng ruột");
    let x = h;
    let a = h - 1;
    let print_To_The_Screen = "";
    for (let i = 0; i < h; i++) {
        for (let j = 0; j < x; j++) {
            if (j === x - 1 || j === a || i === h - 1) {
                print_To_The_Screen += "* ";
            } else {
                print_To_The_Screen += "&nbsp;&nbsp;&nbsp";
            }
        }
        x++;
        a--;
        print_To_The_Screen += "<br>";
    }
    document.write(print_To_The_Screen);
}