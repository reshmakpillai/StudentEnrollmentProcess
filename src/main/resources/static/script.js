//const formOpenBtn = document.querySelector("#form-open"),
home = document.querySelector(".home"),
formContainer = document.querySelector(".form_container"),
signupBtn = document.querySelector("#signup"),
loginBtn = document.querySelector("#login"),
pwShowHide = document.querySelectorAll(".pw_hide"),

checkoutBtn = document.querySelector("#checkout-btn"),
courseForm = document.querySelector("#course-form"),
checkoutForm = document.querySelector("#checkout-form")



//formOpenBtn.addEventListener("click", () => home.classList.add("show"));

pwShowHide.forEach((icon) => {
  icon.addEventListener("click", () => {
    let getPwInput = icon.parentElement.querySelector("input");
    if (getPwInput.type === "password") {
      getPwInput.type = "text";
      icon.classList.replace("uil-eye-slash", "uil-eye");
    } else {
      getPwInput.type = "password";
      icon.classList.replace("uil-eye", "uil-eye-slash");
    }
  });
});

if(signupBtn){
  signupBtn.addEventListener("click", (e) => {
    e.preventDefault();
    formContainer.classList.add("active");
  });
}

if(loginBtn){
  loginBtn.addEventListener("click", (e) => {
    e.preventDefault();
    formContainer.classList.remove("active");
  });
}

if(checkoutBtn){
  checkoutBtn.addEventListener("click", (e) => {
    courseForm.classList.add("d-none");
    checkoutForm.classList.remove("d-none");
      } );   
}


