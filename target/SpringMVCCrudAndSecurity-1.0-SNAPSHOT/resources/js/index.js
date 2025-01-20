const iFile = document.getElementById("file")
const createBtn = document.getElementById("create-btn")
const emptyFileWarning = document.getElementById("validationfileFeedback")
const fileSizeWarning = document.getElementById("validationFileSize")
const formCreate= document.getElementById("form-create")
const files = iFile.files

if ( window.history.replaceState ) {
    window.history.replaceState( null, null, window.location.href );
}

iFile.onchange=() => {
    if( Math.round((iFile.files.item(0).size/1024)/1024) >= 20){
        createBtn.setAttribute("disabled", "")
        iFile.classList.add("is-invalid")
        emptyFileWarning.innerHTML = ""
        fileSizeWarning.innerHTML = "File size must be less than 20MB"
    }else {
        createBtn.removeAttribute("disabled", "")
        iFile.classList.remove("is-invalid")
        emptyFileWarning.innerHTML = ""
        fileSizeWarning.innerHTML = "File size must be less than 20MB"
    }
    
}



