function part5CaseStudyBai3() {
    let m = +prompt("Nhập vào số hàng trong mảng 2 chiều");
    let n = +prompt("Nhập vào số cột trong mảng 2 chiều");
    let arr2chieu = Array(m);
    let max;
    let min;
    for (let i = 0; i < arr2chieu.length; i++) {
        arr2chieu[i] = Array(n);
        for (let j = 0; j < arr2chieu[i].length; j++) {
            arr2chieu[i][j] = +prompt("Nhập vào giá trị của hàng " + (i + 1) + " cột " + (j + 1) );

        }
    }
    max = arr2chieu[0][0];
    min = arr2chieu[0][0];
    for (let i = 0; i < arr2chieu.length; i++) {
        for (let j = 0; j < arr2chieu[i].length; j++) {
            if (max < arr2chieu[i][j]) {
                max = arr2chieu[i][j];
            }
            if (min > arr2chieu[i][j]) {
                min = arr2chieu[i][j];
            }
        }
    }
    alert("Số lớn nhất trong mảng 2 chiều là : " + max);
    alert("Số nhỏ nhất trong mảng 2 chiều là : " + min);
}