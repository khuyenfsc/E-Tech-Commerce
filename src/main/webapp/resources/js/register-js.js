const iPassword = document.getElementById("inputPassword")
const iConfirmedPassword = document.getElementById("inputConfirmedPassword")
const iShowPassword = document.getElementById("i-show-password")
const dMatchNoti = document.getElementById("match-noti")
const iRegister = document.getElementById("i-register")

if ( window.history.replaceState ) {
    window.history.replaceState( null, null, window.location.href );
}

iConfirmedPassword.addEventListener("input", ()=>{
    let password = iPassword.value
    let confirmedPassword = iConfirmedPassword.value
    if(password!==confirmedPassword){
        dMatchNoti.innerHTML = "Passwords do not match!"
        dMatchNoti.classList.add("text-danger")
        iRegister.setAttribute("disabled", "")
    }else{
        dMatchNoti.innerHTML = ""
        dMatchNoti.classList.remove("text-danger")
        iRegister.removeAttribute("disabled")
    }
})

iShowPassword.addEventListener("input", ()=>{
    if(iPassword.type === "password"){
        iPassword.type = "text"
        iConfirmedPassword.type = "text"
        
    }else{
        iPassword.type = "password"
        iConfirmedPassword.type = "password"
        
    }
    
})

