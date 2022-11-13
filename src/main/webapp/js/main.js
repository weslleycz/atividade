const url= window.location.href;
const btn = document.querySelector(".btn-getUser");

if (url!="http://localhost:8080/?") {
    btn.click();
}