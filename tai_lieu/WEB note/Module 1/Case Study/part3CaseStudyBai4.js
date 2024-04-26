function part3CaseStudyBai4() {
    let number = prompt("Nhập số cần đọc ra màn hình");
    let letter = ["Không","Một","Hai","Ba","Bốn","Năm","Sáu","Bảy","Tám","Chín"];
    let printToTheScreen = "";
    for (let i = 0; i < number.length; i++) {
        printToTheScreen += letter[number[i]] + " ";

    }
    alert(printToTheScreen);
    alert(typeof number);
}