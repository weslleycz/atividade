const url= window.location.href;
const btn = document.querySelector(".btn-getUser");
const inputCPF = document.querySelector("#j_idt24\\:cpf")

if (url.slice(-1)!="?") {
    if (url.slice(-1)!="??") {
        btn.click();
    }
}

const getCPF = () => {
        if (inputCPF.value ==="") {
            btn.click();
        }
}

