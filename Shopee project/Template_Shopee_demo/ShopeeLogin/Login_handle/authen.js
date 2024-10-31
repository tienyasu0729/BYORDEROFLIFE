
var btn_SignUp_Header = document.querySelector('.header_SignUp')
btn_SignUp_Header.addEventListener("click", 
    function(){
        document.querySelector('.modal').setAttribute('style', 'display: flex')
})

var btn_Exit_auForm = document.querySelector('.au_form_controls .btn:first-child')
btn_Exit_auForm.addEventListener("click", 
    function(){
        document.querySelector('.modal').setAttribute('style', 'display: none')
})

var icon_showPass = document.querySelectorAll('.au_form_passeye')
console.log(icon_showPass)
// icon_showPass.addEventListener("click",
//     function(){
        
//         icon_showPass.classList.remove('fa-eye');
//         icon_showPass.classList.add('fa-eye-slash');
//     }
// )