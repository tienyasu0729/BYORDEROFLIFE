function part3CaseStudyBai3() {
    let n = +prompt("Nhập vào đây số lượng phân số cần kiểm tra");
    let arr_numerators = [];
    let arr_denominators = [];
    let fractons = Array();
    let printFractions = Array();
    let printToScreen = "";
    let maxFractions = 0;
    for (let i = 0; i < n; i++) {
        arr_numerators[i] = +prompt("Nhập vào đây tử số của phần tử thứ " + (i + 1));
        do {
            arr_denominators[i] = +prompt("Nhập vào đây mẫu số của phần tử thứ " + (i + 1));
        } while (arr_denominators[i] === 0);
        fractons[i] = arr_numerators[i] / arr_denominators[i];
        printFractions[i] = arr_numerators[i] + "/" + arr_denominators[i];
    }
    for (let i = 0; i < fractons.length; i++) {
        if (maxFractions < fractons[i]) {
            maxFractions = fractons[i];
            printToScreen = "Phân số lớn nhất là = " + printFractions[i] + " và có chỉ số là : " + i;
        }
    }
    alert(printToScreen);
}