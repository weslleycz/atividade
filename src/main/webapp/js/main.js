const url= window.location.href;
const btn = document.querySelector(".btn-getUser");

if (url.slice(-1)!="?") {
    btn.click();
}