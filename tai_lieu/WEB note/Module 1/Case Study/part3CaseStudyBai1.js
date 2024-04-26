function part3CaseStudyBai1() {
    let n = +prompt("Nhập vào đây số phần tử có trong mảng ");
    let arr_a = [];
    let arr_b = [];
    let push = 0;
    for (let i = 0; i < n; i++) {
        arr_a[i] = +prompt("Nhập vào đây phần tử thứ " + (i + 1) + "của mảng a");
    }
    for (let i = 0; i < n; i++) {
        push += arr_a [i]
        arr_b[i] = push;
    }
    alert("Prefix sums của mảng a là : " + arr_b);
}