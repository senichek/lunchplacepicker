$('#enterAsUserBtn').on('click', function () {
    login("user@gmail.com", "user", "restaurants");
});

$('#enterAsAdminBtn').on('click', function () {
    login("admin@gmail.com", "admin", "restaurants");
});

$('#loginBtn').on('click', function () {
    var email = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    login(email, password, "restaurants");
});