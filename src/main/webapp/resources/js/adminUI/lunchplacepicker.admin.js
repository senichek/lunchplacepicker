var adminUrl = "admin/users/";

var table = $('#users_table').DataTable({
    "ajax": {
        "url": adminUrl,
        "method": "get",
        "type": "json",
        "dataSrc": ""
    },
    "columns": [
        {"data": "id"},
        {"data": "name"},
        {"data": "email"},
        {"data": "registered"},
        {'data': 'roles'},
        {
            data: null,
            defaultContent: "<button class='restaurants'>Restaurants</button>",
            orderable: false
        },
        {
            data: null,
            defaultContent: "<button class='update'>Update</button>",
            orderable: false
        },
        {
            data: null,
            defaultContent: "<button class='delete'>Delete</button>",
            orderable: false
        }
    ]
});

$('#users_table tbody').on('click', '.restaurants', function () {
    let data = table.row($(this).parents('tr')).data();
    window.location.href = "admin/" + data.id + "/all";
});

$('#users_table tbody').on('click', '.update', function () {
    let data = table.row($(this).parents('tr')).data();
    document.getElementById("userForm").reset();
    showUserUpdateForm(data);
});

$('#users_table tbody').on('click', '.delete', function () {
    let data = table.row($(this).parents('tr')).data();
    deleteRow(data.id);
});

function deleteRow(id) {
    $.ajax({
        url: adminUrl + id,
        type: "DELETE"
    }).done(function () {
        table.ajax.reload();
    });
}

function showUserUpdateForm(data) {
    $('#userModal').modal('show');
    // Pre-fill the form input fields by current user values;
    document.getElementById("userId").setAttribute('value', data.id);
    document.getElementById("userName").setAttribute('value', data.name);
    document.getElementById("userEmail").setAttribute('value', data.email);
}

$('#addNewUserBtn').on('click', function () {
    document.getElementById("userForm").reset();
    // New user must not have ID, the ID will be generated automatically later;
    $('#userModal').modal('show');
    document.getElementById("userId").setAttribute('value', "");
    document.getElementById("userName").setAttribute('value', "");
    document.getElementById("userEmail").setAttribute('value', "");
});

function saveUser(user) {
    $.ajax({
        type: "POST",
        url: adminUrl,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user)
    }).done(function (a, b, text) {
        if (text.responseText != "") {
            failNoty(text.responseText);
            return;
        }
        table.ajax.reload();
        $("#userModal").modal("hide");
    });
}

$('#saveUserBtn').on('click', function () {
    var user = convertUserFormToObject();
    if (!document.getElementById('role_user').checked
        && (!document.getElementById('role_admin').checked)) {
        alert("Choose at least one role")
    } else {
        saveUser(user);
        //document.getElementById("userForm").reset();
    }
});

function getRolesFromInputForm() {
    var rolesArray = [];
    var checkboxes = document.querySelectorAll('input[type=checkbox]:checked')
    for (var i = 0; i < checkboxes.length; i++) {
        rolesArray.push(checkboxes[i].value)
    }
    return rolesArray;
}

function convertUserFormToObject() {
    var user = {
        id: document.getElementById("userId").value,
        name: document.getElementById("userName").value,
        email: document.getElementById("userEmail").value,
        roles: getRolesFromInputForm()
    };
    return user;
}