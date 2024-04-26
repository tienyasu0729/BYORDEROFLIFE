function part3CaseStudyBai2() {
    let n_a = +prompt("Nhập vào đây số phần tử của mảng a");
    let arr_a = [];
    let n_b = +prompt("Nhập vào đây số phần tử của mảng b");
    let arr_b = [];
    for (let i = 0; i < n_a; i++) {
        arr_a[i] = +prompt("Nhập vào đây giá trị của phần tử thứ " + (i + 1) + "của mảng a :");
    }
    for (let i = 0; i < n_b; i++) {
        arr_b[i] = +prompt("Nhập vào đây giá trị của phần tử thứ " + (i + 1) + "của mảng b :");
    }
    let missing_Value = "";
    let a = Array();
    let c = 1;
    for (let i = 0; i < n_a; i++) {
        for (let j = 0; j < n_b; j++) {
            if (arr_a[i] === arr_b[j]) {
                for (let k = 0; k < c; k++) {
                    a[k] = arr_a[i];
                }
            }
        }
        if (a.length === 0) {
            missing_Value += arr_a[i] + ", ";
        } else {
            a = [];
        }
    }
    for (let i = 0; i < n_b; i++) {
        for (let j = 0; j < n_a; j++) {
            if (arr_b[i] === arr_a[j]) {
                for (let k = 0; k < c; k++) {
                    a[k] = arr_b[i];
                }
            }
        }
        if (a.length === 0) {
            missing_Value += arr_b[i] + ", ";
        } else {
            a = [];
        }
    }
    alert("Prefix Sums [ A , B ] = " + missing_Value);
}