function part5CaseStudyBai2() {
    let m = +prompt("Nhập vào số hàng của mảng");
    let n = +prompt("Nhập vào số cột của mảng");
    let arr = Array(m);
    let a = 0;
    let primenumbers = Array();
    for (let i = 0; i < arr.length; i++) {
        arr[i] = Array(n);
        for (let j = 0; j < arr[i].length; j++) {
            arr[i][j] = +prompt("Nhập vào đây giấ trị của hàng " + (i + 1) + " cột " +(j + 1) );
            if (arr[i][j] === 2 && arr[i][j] > 1 || arr[i][j] === 3 && arr[i][j] > 1 || arr[i][j] > 1 && arr[i][j] % 2 !== 0 && arr[i][j] % 3 !== 0) {
                primenumbers[a] = arr[i][j] + " ";
                ++a;
            }
        }
    }
    alert("Các số nguyên tố trong mảng là : " + primenumbers);
}