var userID = location.pathname.split('/')[3]; //extracting id from URL
var restaurantUrl = "admin/" + userID;

var table = $('#restaurants_table').DataTable({
    "ajax": {
        "url": restaurantUrl + "/all/likes",
        "method": "get",
        "type": "json",
        "dataSrc": ""
    },
    "columns": [
        {"data": "id"},
        {"data": "name"},
        {"data": "address"},
        {"data": "registerDateTime"},
        {'data': 'description'},
        {"data": "likesOfRestaurant.length"},
        {
            data: null,
            defaultContent: "<button class='menus'>Menus</button>",
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

$('#restaurants_table tbody').on('click', '.menus', function () {
    let data = table.row($(this).parents('tr')).data();
    window.location.href = "admin/menus/" + data.id + "/all";
});

$('#restaurants_table tbody').on('click', '.update', function () {
    let data = table.row($(this).parents('tr')).data();
    showRestaurantUpdateForm(data);
});

$('#restaurants_table tbody').on('click', '.delete', function () {
    let data = table.row($(this).parents('tr')).data();
    deleteRow(data.id);
});

$('#addNewRestBtn').on('click', function () {
    $('#restaurantModal').modal('show');
    // Id of the restaurant's (userId) owner is taken from URL
    document.getElementById("restaurantId").setAttribute('value', "");
    document.getElementById("restaurantName").setAttribute('value', "");
    document.getElementById("restaurantAddress").setAttribute('value', "");
    document.getElementById("restaurantDescription").setAttribute('value', "");
    document.getElementById("restaurantImg").setAttribute('value', "");
});

function deleteRow(id) {
    $.ajax({
        url: restaurantUrl + "/" + id,
        type: "DELETE"
    }).done(function () {
        table.ajax.reload();
    });
}

function showRestaurantUpdateForm(data) {
    $('#restaurantModal').modal('show');
    // Pre-fill the form input fields by current user values;
    document.getElementById("restaurantId").setAttribute('value', data.id);
    document.getElementById("restaurantName").setAttribute('value', data.name);
    document.getElementById("restaurantAddress").setAttribute('value', data.address);
    document.getElementById("restaurantDescription").setAttribute('value', data.description);
    document.getElementById("restaurantImg").setAttribute('value', data.imgUrl);
}

$('#allUsers').on('click', function () {
    window.location.href = "admin/users";
});

function saveRestaurant(restaurant) {
    $.ajax({
        type: "POST",
        url: restaurantUrl,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(restaurant)
    }).done(function (a, b, text) {
        if (text.responseText != "") {
            failNoty(text.responseText);
            return;
        }
        table.ajax.reload();
        document.getElementById("restaurantForm").reset();
        $("#restaurantModal").modal("hide");
    });
}

$('#saveRestaurantBtn').on('click', function () {
    var restaurant = convertRestaurantFormToObject();
    saveRestaurant(restaurant);
});

function convertRestaurantFormToObject() {
    var restaurant = {
        id: document.getElementById("restaurantId").value,
        name: document.getElementById("restaurantName").value,
        address: document.getElementById("restaurantAddress").value,
        description: document.getElementById("restaurantDescription").value,
        imgUrl: document.getElementById("restaurantImg").value
    };
    return restaurant;
}