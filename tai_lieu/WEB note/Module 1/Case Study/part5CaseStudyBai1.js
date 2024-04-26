function part5CaseStudyBai1() {
    let m = +prompt("Nhập vào đây hàng M của ma trận");
    let n = +prompt("Nhập vào đây cột N của ma trận");
    let arr = Array(m);
    let sumofevennumbers = 0;
    for (let i = 0; i < arr.length; i++) {
        arr[i] = Array(n);
        for (let j = 0; j < arr[i].length; j++) {
            arr[i][j] = +prompt("Nhập giá trị cho ma trân hàng " + (i + 1) + " cột " + (j + 1));
            if (arr[i][j] % 2 === 0) {
                sumofevennumbers += arr[i][j];
            }
        }
    }
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length ; j++) {
            document.write(arr[i][j] + " ");
        }
        document.write("<br>");
    }
    alert("Tổng các số chẵn trong ma trận là : " + sumofevennumbers);
}