var restaurantID = location.pathname.split('/')[4]; //extracting id from URL
var menuUrl = "profile/menus/";

var table = $('#menus_table').DataTable({
    "ajax": {
        "url": menuUrl + restaurantID + "/all/likes",
        "method": "get",
        "type": "json",
        "dataSrc": "",
    },
    "columns": [
        {"data": "id"},
        {"data": "description"},
        {"data": "creationDateTime"},
        {"data": "likesOfMenu.length"},
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

let tableRowData;
$('#menus_table tbody').on('click', '.update', function () {
    let data = tableRowData = table.row($(this).parents('tr')).data();
    showMenuUpdateForm(data);
});

$('#menus_table tbody').on('click', '.delete', function () {
    let data = table.row($(this).parents('tr')).data();
    deleteRow(data.id);
});

$('#addNewMenuBtn').on('click', function () {
    $('#menuModal').modal('show');
    // Id of the restaurant's (userId) owner is taken from URL
    document.getElementById("menuId").setAttribute('value', "");
    document.getElementById("menuImg").setAttribute('value', "");
    document.getElementById("menuDescription").setAttribute('value', "");
});

function deleteRow(id) {
    $.ajax({
        url: menuUrl + id,
        type: "DELETE"
    }).done(function () {
        table.ajax.reload();
    });
}

function showMenuUpdateForm(data) {
    $('#menuModal').modal('show');
    // Pre-fill the form input fields by current user values;
    document.getElementById("menuId").setAttribute('value', data.id);
    document.getElementById("menuImg").setAttribute('value', data.imgUrl);
   // In order to pre-fill <textarea> we do not use .setAttribute();
    document.getElementById('menuDescription').value = data.description;
}

$('#allRestaurants').on('click', function () {
    history.go(-1)
});

function saveMenu(menu) {
    $.ajax({
        type: "POST",
        url: menuUrl + restaurantID,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(menu)
    }).done(function (a, b, text) {
        if (text.responseText != "") {
            failNoty(text.responseText);
            return;
        }
        table.ajax.reload();
        document.getElementById("menuForm").reset();
        $("#menuModal").modal("hide");
    });
}

$('#saveMenuBtn').on('click', function () {
    var menu = convertMenuFormToObject();
    saveMenu(menu);
});

function convertMenuFormToObject() {
    var menu = {
        id: document.getElementById("menuId").value,
        imgUrl: document.getElementById("menuImg").value,
        description: document.getElementById("menuDescription").value
    };
    return menu;
}