let genderEnum = {
    0: "Nam",
    1: "Nữ"
};
$(document).ready(function () {
    getEmployee("dataTable");
});

/**
 * Get list employee to render to table with id table_id
 * @param table_id the id of table
 */
function getEmployee(table_id) {
    $.ajax({
        type: 'GET',
        url: "/admin/employee/list",
        cache: false,
        timeout: 60000,
        success: function (result) {
            if (result == undefined) {
                return null;
            }
            let table = $('#' + table_id).dataTable({
                "destroy": true,
                "lengthChange": false,
                "pageLength": 20,
                "language": {
                    "info": "_START_ - _END_ of _TOTAL_",
                    "infoEmpty": "Không có bản ghi hiển thị",
                    "infoFiltered": "",
                    "paginate": {
                        "next": ">>",
                        "previous": "<<"
                    },
                    "zeroRecords": "Xin lỗi, không có kết quả nào tương ứng với tìm kiếm của bạn",
                    "emptyTable": "Không tồn tại bản ghi"
                },
                "data": result,
                "columns": [
                    {
                        "data": "username"
                    },
                    {
                        "data": "name",
                    },
                    {
                        "data": "gender",
                        "render": function (data) {
                            return genderEnum[data];
                        }
                    },
                    {
                        "data": "address"
                    },
                    {
                        "data": "phone"
                    },
                    {
                        "data": "birthDay"
                    },
                    {
                        "data": "id",
                        "render": function (data) {
                            return '<span><a class="glyphicon glyphicon-list-alt" href="javascript:void(0)" onclick="getDetail(' + data + ')">Xem chi tiết</a>&ensp;<a class="glyphicon glyphicon-edit" role="button" href="/admin/employee/edit/' + data + '">Chỉnh sửa</a>&ensp;<a class="glyphicon glyphicon-trash" href="javascript:void(0)" role="button" onclick="showModal(' + data + ')">Xóa</a></span>';
                        }
                    },
                ],
                "deferRender": true,
            });
        },
        complete: function () {
            setInterval(getEmployee(table_id), 60000);
        }
    });
}
