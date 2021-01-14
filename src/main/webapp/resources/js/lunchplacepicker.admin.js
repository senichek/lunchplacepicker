var adminUrl = "rest/admin/users/";
$(document).ready(function () {
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

    /*$('#users_table tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        alert( 'You clicked on '+data.id+'\'s row' );
    } );*/

    $('#users_table tbody').on('click', '.update', function () {
        let data = table.row($(this).parents('tr')).data();
        alert(data.id + " you clicked Update button ");
    });

    $('#users_table tbody').on('click', '.delete', function () {
        let data = table.row($(this).parents('tr')).data();
        alert(data.id + " you clicked Delete button");
        deleteRow(data.id);
    });

    function deleteRow(id) {
        $.ajax({
            url: adminUrl + id,
            type: "DELETE"
        }).done(function () {
            debugger;
            table.ajax.reload();

        });
    }
});