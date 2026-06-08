function updateUserPasswordCheck() {
    const newPassword = document.getElementById("newPassword").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    const lengthCheck = newPassword.length >= 6;
    const uppercaseCheck = /[A-Z]/.test(newPassword);
    const numberCheck = /\d/.test(newPassword);
    const matchCheck = newPassword === confirmPassword;

    document.getElementById("length").className = lengthCheck ? "text-success" : "text-danger";
    document.getElementById("uppercase").className = uppercaseCheck ? "text-success" : "text-danger";
    document.getElementById("number").className = numberCheck ? "text-success" : "text-danger";
    document.getElementById("match").className = matchCheck ? "text-success" : "text-danger";
}

function signUpPasswordCheck() {

    const password = document.getElementById("passwordId").value;
    const confirmPassword = document.getElementById("signupConfirmPassword").value;
    const signUpButton = document.getElementById("signUpButtonId");

    const lengthCheck = password.length >= 6;
    const upperCheck = /[A-Z]/.test(password);
    const numberCheck = /\d/.test(password);
    const matchCheck = password === confirmPassword;

    document.getElementById("length").className = lengthCheck ? "text-success" : "text-danger";
    document.getElementById("uppercase").className = upperCheck ? "text-success" : "text-danger";
    document.getElementById("number").className = numberCheck ? "text-success" : "text-danger";
    document.getElementById("match").className = matchCheck ? "text-success" : "text-danger";

    signUpButton.disabled = !(lengthCheck && upperCheck && numberCheck && matchCheck);
}

function setupPasswordToggle(passwordInputId, iconId) {

    const passwordInput = document.getElementById(passwordInputId);
    const toggleIcon = document.getElementById(iconId);

    toggleIcon.addEventListener("click", function() {
        let isPassword;
        if (passwordInput.type === "password") {
            isPassword = true;
        } else {
            isPassword = false;
        }

    passwordInput.type = isPassword ? "text" : "password";

    toggleIcon.classList.toggle("bi-eye");
    toggleIcon.classList.toggle("bi-eye-slash");
    });
}