function part2CaseStudyBai2() {
    let alphabet = prompt("Nhập vào đây chữ cái cần kiểm tra là nguyên âm hay phụ âm");
    switch (alphabet) {
        case "u ":
        case "e":
        case "o":
        case "a":
        case "i":
        case "U":
        case "E":
        case "O":
        case "A":
        case "I":
            alert("Chữ cái " + alphabet + " là một nguyên âm");
            break;
        case "b":
        case "c":
        case "d":
        case "f":
        case "g":
        case "h":
        case "j":
        case "k":
        case "l":
        case "m":
        case "n":
        case "p":
        case "q":
        case "r":
        case "s":
        case "t":
        case "v":
        case "w":
        case "x":
        case "y":
        case "z":
        case "B":
        case "C":
        case "D":
        case "F":
        case "G":
        case "H":
        case "J":
        case "K":
        case "L":
        case "M":
        case "N":
        case "P":
        case "Q":
        case "R":
        case "S":
        case "T":
        case "V":
        case "W":
        case "X":
        case "Y":
        case "Z":
            alert("Chữ cái " + alphabet + " là một phụ âm");
            break;
        default :
            alert("Không tìm thấy hoặc bạn nhập vào không đúng");
    }
}