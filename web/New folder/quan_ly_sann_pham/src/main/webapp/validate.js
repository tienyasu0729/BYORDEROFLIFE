function checkName(){
    let name = document.getElementById("name").value;
    let regex = /^([a-zA-Zàáạảãăắằẳẵặâấầẩẫậèéẹẻẽêếềểễệđìíịỉĩòóọỏõôốồổỗộơớờởỡợùúụủũưứừửữựỳýỵỷỹ]+\s)*[a-zA-Zàáạảãăắằẳẵặâấầẩẫậèéẹẻẽêếềểễệđìíịỉĩòóọỏõôốồổỗộơớờởỡợùúụủũưứừửữựỳýỵỷỹ]+$/;
    if(name == ""){
        document.getElementById("messName").innerHTML = "Không được để trống tên"
    }else if (regex.test(name)){
        document.getElementById("messName").innerHTML = ""
    }else {
        document.getElementById("messName").innerHTML = "Tên không được chứa số hoặc kí tự đặc biệt"
    }
}