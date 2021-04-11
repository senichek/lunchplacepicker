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

function saveLike(like, entityID, URL) {
    $.ajax({
        type: 'POST',
        url: URL + entityID,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(like)
    }).done(function (text) {
        debugger;
        if (text != "") {
            failNoty(text);
        }
        updateLikesCounter();
    });
}

function failNoty(errorText) {
    new Noty({
        text: errorText,
        type: "error",
        layout: "bottomRight"
    }).show();
}

function infoNoty(message) {
    new Noty({
        text: message,
        type: "information",
        layout: "topCenter"
    }).show();
}