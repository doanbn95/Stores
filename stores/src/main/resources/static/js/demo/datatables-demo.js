// Call the dataTables jQuery plugin
$(document).ready(function () {
    $('#dataTable').DataTable({
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
      },
    });
});
