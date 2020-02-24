$(document).ready(function () {
    //Load Image
    $("#image_file").change(function (e) {
        loadImage(this)
    });
    let table = $('#dataTable');
    table.dataTable({
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
            zeroRecords: "Xin lỗi, không có kết quả nào tương ứng với tìm kiếm của bạn",
            "emptyTable": "Không tồn tại bản ghi"
        }
    });

});

/**
 * The load image url
 * @param input
 */
function loadImage(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#image_view').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
