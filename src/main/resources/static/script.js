//const formOpenBtn = document.querySelector("#form-open"),
home = document.querySelector(".home"),
formContainer = document.querySelector(".form_container"),
signupBtn = document.querySelector("#signup"),
loginBtn = document.querySelector("#login"),
pwShowHide = document.querySelectorAll(".pw_hide"),

checkoutBtn = document.querySelector("#checkout-btn"),
courseForm = document.querySelector("#course-form"),
checkoutForm = document.querySelector("#checkout-form")

if(document.getElementById("details")){
	document.getElementById("details").style.display = "none";
}

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


   function updateFee() {
        var dropdown = document.getElementById("programDropdown");
        var selectedOption = dropdown.options[dropdown.selectedIndex];
        var fee = selectedOption.getAttribute("data-fee");
        document.getElementById("details").style.display = "block";
        document.getElementById("fee-amount").innerText = fee;
        document.getElementById("fee-amount1").innerText = fee;
        if(document.getElementById("fee-amount2")){
			document.getElementById("fee-amount2").value = fee;
		}
        var duration = selectedOption.getAttribute("data-duration");
        document.getElementById("duration").innerText = duration;
        var code = selectedOption.getAttribute("data-code");
        document.getElementById("program-code").value = code;
    }

