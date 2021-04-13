var registerUrl = "register";

function convertUserRegFormToObject() {
    var user = {
        name: document.getElementById("userName").value,
        email: document.getElementById("userEmail").value,
        password: document.getElementById("userPassword").value
    };
    if (document.getElementById("userPassword").value == document.getElementById("userPasswordConfirmation").value) {
        return user;
    } else {
        failNoty("[Passwords don't match]")
        return null;
    }
}

$('#registerBtn').on('click', function () {
    var user = convertUserRegFormToObject();
    if (user == null) {
        return;
    } else {
        saveUser(user);
    }
});

function saveUser(user) {
    $.ajax({
        type: "POST",
        url: registerUrl,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user)
    }).done(function (a, b, text) {
        if (text.responseText != "") {
            failNoty(text.responseText);
            return;
        }
        window.location.replace("restaurants")
    });
}