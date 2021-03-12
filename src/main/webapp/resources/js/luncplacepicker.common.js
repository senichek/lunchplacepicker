var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

$('#mainPageBtn').on('click', function () {
    window.location.href = "";
});

function login(email, password, redirectURL) {
    document.getElementById("username").value = email;
    document.getElementById("password").value = password;
    $("#loginForm").submit();
    window.location.href = redirectURL;
}