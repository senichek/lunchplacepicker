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

$('#registerBtn').on('click', function () {
    var user = convertUserRegFormToObject();
    if (user == null) {
        $("#signUpForm").submit(function(event) {
            event.preventDefault(); // Preventing the form submission if the data (e.g. passwords do not match) is incorrect
        });
    } else {
        saveUser(user);
        window.open("restaurants");
    }
});

function saveUser(user) {
    $.ajax({
        type: "POST",
        url: registerUrl,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user)
    }).done(function () {
        alert("Success");
    });
}