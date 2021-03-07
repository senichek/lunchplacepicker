var registerUrl = "register";

function convertUserRegFormToObject() {
    var user = {
        name: document.getElementById("userName").value,
        email: document.getElementById("userEmail").value,
        password: document.getElementById("userPassword").value
    };

    debugger;
    if (document.getElementById("userPassword").value == document.getElementById("userPasswordConfirmation").value) {
        return user;
    } else {
        alert("Passwords don't match");
    }
}

/*$('#loginBtn').on('click', function () {
    debugger;
    document.getElementById("userEmail").value = "user@gmail.com";
    document.getElementById("userPassword").value = "user";
    $("#loginForm").submit();
});*/

$('#enterAsUserBtn').on('click', function () {
    login("user@gmail.com", "user", "restaurants");
});

$('#enterAsAdminBtn').on('click', function () {
    login("admin@gmail.com", "admin", "restaurants");
});

function login(email, password, redirectURL) {
    debugger;
    document.getElementById("username").value = email;
    document.getElementById("password").value = password;
    $("#loginForm").submit();
    window.location.href = redirectURL;
}