function part4CaseStudyBai1() {
    let something = prompt("Nhập vào đây một chuỗi nào đó");
    let arr = Array();
    let print = "";

    for (let i = 0; i < something.length; i++) {
        arr[i] = something[i];
    }
    for (let i = 0; i < arr.length - 1 ; i++) {
        if (arr[i] === " " && arr [i+1] === " ") {
            arr.splice(i, 1);
            --i;
        }
    }
    if (arr[0] === " ") { // nếu phần tử đầu à rỗng thì xoá nó
        arr.shift();
    }
    if (arr[arr.length -1] === " ") {
        arr.pop();
    }
    if (arr[0] !== " ") { // Nếu phần tử đầu khác rỗng thì in hoa
        arr[0] = arr[0].toUpperCase();
    }
    for (let i = 0; i < arr.length ; i++) {
        if (arr[i] === " ") { // nếu phía trước là rỗng thì phần tử tiếp theo in hoa
            arr[i+1] = arr[i+1].toUpperCase();
        }
        print += arr[i];
    }
    alert(print);
}