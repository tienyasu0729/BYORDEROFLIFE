function part4CaseStudyBai3() {
    let strings1 = prompt("Nhập xâu S1 :");
    let strings2 = prompt("Nhập xâu S2 :");
    // let arrs1 = ["a", "a", "b", "c", "c"]; // test
    // let arrs2 = ["a", "d", "c", "a", "a"]; // test
    let arrs1 = ["a", "a", "b", "c", "c"];
    let arrs2 = ["a", "d", "c", "a", "a"];
    let arr = Array();
    let n = 0;
    let commonCharacterCount = 0;
    let count = 1;
    for (let i = 0; i < strings1.length; i++) {
        arrs1[i] = strings1[i];
    }
    for (let i = 0; i < strings2.length; i++) {
        arrs2[i] = strings2[i];
    }
    for (let i = 0; i < arrs1.length; i++) {
        for (let j = 0; j < arrs2.length; j++) {
            if (arrs1[i] === arrs2[j]) {
                ++commonCharacterCount;
                arr[n] = arrs1[i];
                n++;
                arrs1.splice(i, 1);
                arrs2.splice(j, 1);
                --i;
                --j;
            }
        }
    }
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length; j++) {
            if (arr[i] === arr[j] && i !== j) {
                ++count;
                arr.splice(j, 1);
                --j;
            }
        }
        arr[i] = count + " ký tự " + arr[i];
        count = 1;
    }
    alert(commonCharacterCount);
    alert(arr);
}