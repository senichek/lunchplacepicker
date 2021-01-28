var userID = location.pathname.split('/')[4]; //extracting id from URL
var restaurantUrl = "admin/restaurants/";

debugger;
var table = $('#restaurants_table').DataTable({
    "ajax": {
        "url": restaurantUrl + userID + "/all",
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
        {
            data: null,
            defaultContent: "<button class='menu'>Menus</button>",
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

let tableRowData;

$('#restaurants_table tbody').on('click', '.update', function () {
    tableRowData = table.row($(this).parents('tr')).data();
    showRestaurantUpdateForm(tableRowData);
});

$('#restaurants_table tbody').on('click', '.delete', function () {
    let data = table.row($(this).parents('tr')).data();
    deleteRow(data.id);
});

function deleteRow(id) {
    $.ajax({
        url: restaurantUrl + id,
        type: "DELETE"
    }).done(function () {
        table.ajax.reload();
    });
}

function showRestaurantUpdateForm(tableRowData) {
    $('#restaurantModal').modal('show');
    // Pre-fill the form input fields by current user values;
    document.getElementById("restaurantId").setAttribute('value', tableRowData.id);
    document.getElementById("restaurantName").setAttribute('value', tableRowData.name);
    document.getElementById("restaurantAddress").setAttribute('value', tableRowData.address);
    document.getElementById("restaurantDescription").setAttribute('value', tableRowData.description);
}

$('#allUsers').on('click', function () {
    window.location.href = "admin/users";
});

function saveRestaurant(user) {
    $.ajax({
        type: "POST",
        url: restaurantUrl,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(user)
    }).done(function () {
        table.ajax.reload();
        $("#restaurantModal").modal("hide");
    });
}

$('#saveRestaurantBtn').on('click', function () {
    var restaurant = convertRestaurantFormToObject();
    saveRestaurant(restaurant);
    document.getElementById("restaurantForm").reset();
});

function convertRestaurantFormToObject() {
    var restaurant = {
        id: document.getElementById("restaurantId").value,
        name: document.getElementById("restaurantName").value,
        address: document.getElementById("restaurantAddress").value,
        description: document.getElementById("restaurantDescription").value,
    };
    return restaurant;
}