$('#enterAsUserBtn').on('click', function () {
    login("user@gmail.com", "user", "restaurants");
});

$('#enterAsAdminBtn').on('click', function () {
    login("admin@gmail.com", "admin", "restaurants");
});