function checkPrice(){
    let price = document.getElementById("price").value;
    if(price == ""){
        document.getElementById("messPrice").innerHTML = "Không được để trống giá"
    }else if (price < 100000){
        document.getElementById("messPrice").innerHTML ="Giá Phải lớn hơn 100000"
    }else {
        document.getElementById("messPrice").innerHTML =""
    }
}
function checkName(){
    let name = document.getElementById("name").value;
    let regex = /^([a-zA-Zàáạảãăắằẳẵặâấầẩẫậèéẹẻẽêếềểễệđìíịỉĩòóọỏõôốồổỗộơớờởỡợùúụủũưứừửữựỳýỵỷỹ]+\s)*[a-zA-Zàáạảãăắằẳẵặâấầẩẫậèéẹẻẽêếềểễệđìíịỉĩòóọỏõôốồổỗộơớờởỡợùúụủũưứừửữựỳýỵỷỹ]+$/;
    if(name == ""){
        document.getElementById("messName").innerHTML = "Không được để trống tên"
    }else if (regex.test(name)){
        document.getElementById("messName").innerHTML = ""
    }else {
        document.getElementById("messName").innerHTML = "Tên không được chứa kí tự đặc biệt"
    }
}